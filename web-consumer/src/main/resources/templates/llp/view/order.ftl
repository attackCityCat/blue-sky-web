<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>个人中心</title>
    <link href="/llp/css/base.min.css" rel="stylesheet"/>
    <link href="/llp/css/jquery.flexslider.css" rel="stylesheet"/>
    <link href="/llp/css/main.min.css" rel="stylesheet"/>
    <script src="/llp/js/jquery.1.7.2.min.js" type="text/javascript"></script>
    <script src="/llp/js/json2.min.js" type="text/javascript"></script>
    <script src="/llp/js/jquery.tool.tabs.min.js" type="text/javascript"></script>
    <script src="/llp/js/helper.js" type="text/javascript"></script>
    <script src="/llp/js/jquery.flexslider.min.js" type="text/javascript"></script>

    <#--bootstrap-->
    <script type="text/javascript" src="/bootstrap-4/jquery.min.js"></script>
    <script type="text/javascript" src="/bootstrap-4/js/bootstrap.js"></script>

    <#--layui的js和css-->
    <script type="text/javascript" src="/llp/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="/llp/layui/css/layui.css">
    <#--个人中心所有js和css-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--全局-->
    <link rel="stylesheet" type="text/css" href="/llp/Personal/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/llp/Personal/common.css">
    <link href="http://www.daeyes.com/portal/eyes/favicon.ico" mce_href="favicon.ico" rel="bookmark"
          type="image/x-icon">
    <link href="http://www.daeyes.com/portal/eyes/favicon.ico" mce_href="favicon.ico" rel="icon" type="image/x-icon">
    <link href="http://www.daeyes.com/portal/eyes/favicon.ico" mce_href="favicon.ico" rel="shortcut icon"
          type="image/x-icon">
    <script charset="utf-8" src="/llp/Personal/v.js"></script>
    <script src="/llp/Personal/hm.js"></script>
    <script charset="UTF-8" type="text/javascript" src="/llp/Personal/jquery.js"></script>
    <script charset="UTF-8" type="text/javascript" src="/llp/Personal/jquery-form.js"></script>
    <script charset="UTF-8" type="text/javascript" src="/llp/Personal/jquery.cookie.js"></script>
    <script charset="UTF-8" type="text/javascript" src="/llp/Personal/layer.js">
    </script>
    <link rel="stylesheet" href="/llp/Personal/layer.css">
    <script charset="UTF-8" type="text/javascript" src="/llp/Personal/public.js"></script>

    <style>
        .tongz {
            width: 100%;    color: #666;    padiving-top: 8px;    padiving-bottom: 8px;    text-align: center;    background-color: #FFFBEF; border-bottom: 1px solid #e1e1e1;   overflow: hidiven;
        }

    </style>

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
                    <div class="son hide"><p><a href="#">个人资料</a></p>
                        <p><a href="#">我的新影联卡</a></p></div>
                </li>
                <li><a href="#">我的订单</a></li>
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
                <li><a href="#" data-index="filmshowing">热映影片</a></li>
                <li><a href="#" data-index="filmfeature">即将上映</a></li>
                <li><a href="#" data-index="cinemas">影院</a></li>
            </ul>
            <ul class="other clearfix">
                <li><a href="#">新影联票卡产品</a></li>
                <li><a href="#">新影联院线</a></li>
            </ul>
        </div>
    </div>
</div>
</div>
<#--中间内容-->
<script charset="UTF-8" type="text/javascript" src="/llp/Personal/WdatePicker.js"></script>
<script charset="UTF-8" type="text/javascript" src="/llp/Personal/index.js"></script>
<link rel="stylesheet" type="text/css" href="/llp/Personal/help.css">
<link rel="stylesheet" type="text/css" href="/llp/Personal/index.css">

<div class="wt1194 middle" style="margin-bottom: 20px;">

    <div class="wt1194 middle" style="margin-bottom: 20px;">

        <DIV class="left leftmenu">
            <DIV style="padding: 0px 24px;">
                <H1>管理中心</H1></DIV>
            <UL>
                <LI>
                    <DL>
                        <DT>订单管理</DT>
                        <DD><A class='current ' href="#">我的订单</A></DD>
                        <DD><A class=' ' href="javascript:tan()">PC电影订单</A></DD>
                        <DD><A class=' ' href="javascript:tan()">演出订单</A></DD>
                        <DD><A class=' ' href="javascript:tan()">秒杀订单</A></DD>
                        <DD><A class=' ' href="javascript:tan()">缺货登记</A></DD>
                    </DL>
                </LI>
                <LI>
                    <DL>
                        <DT>会员中心</DT>
                        <DD><A class=' ' href="javascript:toPersonal()">个人资料</A></DD>
                        <DD><A class=' ' href="javascript:tan()">账户安全</A></DD>
                        <DD><A class='' href="javascript:tan()">我的关注</A></DD>
                        <DD><A class=' ' href="javascript:tan()">我的新影联票卡</A></DD>
                    </DL>
                </LI>
            </UL>
        </DIV>
        <DIV class="menuright">
            <div class="U_title clearfix">

                    <div class="demoTable">
                        订单搜索：
                        <div class="layui-inline">
                            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
                        </div>
                        <button class="layui-btn" data-type="reload">搜索</button>
                    </div>
            </div>
            <div id="DataList" class="clearfix">
                <#--layui 的数据表格-->
