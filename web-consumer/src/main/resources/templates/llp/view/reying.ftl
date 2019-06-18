<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>大眼睛票务</title>
    <javascript:tan()--layui轮播-->
    <link href="/llp/layui/css/layui.css" rel="stylesheet"/>
    <script src="/llp/layui/layui.js" type="text/javascript"></script>

    <script charset="UTF-8" type="text/javascript" src="/llp/Personal/layer.js">
    </script>
    <link rel="stylesheet" href="/llp/Personal/layer.css">

    <link href="/llp/css/base.min.css" rel="stylesheet"/>
    <link href="/llp/css/jquery.flexslider.css" rel="stylesheet"/>
    <link href="/llp/css/main.min.css" rel="stylesheet"/>
    <script src="/llp/js/jquery.1.7.2.min.js" type="text/javascript"></script>
    <script src="/llp/js/json2.min.js" type="text/javascript"></script>
    <script src="/llp/js/jquery.tool.tabs.min.js" type="text/javascript"></script>
    <script src="/llp/js/helper.js" type="text/javascript"></script>
    <script src="/llp/js/jquery.flexslider.min.js" type="text/javascript"></script>

</head>

<body>
<script type="text/javascript">

    function loginOut() {
        location.href = "/llp/loginOut";
    }
</script>
<div class="header">
    <div class="adv-top"></div>
    <div class="tip-web">尊敬的用户：大眼睛网站<strong>【电影售票系统】</strong> 目前正处于开展测试阶段，如有不足之处，敬请谅解，感谢您关注本网站！</div>
    <div class="header-nav">
        <div><#if user??>
                您好用户 ${user.name}，欢迎访问大眼睛票务网!           <a href="javascript:loginOut()">退出登录</a>
            <#else>
                您好，欢迎访问大眼睛票务网，请 <a href="http://localhost:8082/llp/toLogin">登录</a>     <a
                    href="http://localhost:8082/llp/reg">免费注册</a>
            </#if>
            <ul class="user-menu clearfix">
                <li class="my-eye"><a href="javascript:;">我的大眼睛</a><span class="animate"></span>
                    <div class="son hide"><p><a href="javascript:toPersonal()">个人资料</a></p>
                        <p><a href="javascript:tan()">我的新影联卡</a></p></div>
                </li>
                <li><a href="javascript:toOrder()">我的订单</a></li>
                <li>关注大眼睛</li>
                <li class="tel-film">电影热线：189-0310-0844</li>
                <li class="tel-perform">演出热线：189-0310-0844</li>
            </ul>
        </div>
    </div>
    <div class="search-box clearfix">
        <div class="logo"><a href="javascript:toMain()"><img
                        src="https://lantianjihua.oss-cn-beijing.aliyuncs.com/logo.jpg" alt="大眼睛票务网"></a></div>
        <div class="search">
            <div class="search-input">
                <input type="text" name="keywords" placeholder="请输入电影进行搜索">
                <span class="submit">搜索</span>
            </div>
            <div class="search-hot hide">
                <a href="javascript:void(0);">星际特工</a>
                <a href="javascript:void(0);">赛车总动员3</a>
                <a href="javascript:void(0);">极盗车神</a>
            </div>
        </div>
    </div>
    <div class="main-nav">
        <div class="container clearfix">
            <ul class="menu clearfix">
                <li><a href="javascript:toMain()" data-index="index" class="act">首页</a></li>
                <li><a href="javascript:tan()" data-index="filmshowing">热映影片</a></li>
                <li><a href="javascript:tan()" data-index="filmfeature">即将上映</a></li>
                <li><a href="javascript:tan()" data-index="cinemas">影院</a></li>
            </ul>
            <ul class="other clearfix">
                <li><a href="javascript:tan()">新影联票卡产品</a></li>
                <li><a href="javascript:tan()">新影联院线</a></li>
            </ul>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    function toPersonal() {
        location.href="/llp/toPersonal";
    }
    function toOrder() {
        location.href="/llp/toOrder";
        //javascript:toOrder()
    }
    function toMain() {
        location.href="/llp/toMain";
    }

</script>
<javascript:tan()--中间内容-->
<#--<div class="main homepage">
    <div class="mbanner flexslider">
    </div>
