<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>大眼睛电影详情</title>
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
                <li><a href="javascript:toReying()" data-index="filmshowing">热映影片</a></li>
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
        location.href = "/llp/toPersonal";
    }
    function toOrder() {
        location.href = "/llp/toOrder";
        //javascript:toOrder()
    }
    function toReying() {
        location.href = "/llp/toReYing"
        //javascript:toReying()
    }
    function toMain() {
        location.href = "/llp/toMain";
    }
    function tan() {
        layer.msg("功能正在开发中！~~")
    }

    function chakan() {
        // screening hide   screen-hide hide 收起ID
        var ulId = $("#ulId");
        var shouqiId = $("#shouqi");
        var chakanId = $("#chakanId");
        ulId.attr("class","screening");
        shouqiId.attr("class","screen-hide");
        chakanId.attr("class","screen-show btn hide");
    }
    function shouqi() {
        var ulId = $("#ulId");
        var shouqiId = $("#shouqi");
        var chakanId = $("#chakanId");
        ulId.attr("class","screening hide");
        shouqiId.attr("class","screen-hide hide");
        chakanId.attr("class","screen-show btn");
    }

    function toXuanZuo(id) {
        location.href="选坐的路径"+id;
    }

    function toDetail(id){
        location.href="/hyd/page/toDetail?id="+id;
    }

</script>
<#--中间内容-->
<#--<div class="main filmdetailpage">
    <div class="crumb">
        <p>
            <span>大眼睛</span>
            <i>></i>
            <span>热映影片</span>
            <i>></i>
            <span>数据库查出的名字放这里</span>
        </p>
    </div>
</div>-->

<div class="main filmdetailpage">
    <div class="crumb"><p><span>大眼睛</span><i>&gt;</i><span>热映影片</span><i>&gt;</i><span>${MoviesDetail.name}</span></p></div>
    <div class="film-introduction clearfix">
        <div class="information">
            <h2>${MoviesDetail.name}</h2>
            <p><strong>导演：
                </strong>${MoviesDetail.director}</p>
            <p><strong>主演：</strong>${MoviesDetail.perName}</p>
            <p><strong>类型：</strong>${MoviesDetail.typeName}</p>
            <p><strong>片长：</strong>${MoviesDetail.length}</p>
            <p><strong>影片详情：</strong>${MoviesDetail.detail}</p>
            <span class="logo"><img src="${MoviesDetail.img}" alt="${MoviesDetail.name}"></span></div>
        <div class="worktime">
            <p class="tel">189-0310-0844</p>
            <p class="date">周一至周日 09:00-20:00</p>
        </div>
    </div>
    <div class="cinemas-topshowing clearfix">
        <#--头部选项卡-->
        <div class="cinema-wrap">
            <ul class="tabs-nav clearfix">
                <li><a href="#" class="current">排片购票</a></li>
                <li><a href="javascript:tan()">预告片</a></li>
            </ul>
            <#--观影区域内容-->
            <div class="cinema-panel cinema-screening" style="display: block;">
                <div class="date">
                    <div class="tt">观影日期：</div>
                    <#list paiqiBeans as i>
                        <ul class="tabs-date clearfix">
                            <li><a href="javascript:toDetail(${i.id});">06.20</a></li>
                            <li><a href="javascript:toDetail(${i.id});">06.21</a></li>
                            <li><a href="javascript:toDetail(${i.id});">06.22</a></li>
                            <li><a href="javascript:toDetail(${i.id});">06.23</a></li>
                            <li><a href="javascript:toDetail(${i.id});">06.24</a></li>
                            <li><a href="javascript:toDetail(${i.id});">06.25</a></li>
                            <li><a href="javascript:toDetail(${i.id});">06.26</a></li>
                            <li><a href="javascript:toDetail(${i.id});">06.27</a></li>
                        </ul>
                    </#list>
                </div>
            </div>
           <#-- &lt;#&ndash;观影厅内容&ndash;&gt;
            <div class="area">
                <div class="tt">观影厅：</div>
                <ul class="clearfix">
                    <li><a href="javascript:;" data-citycode="110106">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110107">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110108">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110109">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110111">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110112">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110113">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110114">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110115">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110116">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110117">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110118">数据库查出替换</a></li>
                    <li><a href="javascript:;" data-citycode="110119">数据库查出替换</a></li>
                </ul>
            </div>

-->

            <#--排期内容-->
            <div class="screen-wrap">
                <div class="screen-list" style="display: block;">
                    <div class="cinemaScreen">
                        <div class="cinema-info">
                            <h2><a href="#">数据库查出XXX放映厅</a>
                            </h2>
                            <p class="adr"><span>地址：</span>北京名园大学1810A教室放映</p>
                            <p class="tel"><span>电话：</span>189-0310-0844</p>
                            <span class="logo"><img src="./大眼睛票务.电影_files/UME_W.jpg"></span>
                            <div class="action"><p class="price-start"><strong>¥XXX数据库查出</strong>起</p>
                                <p class="screenToggle">
                                    <#--点击时 Ajax查出数据进行拼接-->
                                    <a id="chakanId" class="screen-show btn" href="javascript:chakan();">查看排期</a>
                                    <#--尝试做点击收起就收起查出的数据-->
                                    <a id="shouqi" class="screen-hide hide" href="javascript:shouqi();">收起</a>
                                </p>
                            </div>
                        </div>
                        <ul id="ulId" class="screening hide">
                                <li class="head clearfix">
                                    <p class="item w1">放映时间</p>
                                    <p class="item w2">语言/版本</p>
                                    <p class="item w3">放映厅</p>
                                    <p class="item w4">原价</p>
                                    <p class="item w5">大眼睛价</p>
                                    <p class="item w6">购票</p>
                                </li>
                            <#--<#assign index = 0>-->
                            <#list paiqiBean as i>
                                <#--<#assign index = index + 1>-->
                                <li class="clearfix">
                                    <p class="item w1">${i.startTime}</p>
                                    <p class="item w2">
                                        <#if i.language ==0>国语</#if>
                                        <#if i.language ==1>英语</#if>
                                        <#if i.language ==2>原版</#if>
                                    </p>
                                    <p class="item w3">${i.hallName}</p>
                                    <p class="item stand-pric w4">¥${i.price}</p>
                                    <p class="item w5">¥${i.price}</p>
                                    <p class="item w6">
                                        <a class="btn" href="javascript:toXuanZuo(${i.id})" target="_blank">选座购票</a>
                                    </p>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="top-showing">
            <h2>热映排行榜</h2>
            <div class="film-list">
                <ul>
                    <#list list as i >
                    <li>
                        <h3>
                            <a href="#">${i.name}</a></h3>
                        <p>${i.director}</p>
                        <span class="flogo">
                                <img src="${i.img}" alt="${i.name}"></span>
                        <p class="buy">
                            <a class="btn" href="javascript:toDetail(${i.id})">查看详情</a>
                        </p>
                    </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>


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