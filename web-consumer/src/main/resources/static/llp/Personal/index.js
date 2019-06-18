$(function () {
    initEvent();
});

function initEvent(pageIndex) {
    //点击Tab事件
    $("#mytab li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
        var dataid = $(this).attr("dataid");
        $(".tabcontent").hide();
        $(".tabcontent[dataid=" + dataid + "]").show();
    });



//更换手机号码
    $("#btnmodimobile").click(function () {
        alert("修改绑定手机请联系客服：400-687-0707")
    });
}

function showstatus()
{
    layer.msg('数据已成功保存');
}
