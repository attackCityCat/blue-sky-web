var nickName = "";
$(function () {
    getNickName();//注册
    initHeaderEvent();//事件处理
    loadNav();//加载导航
    loadCart();//加载购物车
    initSearch();
//    $(".topNav").slide({type: "menu", titCell: "div", targetCell: "ul", delayTime: 0, defaultPlay: false, returnDefault: true});
});
function initSearch()
{
    var tpidx = 0;
    var tp = null;


    //搜索框的回车事件
    $('#search_keywords').keyup(function (event) {

        keyCode = event.keyCode;
        switch (keyCode) {
            case 13:
                tosearch();
                break;
            default:
                if ($(this).val() != "" && $(this).val() != "请输入演出、艺人、场馆名称…") {

                    $('.search-popumenu').show()
                    $(".autolist").html("");
                    var strtmp = "";
                    var keyword = encodeURI(encodeURI($(this).val()));
                    $.getJSON("/portal/eyes/ops.htm?t=" + Date.parse(new Date()), {op: "LOADPROJECT", key: keyword},
                    function (json) {

                        $.each(json, function (i, row) {
                            strtmp = strtmp + "<LI><A href='javascript:void(0);'   projectid='" + row.id + "'   class=' usertoselect' >" + row.name + "</A> </LI>";
                            if (i == json.length - 1) {
                                $(".autolist").html(strtmp);
                            }
                        });

                    });

                } else {
                    $('.search-popumenu').hide()
                }

        }

        if ($(this).val() != "" && $(this).val() != "请输入演出、艺人、场馆名称…")
        {
            $('.search-popumenu').show();
            $(".autolist").html("");
        }
        else
        {
            $('.search-popumenu').hide();
        }

    });

    $(".usertoselect").hover(function () {
        $("usertoselect").removeClass("ahover");
        $(this).addClass("ahover");
        tpidx = $(this).index();
    }, function () {
        $(this).removeClass("ahover");
        tpidx = $(this).index();
    });





}
function toXuznZe1(dataid) {
    window.open(G_sysBasePath + '/portal/eyes/perform/ticket_' + dataid + '.htm')
    $(".search-popumenu").hide();
}
function tosearch() {
    $('.search-popumenu').hide()
    var keyword = $('#search_keywords').val();
    if (keyword != "" && keyword != "请输入演出、艺人、场馆名称…") {
        keyword = encodeURI(encodeURI($('#search_keywords').val()));
        window.open(G_sysBasePath + '/portal/eyes/perform/search?keyword=' + keyword);
    }

}
function   initHeaderEvent() {
    $("#incsearchbtn").click(function () {
        if ($("#search_keywords").val() == '请输入演出、艺人、场馆名称…' || $("#search_keywords").val() == "") {
            layer.tips('请输入查询关键字', '#search_keywords', {
                tips: [4, '#0FA6D8']
            });
        } else {
            tosearch();
        }
    });
    $('#btntop').click(function () {
        $('html, body').animate({scrollTop: 0}, 'slow');
    });

    //选择框点击事件
    $(".usertoselect").live("click", function () {
        toXuznZe1($(this).attr("projectid"))
    });

    $(".keysearch").click(function () {
        $("#search_keywords").val($(this).attr("dataid"));
        tosearch();
    });

    $("#search_keywords").focus(function () {
        if ($(this).val() == '请输入演出、艺人、场馆名称…') {
            $(this).val('');
        }
        $(this).css("color", "#000000");
        if ($(this).val() != "" && $(this).val() != "请输入演出、艺人、场馆名称…") {
            $('.search-popumenu').show()
        } else {
            $('.search-popumenu').hide()
        }
    }).blur(function () {
        if ($(this).val() == '' || $(this).val() == '请输入演出、艺人、场馆名称…') {
            $('.search-popumenu').hide()
            $(this).val('请输入演出、艺人、场馆名称…');
            $(this).css("color", "#CCCCCC");
        }
    })
    //点击分享
    $(".afenxiang").click(function () {
        var url = window.location.href;
        var content = "大眼睛打造国内专业的票务网和演出订票平台，为您提供各种演唱会、流行音乐会、古典音乐、舞台剧、儿童剧演出官方在线购票服务，实时更新最新门票预订、演出信息和订票信息，安全快捷。";
        var dataid = $(this).attr("dataid");
        window.open("http://www.jiathis.com/send/?webid=" + dataid + "&url=" + url + "&title=" + content + "");
    });
}
function loadCart() {
    $.post("/portal/eyes/ops.htm", {op: "GET_CART_NUMBER"},
    function (data) {
        $("#scount").html(data);
    });

}
function loadNav() {

    var strHtml = "";
    $("#navmenu").append("<li><a href='" + G_sysBasePath + "/portal/eyes/perform/index.htm'><span>首页</span></a></li>");
    $.getJSON(G_sysBasePath + "/portal/eyes/ops.htm", {op: "getnavmenu"},
    function (json) {
        $.each(json, function (i, row) {
            var str = "  <li><a href='" + G_sysBasePath + "/portal/eyes/perform/project_" + row.dataid + ".htm'><span>" + row.name + "</span></a></li>";
            $("#navmenu").append(str);
        });

    });
}

//显示用户登录状态信息
function getNickName() {
    var strHtml = "";

    $.getJSON(G_sysBasePath + "/portal/eyes/ops.htm", {op: "islogin"},
    function (json) {
        if (json.isok == "1") {
            nickName = json.nickname;
            strHtml = '<span class="yj-name">' + nickName + '，欢迎您！</span>';
            strHtml += '<a   title="退出" href="' + G_sysBasePath + '/portal/eyes/logout.htm?s=2" style="margin-left:10px;">[退出]</a>';
        } else {
            strHtml = "您好，欢迎访问大眼睛票务网，请 <a href='javascript:void(0);' onclick='dayanLogin();' class='anolink yj-login'   style='margin-left:0px;'>登录</a> <a  href='" + G_sysBasePath + "/portal/eyes/reg.htm?s=2' class='anolink  yj-reg'  style='margin-left:5px;' >免费注册</a>";
        }

        $(".userInfo").html(strHtml);
        if (json.isok != "1") {
            $(".userInfo").addClass("top-login");
            $(".yj-login").addClass("ona");
        }
    });
}