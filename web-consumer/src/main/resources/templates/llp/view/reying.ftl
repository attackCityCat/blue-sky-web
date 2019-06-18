<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>大眼睛票务</title>
<#--原引入-->
<#--    <link href="/llp/css/base.min.css" rel="stylesheet"/>
    <link href="/llp/css/jquery.flexslider.css" rel="stylesheet"/>
    <link href="/llp/css/main.min.css" rel="stylesheet"/>
    <script src="/llp/js/jquery.1.7.2.min.js" type="text/javascript"></script>
    <script src="/llp/js/json2.min.js" type="text/javascript"></script>
    <script src="/llp/js/jquery.tool.tabs.min.js" type="text/javascript"></script>
    <script src="/llp/js/helper.js" type="text/javascript"></script>
    <script src="/llp/js/jquery.flexslider.min.js" type="text/javascript"></script>
    <script src="/llp/js/layui.js" type="text/javascript"></script>-->
<#--参考引入-->
<#--    <link href="../js/热映影片_大眼睛票务.电影_files/base.min.css" rel="stylesheet">
    <link href="../js/热映影片_大眼睛票务.电影_files/main.min.css" rel="stylesheet">
    <script src="../js/热映影片_大眼睛票务.电影_files/jquery.1.7.2.min.js.下载" type="text/javascript"></script>
    <script src="../js/热映影片_大眼睛票务.电影_files/json2.min.js.下载" type="text/javascript"></script>
    <script src="../js/热映影片_大眼睛票务.电影_files/jquery.tool.tabs.min.js.下载" type="text/javascript"></script>
    <script src="../js/热映影片_大眼睛票务.电影_files/helper.js.下载" type="text/javascript"></script>-->

    <link href="/reying/base.min.css" rel="stylesheet">
    <link href="/reying/main.min.css" rel="stylesheet">
    <script src="/reying/jquery.1.7.2.min.js" type="text/javascript"></script>
    <script src="/reying/json2.min.js" type="text/javascript"></script>
    <script src="/reying/jquery.tool.tabs.min.js" type="text/javascript"></script>
    <script src="/reying/helper.js" type="text/javascript"></script>


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
                <li><a href="javascript:toMain()" data-index="index" >首页</a></li>
                <li><a href="javascript:" data-index="filmshowing" class="act">热映影片</a></li>
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
    /*跳转脚本*/
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
<div class="main filmshowingpage">
    <div class="crumb">
        <p>
            <span>大眼睛</span><i>&gt;</i><span>热映影片</span>
        </p>

        <div class="search-box-films clearfix">
            <p class="des">共为您搜出<strong>#{count}</strong>部影片</p>
        </div>
    </div>


    <div class="film-list">
        <ul class="clearfix">
            <#list list as i >
            <li class="">
                <div class="flogo">
                    <a  href="#">
                        <img class="logo" src="${i.img}" alt="黑衣人：全球追缉">
                    </a>
                    <div class="film-layer" style="bottom: -75px;">
                        <div class="info">
                            <p>类型：${i.tagName}</p>
                            <p>片长：${i.length}分钟</p>
                        </div>
                        <div class="mask"></div>
                    </div>
                </div>
                <h3 class="texthide">${i.name}
                    <span class="price">
							<strong class="">¥${i.price}</strong>
						</span>
                </h3>
            </li>
            </#list>
        </ul>
    </div>
</div>




    <!-- tan -->
<script type="text/javascript">
    function tan(){
       alert("功能正在开发中！~~")
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