</div>-->
<div class="main filmshowingpage">
    <div class="crumb">
        <p><span>大眼睛</span><i>&gt;</i><span>热映影片</span></p>
        <div class="search-box-films clearfix">
            <p class="des">共为您搜出<strong>56</strong>部影片</p>
        </div>
    </div>
    <div class="film-list">
        <ul class="clearfix">
            <li class="">
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=f895913b-168d-4ba2-b6ab-f83322f19f1a&amp;filmname=%E9%BB%91%E8%A1%A3%E4%BA%BA%EF%BC%9A%E5%85%A8%E7%90%83%E8%BF%BD%E7%BC%89&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="/llp/js/img/20190403170756.jpg" alt="黑衣人：全球追缉"></a>
                    <div class="film-layer" style="bottom: -75px;">
                        <div class="info">
                            <p>类型：动作,科幻,冒险</p> <p>片长：115分钟</p> <p>187家影院上映4465场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                </div>
                <h3 class="texthide">黑衣人：全球追缉<span class="price"><strong class="" style="color: #1BA4E5;">¥0</strong>起</span></h3>
            </li>
            <li class="">
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=51a1de33-db4a-403c-8c35-a69ddce6e84e&amp;filmname=X%E6%88%98%E8%AD%A6%EF%BC%9A%E9%BB%91%E5%87%A4%E5%87%B0&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="../js/热映影片_大眼睛票务.电影_files/20190520111235.jpg" alt="X战警：黑凤凰"></a>
                    <div class="film-layer" style="bottom: -75px;">
                        <div class="info">
                            <p>类型：动作,冒险,科幻</p><p>片长：114分钟</p><p>199家影院上映2878场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                </div>
                <h3 class="texthide">X战警：黑凤凰<span class="price"><strong class="" style="color: #1BA4E5;">¥24</strong>起</span></h3>
            </li>
            <li class="">
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=f1bef09e-5c1a-4bfa-868d-7bb238f0caca&amp;filmname=%E6%9C%80%E5%A5%BD%E7%9A%84%E6%88%91%E4%BB%AC&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="../js/热映影片_大眼睛票务.电影_files/20190523093103.jpg" alt="最好的我们">
                    </a>
                    <div class="film-layer" style="bottom: -75px;">
                        <div class="info">
                            <p>类型：爱情,青春</p><p>片长：110分钟</p><p>199家影院上映2052场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                </div>
                <h3 class="texthide">最好的我们<span class="price"><strong class="" style="color: #1BA4E5;">¥0</strong>起</span></h3>
            </li>
            <li class="">
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=75488d90-f94a-456b-a628-03d27d6a4219&amp;filmname=%E5%93%A5%E6%96%AF%E6%8B%892%EF%BC%9A%E6%80%AA%E5%85%BD%E4%B9%8B%E7%8E%8B&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="../js/热映影片_大眼睛票务.电影_files/20190425101647.jpg" alt="哥斯拉2：怪兽之王">
                    </a>
                    <div class="film-layer" style="bottom: -75px;">
                        <div class="info">
                            <p>类型：动作,惊悚,科幻</p><p>片长：132分钟</p><p>192家影院上映1893场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                </div>
                <h3 class="texthide">哥斯拉2：怪兽之王<span class="price"><strong class="" style="color: #1BA4E5;">¥0</strong>起</span></h3>
            </li>
            <li class="">
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=8434055f-a923-4db1-8652-d59a665e057b&amp;filmname=%E8%BF%BD%E9%BE%99%E2%85%A1&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="../js/热映影片_大眼睛票务.电影_files/20190603092448.jpg" alt="追龙Ⅱ">
                    </a>
                    <div class="film-layer" style="bottom: -75px;">
                        <div class="info">
                            <p>类型：犯罪,剧情,动作</p><p>片长：103分钟</p><p>194家影院上映1398场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                </div>
                <h3 class="texthide">追龙Ⅱ<span class="price"><strong class="" style="color: #1BA4E5;">¥32</strong>起</span></h3>
            </li>
            <li>
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=f3175baa-4335-4181-baf2-fcdae91ecc09&amp;filmname=%E5%A6%88%E9%98%81%E6%98%AF%E5%BA%A7%E5%9F%8E&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="../js/热映影片_大眼睛票务.电影_files/20190523104552.jpg" alt="妈阁是座城">
                    </a>
                    <div class="film-layer">
                        <div class="info">
                            <p>类型：爱情,剧情</p><p>片长：127分钟</p><p>149家影院上映1241场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                    <span class="tag"></span>
                </div>
                <h3 class="texthide">妈阁是座城<span class="price"><strong style="color: #1BA4E5;">¥0</strong>起</span></h3>
            </li>
            <li>
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=f415347a-8876-4891-820d-5c8f6402a9e2&amp;filmname=%E9%98%BF%E6%8B%89%E4%B8%81&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="../js/热映影片_大眼睛票务.电影_files/20190523094248.jpg" alt="阿拉丁">
                    </a>
                    <div class="film-layer">
                        <div class="info">
                            <p>类型：爱情,奇幻,冒险</p><p>片长：128分钟</p><p>160家影院上映1004场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                </div>
                <h3 class="texthide">阿拉丁<span class="price"><strong style="color: #1BA4E5;">¥25.9</strong>起</span></h3>
            </li>
            <li>
                <div class="flogo">
                    <a href="http://www.daeyes.com.cn/filmdetail.html?filmid=c21a8218-5c04-4004-aad8-c8c3783f01be&amp;filmname=%E7%BB%9D%E6%9D%80%E6%85%95%E5%B0%BC%E9%BB%91&amp;crumb=%E7%83%AD%E6%98%A0%E5%BD%B1%E7%89%87">
                        <img class="logo" src="../js/热映影片_大眼睛票务.电影_files/20190523104004.jpg" alt="绝杀慕尼黑">
                    </a>
                    <div class="film-layer">
                        <div class="info">
                            <p>类型：剧情,运动</p><p>片长：120分钟</p><p>176家影院上映866场</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                    <span class="tag"></span>
                </div>
                <h3 class="texthide">绝杀慕尼黑<span class="price"><strong style="color: #1BA4E5;">¥0</strong>起</span></h3>
            </li>
        </ul>
    </div>


