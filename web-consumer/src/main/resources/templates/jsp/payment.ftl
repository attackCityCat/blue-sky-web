<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>支付中心</title>
    <link rel="shortcut icon" href="https://pay.daeyes.com/favicon.ico" type="image/x-icon">

    <script src="../js/支付中心/modernizr"></script>


    <link href="../js/支付中心/iview.css" rel="stylesheet">
    <link href="../js/支付中心/site.css" rel="stylesheet">
    <style>
        [v-cloak] {
            display: none;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="header-title">
            <div class="logo"><img src="../js/支付中心/logo.png" alt="大眼睛票务网"></div>
            <span class="logo-title">我的收银台</span>

        </div>
    </div>
</div>
<div class="container body-content">
    <div id="mpay">
        <div class="count-down-area">
        <div class="container">
        <div class="count-down-box">
        </div></div></div>
        <!---->
    <div class="order-area">
    <div class="order-header">
    <span>订单详情</span>
    <span class="order-ext-trigger" style="display: block;">订单详情</span>
    </div>

    <div class="order-detail">
        <div class="inline">
            <span>电影票</span> <span>|</span> <span>订单号：${orders.orderNum}</span>
            <span>|</span> <span>订单详情：${orders.movieName}<span>|</span>${orders.startDate} ${orders.hallName} ${orders.seatName}</span>
            <span>|</span> <span></span> <span>|</span>
        </div> <!----></div>
        <div class="order-amount">
            <span class="order-item-title">应付金额：</span>
            <span class="order-pay-amount">${orders.totalPrice}</span> <span>元</span>&nbsp;&nbsp;&nbsp;
            <span class="order-item-title">由于您是${orders.jibie}级会员,折价后应付金额: </span>&nbsp;&nbsp;
            <span class="order-pay-amount">${orders.fracturePrice}</span> <span>元</span>
        </div>
    </div>
        <div>
            <#--<div class="coupon-area">
                <div></div>
            </div> --><!---->
            <#--<form method="post" action="https://pay.daeyes.com/paycenter/payconfirm" id="cform">
                <div style="margin-top: 10px;"></div>
                <div><input name="AppId" value="film01" readonly="readonly" style="display: none;">
                    <input name="TradeNo" value="2019061422284202103464376" readonly="readonly" style="display: none;">
                    <input name="OutTradeNo" value="11019061422283890611" readonly="readonly" style="display: none;">
                    <input name="TotalAmount" value="60.00" readonly="readonly" style="display: none;">
                    <input name="Sign" value="83C029EC2F07733E4F038AEB49D01512" readonly="readonly" style="display: none;">
                    <input name="TradeType" value="PAGE" readonly="readonly" style="display: none;">
                    <input name="CouponJson" readonly="readonly" style="display: none;">
                    <input name="WhCouponCode" readonly="readonly" style="display: none;">
                    <input name="WhCouponAmount" value="0" readonly="readonly" style="display: none;">
                    <input name="WhCouponMinConsume" value="0" readonly="readonly" style="display: none;">
                </div>
            </form>-->
            <div class="order-summary">
                <div class="statistic fr">
                    <div class="list"><span>订单应付金额：</span>
                        <em class="price">￥${orders.fracturePrice}</em>
                    </div> <!----> <!---->
                    <div class="list" style="margin-top: 10px;">
                        <span>支付金额：</span>
                        <em class="yfprice">${orders.fracturePrice}</em>
                    </div>
                </div>
                <div class="da-clear"></div> <!---->
                <div class="btn-list">
                    <button type="button" onclick="zhifu(${orders.fracturePrice})" class="ivu-btn ivu-btn-primary ivu-btn-circle ivu-btn-large"><!----> <!---->
                        <span>继续支付</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function  zhifu(price){
        location.href="/goAlipay?price="+price;
    }
</script>
<!--CDN-->


<!--大眼睛CDN-->
<script src="../js/支付中心/jquery.min.js.下载"></script>
<script src="../js/支付中心/vue.min.js.下载"></script>
<script src="../js/支付中心/axios.min.js.下载"></script>
<script src="../js/支付中心/iview.min.js.下载"></script>

<!--Local-->


<script src="../js/支付中心/common.js.下载"></script>
<script src="../js/支付中心/vue-component.js.下载"></script>
<script>
    var isIE = !!window.ActiveXObject || "ActiveXObject" in window;
    console.log(isIE);
    if (isIE) {
        var scriptNode = document.createElement("script");
        scriptNode.setAttribute("type", "text/javascript");
        scriptNode.setAttribute("src", "https://cdn.daeyes.com/babel-polyfill/6.26.0/polyfill.min.js");
        document.head.appendChild(scriptNode);
    }

</script>

<script src="../js/支付中心/jquery-qrcode-0.14.0.min.js.下载"></script>
<script>
    //初始化数据
    var payAmount = '60.00';
    var orderData = {
        disableCash: 'False' === 'True',
        channelAmount: '60.00',
        channelUnit:'元'
    }
    var payParams = {
        AppId: 'film01',
        TradeNo: '2019061422284202103464376',
        OutTradeNo: '11019061422283890611',
        TotalAmount: '60.00',
        Sign: '83C029EC2F07733E4F038AEB49D01512',
        TradeType: 'PAGE',
        CouponJson: '',
        WhCouponCode: '',
        WhCouponAmount: 0,
        WhCouponMinConsume: 0,
        Coupons: [],
        CouponAmount: 0,
        PayPassword: '',
        ValidCode:''
    };
</script>
<script src="../js/支付中心/orderapp.js.下载"></script>
</body>
</html>