<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>支付中心</title>
    <link rel="shortcut icon" href="https://pay.daeyes.com/favicon.ico" type="image/x-icon">

    <script src="../js/支付中心/modernizr"></script>


    <link href="../js/支付中心/iview.css" rel="stylesheet">
    <link href="../js/支付中心/site.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../js/style.css">
    <script src="../js/html5.js"></script>
    <script src="../js/jquery.js"></script>

    <script type="text/javascript">
        $(function(){
            var orderNum = $("#orderNum").val();
            alert(orderNum);
            $.ajax({
                url:'/saveOrderRJF',
                type:'post',
                dataType:'json',
                data:{
                    "orderNum":orderNum
                },
                success:function(){
                    //alert("成功分单");
                },
                error:function(){
                    //alert("失败");
                }
            })
        });

        function fanhui(){
            location.href="/llp/toMain";
        }
    </script>
</head>
<body>
<input type="hidden" value="${orders.orderNum}" id="orderNum">
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
                    <span>|</span> <span>订单详情：${orders.movieName} 103电影公园 ${orders.startDate} ${orders.hallName} ${orders.seatName}</span>
                    <span>|</span> <span></span> <font color="red">已支付</font> <span>|</span>
                </div> <!----></div>
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
                <div>
                    <center>
                        <font color="red" size="5px">支付成功!!!</font>
                    </center>
                </div>
                <div class="da-clear"></div> <!---->
                <div class="btn-list">
                    <button type="button" onclick="fanhui()" class="ivu-btn ivu-btn-primary ivu-btn-circle ivu-btn-large"><!----> <!---->
                        <span>返回首页</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>