<!-- tan -->
<script type="text/javascript">
    function tan(){
        layer.msg("功能正在开发中！~~")
    }
</script>


<javascript:tan()--底部-->
<div class="footer">
    <div class="nav-quick">
        <ul class="clearfix">
            <li>
                <h3>新手指南</h3>
                <p><i>&gt;</i><a href="javascript:tan()">在线订购</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">电话订购</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">上门订购</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">大客户团体订购</a></p>
            </li>
            <li>
                <h3>配送方式</h3>
                <p><i>&gt;</i><a href="javascript:tan()">送货上门</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">电子票</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">上门自取</a></p>
            </li>
            <li>
                <h3>支付方式</h3>
                <p><i>&gt;</i><a href="javascript:tan()">电话支付</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">柜台支付</a></p>
            </li>
            <li>
                <h3>账户安全</h3>
                <p><i>&gt;</i><a href="javascript:tan()">找回密码</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">账户注册</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">账户绑定</a></p>
            </li>
            <li>
                <h3>售后服务</h3>
                <p><i>&gt;</i><a href="javascript:tan()">退换及缺货说明</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">发票帮助</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">验票说明</a></p>
            </li>
            <li>
                <h3>特色服务</h3>
                <p><i>&gt;</i><a href="javascript:tan()">大眼睛卡</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">积分商城</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">票务系统</a></p>
                <p><i>&gt;</i><a href="javascript:tan()">场馆库</a></p>
            </li>
            <li class="code">
                <div class="container">
                    <p>
                        <img src="https://lantianjihua.oss-cn-beijing.aliyuncs.com/mmqrcode1539265658727.png"
                             alt="公众号二维码"></p>
                    <p>扫描关注大眼睛</p>
                </div>
            </li>
        </ul>
    </div>
    <div class="copyright">
        <div class="nav-copyright clearfix">
            <ul class="clearfix">
                <li><a href="javascript:tan()">公司介绍</a></li>
                <li><a href="javascript:tan()">合作机会</a></li>
                <li><a href="javascript:tan()">法律公告</a></li>
                <li><a href="javascript:tan()">友情链接</a></li>
                <li><a href="javascript:tan()">联系我们</a></li>
            </ul>
        </div>
        <p>北京新影联文化传播有限责任公司 版权所有 Copyright 2003-2017 All Rights Reserved 京ICP备12006157号 营业性演出许可证 编号：京演（机构）［2017］3083号</p>
        <p>京公网安备 11010102002123号</p>
    </div>
</div>
</body>
</html>