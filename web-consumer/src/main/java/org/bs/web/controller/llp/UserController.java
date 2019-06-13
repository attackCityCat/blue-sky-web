package org.bs.web.controller.llp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.bs.web.constant.Conts;
import org.bs.web.pojo.UserBean;
import com.sun.jmx.snmp.Timestamp;
import org.bs.web.service.llp.UserServiceApi;
import org.bs.web.util.HttpClientUtil;
import org.bs.web.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private UserServiceApi userServiceApi;

    /**
     * 登陆操作根据手机号登陆
     *
     * @param userBean
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String, Object> login(UserBean userBean, HttpServletRequest request) {

        HttpSession session = request.getSession();

        HashMap<String, Object> result = new HashMap<String, Object>();

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getPhoneNumber(), userBean.getPassword());

        try {
            subject.login(token);
            UserBean user = (UserBean) subject.getPrincipal();
            session.setAttribute(session.getId(), user);
            result.put("code", 0);
            result.put("msg", "登录成功");
            return result;
        } catch (UnknownAccountException e) {
            result.put("code", 1);
            result.put("msg", "用户名不存在");
            return result;
        } catch (IncorrectCredentialsException e) {
            result.put("code", 2);
            result.put("msg", "密码错误");
            return result;
        }
    }

    /**
     * 获取注册验证码
     *
     * @param phone
     * @return
     * @throws Exception
     */
    @RequestMapping("/getVerify")
    @ResponseBody
    public HashMap<String, Object> getVerify(String phone) throws Exception {
        //先构造一个map
        HashMap<String, Object> map = new HashMap<>();
        //验证码在redis里的key
        Boolean hasKey = redisTemplate.hasKey(Conts.VERIFY + phone);
        if (hasKey) {
            //如果有提示用户请勿重复获取
            map.put("code", 1);
            map.put("msg", "验证码有限期内，请勿重复获取验证码");
            return map;
        }
        // 随机获取6位数的验证码
        int param = (int) ((Math.random() * 9 + 1) * 100000);
        // 要获取验证码的手机号
        map.put("to", phone);
        // param验证码
        map.put("param", param);
        // 接口账号id
        map.put("accountSid", Conts.ACCOUNT_SID);
        // timestamp String 必选 时间戳。当前系统时间（24小时制），格式"yyyyMMddHHmmss"。时间戳有效时间为5分钟。
        // 获取时间戳
        Timestamp timestamp = new Timestamp(new Date().getTime());
        map.put("timestamp", timestamp);
        // sig签名然后MD5加密 格式为(ACCOUNT SID + AUTH TOKEN + timestamp)。共32位（小写）。
        String sig = Conts.ACCOUNT_SID + Conts.AUTH_TOKEN + timestamp;
        String md5 = MD5Util.getMD5(sig);
        map.put("sig", md5);
        // 接口短信模板id
        map.put("templateid", Conts.TEMPLATE_LSID);
        // 发请求连接接口 将url和map参数放到参数中
        String string = HttpClientUtil.post(Conts.NOTE_URL, map);
        JSONObject parseObject = JSON.parseObject(string);
        // 请求成功的代码00000
        String string2 = parseObject.getString("respCode");
        if (string2.equals("00000")) {
            // 将验证码存到redis缓存中,并设置过期时间
            redisTemplate.opsForValue().set(Conts.VERIFY + phone, param, Conts.TIME, TimeUnit.SECONDS);

            map.put("code", 0);
            map.put("msg", "验证码已发送请注意查收");
            return map;
        }
        return map;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public HashMap<String, Object> addUser(UserBean userBean) {

        HashMap<String, Object> map = new HashMap<>();

        Object o = redisTemplate.opsForValue().get(Conts.VERIFY + userBean.getPhoneNumber());
        System.out.println(o);

        if (!userBean.getVerify().equals(o.toString())) {
            map.put("code", 3);
            map.put("msg", "验证码不正确");
            return map;
        }

        UserBean phone = userServiceApi.findByPhone(userBean.getPhoneNumber());

        if (phone != null) {
            map.put("code", 1);
            map.put("msg", "账号已经存在");
            return map;
        }

        Boolean boo = userServiceApi.addUser(userBean);

        if (!boo) {
            map.put("code", 2);
            map.put("msg", "系统故障");
            return map;
        }

        map.put("code", 0);
        map.put("msg", "注册成功");
        return map;
    }
}
