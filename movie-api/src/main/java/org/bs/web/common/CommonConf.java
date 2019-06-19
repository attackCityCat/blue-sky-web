package org.bs.web.common;

public class CommonConf {

    public static final String ORDER_KEY = "orderKey";

    public static final String  NOTE_KEY ="noteKey";

    public static final  Long  ORDER_TIME_OUT = 10L;

    /**
     * 短信验证码接口地址
     */
    public   static  final   String   SMS_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    /**
     * 短信验证  开发者主账号ID
     */
    // public   static  final   String   SMS_ACCOUNTSID = "9abff00fd151499a97a7d36d01142bd1";
    public   static  final   String   SMS_ACCOUNTSID = "077945a7ee754bd1a108adc8ba860887";

    /**
     *
     */
    //  public   static  final   String   SMS_AUTH_TOKEN = "5794d15d20fe4a6eb321bc29c12f2159";
    public   static  final   String   SMS_AUTH_TOKEN = "5bcab44dbda54b60bc76e4942d8a28bd";

    /**
     * 短信模板ID
     */
//	   public   static  final   String   SMS_TEMPLATEID = "1556658863";
    public   static  final   String   SMS_TEMPLATEID = "1683308697";

    /**
     * 短信 请求状态码 0000 成功
     */
    public   static  final   String   SMS_RESPCODE = "00000";

    // 验证码过期时间  单位 分钟
    public static final Long SMS_CODE_TIME_OUT = 5L;
    // 验证码
    public static final String SMS_CODE_CACHE_KEY = "smscode";
    // 短信验证码重复锁
    public static final String SMS_CODE_LOCK = "lock";
    // 重读获取短信验证码锁时间  单位 秒
    public static final Long SMS_CODE_LOCK_TIME = 60L;

    //放映厅座位信息 key
    public static final String HALL_SEATS_KEY = "hallSeats";

    //具体座位信息key
    public static final String SEATS_INFO_KEY = "seatInfo";

    //排期座位信息缓存key
    public static final String PAI_QI_SEATS_KEY = "paiQiSeats";

    // 排期信息缓存键
    public static final String PAI_QI_KEY = "paiqi";
}
