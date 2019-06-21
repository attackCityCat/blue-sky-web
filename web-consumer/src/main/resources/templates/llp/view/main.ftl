<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>大眼睛票务</title>
    <#--layui轮播-->
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

    <style type="text/css" >
        .btn {
            position: absolute;
            width: 60px;
            height: 20px;
            *height: 33px;
            background-color: #1ba4e5;
            color: #fff;
            cursor: pointer;
            font-size: 18px;
            line-height: 20px;
            *line-height: 33px;
            text-align: center;
            right: 0;
            top: 0;
            *top: -2px
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
                <input type="text" id="name" placeholder="请输入电影进行搜索">
                <span class="btn"  onclick="search()">搜索</span>
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
                <li><a href="javascript:toReying()" data-index="filmshowing">热映影片</a></li>
                <li><a href="javascript:toNotRe()" data-index="filmfeature">即将上映</a></li>
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
        location.href = "/llp/toPersonal";
    }

    function toOrder() {
        location.href = "/llp/toOrder";
        //javascript:toOrder()
    }

    function toReying() {
        $.ajax({
            url:'/llp/toReYing',
            success:function (data) {
                $("#window").html(data);
            }
        })
    }

    toNotRe = function () {
        $.ajax({
            url:'/llp/toNotRe',
            success:function (data) {
                $("#window").html(data);
            }
        })
    }

    function toMain() {
        location.href = "/llp/toMain";
    }

    function toDetail(id) {
        location.href = "/hyd/page/toDetail?id=" + id;
    }

</script>
<#--中间内容-->
<div class="main homepage" id="window">
    <div class="mbanner flexslider">
        <div class="layui-carousel" id="test1">
            <div carousel-item>

                <#list imgs as i>
                    <div><img src="${i.img}" alt="${i.name}" onclick="toDetail(${i.id})"></div>
                </#list>

                <div><img src="https://lantianjihua.oss-cn-beijing.aliyuncs.com/20190514095715.jpg" alt=""></div>
                <div><img src="https://lantianjihua.oss-cn-beijing.aliyuncs.com/20190523094917.jpg" alt=""></div>
                <div><img src="https://lantianjihua.oss-cn-beijing.aliyuncs.com/20190603095531.jpg" alt=""></div>
                <div><img src="https://lantianjihua.oss-cn-beijing.aliyuncs.com/20190610102955.jpg" alt=""></div>
            </div>
        </div>
        <div class="film-recommend film-showing">
            <#--点击跳转到热映页面-->
            <h2>正在热映<a href="/llp/toReYing" class="more">更多</a></h2>
            <div class="films">
                <ul class="clearfix">
                    <#assign index = 0 >
                    <#list list as i>
                        <#assign index = index+1>
                        <li class="wd${index}">
                            <img src="${i.img}" alt="" onclick="toDetail(${i.id})">
                            <a href="#" class="film-layer" style="">
                                <div class="txt">
                                    <h3>${i.name}</h3>
                                </div>
                                <div class="mask"></div>
                            </a>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
        <div class="film-recommend film-feature">
            <#--点击跳转到热映页面-->
            <h2>即将上映<a href="/llp/toReYing" class="more">更多</a></h2>
            <div class="films">
                <ul class="clearfix">
                    <#assign index = 0 >
                    <#list not as i>
                        <#assign index = index+1>
                        <li class="wd${index}">
                            <img src="${i.img}" alt="" onclick="toDetail(${i.id})">
                            <a href="#" class="film-layer" style="">
                                <div class="txt">
                                    <h3>${i.name}</h3>
                                </div>
                                <div class="mask"></div>
                            </a>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
        <div class="active-recommend">
            <h2>精彩活动</h2>
            <div class="active clearfix">
                <div class="poster">
                    <img src="https://lantianjihua.oss-cn-beijing.aliyuncs.com/timg.jpg" alt="国旗"/></div>
                <div class="description">
                    <h3>更多详情咨询一组项目组全体成员</h3>
                    <p>活动规则：</p>
                    <p>1、活动期间，用户登录大眼睛票务，购买指定影片零点首映场即可参与抽奖，每位用户可抽奖一次，电子券类奖品自动绑定到账户中。</p>
                    <p>2、活动中用户采用作弊方式参与活动的，大眼睛票务有权采取必要的止损和保护措施，行为严重者将追究其相关法律责任。</p>
                    <p>3、活动最终解释权归大眼睛票务所有。</p>
                    <p>4、备注：小学生及学龄前儿童应在家长陪同下观看。</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- layui轮播图 -->
<script type="text/javascript">
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            , width: '1100px' //设置容器宽度
            , height: '403px'
            , arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });

    function tan() {
        layer.msg("功能正在开发中！~~")
    }
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

<script type="text/javascript">
    search = function () {
        var name = $("#name").val();
        var page = $("#page").val();
        var rows = $("#rows").val();
        if (name == '')
            return;
        
        $.ajax({
            url:'/dyl/queryMovieList',
            data:{
                name:name,
                page:page,
                rows:rows
            },
            success:function (data) {
                $("#window").html(data);
            }
        })
    }
</script>
</body>
</html>