<#--                <table class="layui-hide" id="orderTableId"></table>-->
                <table class="layui-hide" id="orderTableId" lay-filter="user"></table>
            </div>

            <div id="Pagination" class="pagination" style='padding:20px 50px 50px 50px;'></div>
        </div>
    </DIV>
</div>
</div>

<script type="text/javascript">

    $(function () {
        show();
    })
    //订单展示表格信息
    function show() {
        layui.use('table', function(){
            var table = layui.table;
            //方法级渲染
            table.render({
                elem: '#orderTableId'
                ,url: '/llp/findOrderByUserId'
                ,cols: [[
                    {checkbox: true, fixed: true}
                    ,{field:'movieName', title: '电影名', width:100, sort: true, fixed: true}
                    ,{field:'length', title: '时长', width:70}
                    ,{field:'yuyan', title: '语言', width:80}
                    ,{field:'hallName', title: '放映厅', width:100, sort: true}
                    ,{field:'seatRow', title: '座位行号', width:86}
                    ,{field:'seatCol', title: '座位列号',width:86}
                    ,{field:'orderNum', title: '订单号', sort: true, width:212}
                    ,{field:'transaction', title: '交易时间', sort: true, width:170}
                ]]
                ,id: 'testReload'
                ,page: true
                ,height: 310
            });

            var $ = layui.$, active = {
                reload: function(){
                    var demoReload = $('#demoReload');
                    //执行重载
                    table.reload('testReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                                hello: demoReload.val()
                        }
                    }, 'data');
                }
            };

            $('.demoTable .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
        });
    }
    function tan() {
        layer.msg("功能正在开发中！~~")
    }
    function toPersonal() {
        location.href="/llp/toPersonal";
    }

    function toMain() {
        location.href="/llp/toMain";
    }
</script>


<!--右侧悬浮按钮-->

<div class="PosFixNavR">
    <a class="a1" style="background-position: right 0px;" href="javascript:void();"><i>18903100844</i><span
                class="backtop iconfont" style="font-size:24px;"></span></a>
    <a style="background-position: right -49px;"
       href="http://wpa.qq.com/msgrd?v=3&amp;uin=3487358556&amp;site=qq&amp;menu=yes&amp;from=message&amp;isappinstalled=0"
       target="_blank"><i>在线客服</i><span class="backtop iconfont" style="font-size:24px;"></span></a>
    <!--    <A style="background-position: right -98px;" href="javascript:void(0)"><I>人才招聘</I></A>
        <A style="background-position: right -147px;" href="javascript:void(0)"><I>PPT下载</I></A>-->
    <a href="javascript:void(0)"><i>返回顶部</i><span id="btntop" class="backtop iconfont"></span></a>
</div>
<!--右侧悬浮按钮***-->
<style>
    .backtop {
        width: 50px;
        height: 49px;
        line-height: 49px;
        text-align: center;
        position: fixed;
        _position: absolute;
        right: 10px;
        z-index: 2000;
        _bottom: auto;
        cursor: pointer;
        font-size: 20px;
        color: #9c9c9c;
    }

    .backtop:hover {

        color: #fff;

    }

    .PosFixNavR {
        bottom: 20px;
        right: 10px;
        position: fixed;
        z-index: 1000;
        font-family: 微软雅黑;
    }

    .PosFixNavR a {
        transition: 0.3s ease-in-out;
        width: 50px;
        height: 49px;
        overflow: hidden;
        clear: both;
        float: right;
        display: block;
        position: relative;
        background-repeat: no-repeat;
        background-color: #e1e1e1;
        -moz-transition: all 0.3s ease-in-out;
        -o-transition: all 0.3s ease-in-out;
        -webkit-transition: all 0.3s ease-in-out;
        position: relative;
    }

    .PosFixNavR i {
        top: 0px;
        width: 120px;
        height: 49px;
        text-align: right;
        right: 50px;
        color: rgb(255, 255, 255);
        line-height: 49px;
        padding-right: 5px;
        font-size: 15px;
        font-style: normal;
        display: block;
        position: absolute;
    }

    .PosFixNavR a:hover {
        width: 170px;
        background-color: #c01733;
    }

</style>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?db0cd8bac7543826b1c47df745b65855";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<#--底部-->
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
        <p>北京新影联文化传播有限责任公司 版权所有 Copyright 2003-2017 All Rights Reserved 京ICP备12006157号 营业性演出许可证
            编号：京演（机构）［2017］3083号</p>
        <p>京公网安备 11010102002123号</p>
    </div>
</div>


</body>
</html>