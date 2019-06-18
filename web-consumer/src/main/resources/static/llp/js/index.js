var nowShengYu = 0;
var intervalId;
$(function () {
    $("A.anolink").attr("href", "javascript:void(0);");

    $(".imgyanzheng").click(function () {
        $("#imgyanzheng").attr("src", G_sysBasePath + "/imagecodemaker?source=2&t=" + Date.parse(new Date()))
    });

    $("#username").focus(function () {
        $("#infor1").show();
        $("#infor1").removeClass("errorinfor");
        $("#infor1").html("请输入您的登录手机号");
    });

    $("#username").blur(function () {
        if ($("#username").val() != "") {
            $("#infor1").removeClass("errorinfor");
        }
//        $("#infor1").hide();
    });

    $("#yanzhengma").focus(function () {
        $("#infor2").show();
        $("#infor2").removeClass("errorinfor");
        $("#infor2").html("请输入您验证码");
    });
    $("#yanzhengma").blur(function () {
        if ($("#yanzhengma").val() != "") {
            $("#infor2").removeClass("errorinfor");
        }
//        $("#infor2").hide();
    });


    $("#btn-next").hover(function () {
        $(this).addClass("btn-next-hover");
    }, function () {
        $(this).removeClass("btn-next-hover");
    });
    $("#btn-next").click(function () {
        var username = $("#username").val();
        var yanzhengma = $("#yanzhengma").val();
        if (username == "") {
            $("#infor1").html("登录账号不能为空！");
            $("#infor1").addClass("errorinfor");
            $("#infor1").show();
            return;
        }
//        if (!IsAccount(username)) {
//            $("#infor1").html("用户账号只能是字母、数字、下划线或中文字符！");
//            $("#infor1").addClass("errorinfor");
//            $("#infor1").show();
//            return;
//        }

        if (yanzhengma == "") {
            $("#infor2").html("验证码不能为空！");
            $("#infor2").addClass("errorinfor");
            $("#infor2").show();
            return;
        }
        $.getJSON("ops.jsp?t=" + Date.parse(new Date()), {op: "YANZHENG", username: username, yanzhengma: yanzhengma},
                function (json) {
                    $("#imgyanzheng").attr("src", G_sysBasePath + "/imagecodemaker?source=2&t=" + Date.parse(new Date()))
                    if (json.retdata == "1") {
                        $("#infor2").html("验证码错误！");
                        $("#infor2").addClass("errorinfor");
                        $("#infor2").show();
                    }
                    if (json.retdata == "2") {
                        $("#infor1").html("用户账号不存在！");
                        $("#infor1").addClass("errorinfor");
                        $("#infor1").show();
                    }

                    if (json.retdata == "9") {
                        window.location.href = 'step2.jsp'
                    }
                });
    });

    distype();
    $("#fangshi").change(function () {
        distype();
    });

    $("#smssend").click(function () {

        if (nowShengYu == 0) {
            //发送短信
            $.post("ops.jsp?t=" + Date.parse(new Date()), {op: "SENDSMS1"},
                    function (data) {
                        nowShengYu = 120;
                        $(".timeDiv").show()
                        intervalId = setInterval("CountDown()", 1000);//调用倒计时的方法
                    });
        }
    });
    $("#mailsend").click(function () {
        if (nowShengYu == 0) {
            //发送短信
            $.post("ops.jsp?t=" + Date.parse(new Date()), {op: "SENDMAIL"},
                    function (data) {
                        nowShengYu = 120;
                        $(".timeDiv").show()
                        intervalId = setInterval("CountDown()", 1000);//调用倒计时的方法
                    });
        }
    });

    $("#btn-next2").click(function () {
        if ($("#fangshi").val() == "1") {
            if ($("#yanzhengma").val() == "") {
                $("#infor2").html("验证码不能为空！");
                $("#infor2").addClass("errorinfor");
                $("#infor2").show();
                return;
            }
            $("#infor2").hide();
            $.post("ops.jsp?t=" + Date.parse(new Date()), {op: "YANZHENGMASHOUJI", yanzhengma: $("#yanzhengma").val()},
                    function (data) {
                        if (data == "OK") {
                            window.location.href = "step3.jsp";
                            return;
                        }
                        if (data == "ERROR3") {
                            $("#infor2").html("验证码已经失效，请重新获取！");
                            $("#infor2").addClass("errorinfor");
                            $("#infor2").show();
                            return;
                        }
                        if (data == "ERROR") {
                            $("#infor2").html("验证码错误！");
                            $("#infor2").addClass("errorinfor");
                            $("#infor2").show();
                            return;
                        }
                    });
        } else {
            if ($("#yanzhengmamail").val() == "") {
                $("#infor3").html("验证码不能为空！");
                $("#infor3").addClass("errorinfor");
                $("#infor3").show();
                return;
            }
            $("#infor3").hide();
            $.post("ops.jsp?t=" + Date.parse(new Date()), {op: "YANZHENGMASHOUJI", yanzhengma: $("#yanzhengmamail").val()},
                    function (data) {
                        if (data == "OK") {
                            window.location.href = "step3.jsp";
                        } else {
                            $("#infor3").html("验证码错误！");
                            $("#infor3").addClass("errorinfor");
                            $("#infor3").show();
                        }
                    });

        }
    });

    $("#btn-next3").click(function () {
        var newpass = $("#newpass").val();
        var newpass1 = $("#newpass1").val();
        if (newpass == "") {
            $("#infor3").html("新的登录密码不能为空！");
            $("#infor3").addClass("errorinfor");
            $("#newpass").focus();
            $("#infor2").show();
            return;
        }

        if (!(newpass.length >= 6 && newpass.length <= 20)) {
            $("#infor3").html("密码至少6位，最大20位！");
            $("#infor3").addClass("errorinfor");
            $("#newpass").focus();
            $("#infor2").show();
            return;
        }

        var strCharNum = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
//        var strCharNum = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-@.,!";
//
//        if (Str1CharAllInStr2(newpass, strCharNum) == 0)
//        {
//            $("#infor2").html("新的登录密码含有非法字符！");
//            $("#infor2").addClass("errorinfor");
//            $("#newpass").focus();
//            $("#infor2").show();
//            return;
//        }
        $("#infor3").hide();

        var len = checkPass(newpass);
        if (len < 2) {
            alert("密码强度不符合,请重新输入(密码格式为6-20位字母、数字的组合)");
            return false;
        }

        if (newpass1 != newpass) {
            $("#infor3").html("两次输入的新密码不一致！");
            $("#infor3").addClass("errorinfor");
            $("#newpass1").focus();
            $("#infor3").show();
            return;
        }
        $("#infor3").hide();
        $.post("ops.jsp?t=" + Date.parse(new Date()), {op: "REPASS", newpass: $("#newpass").val()},
                function (data) {
                    if (data == "ERROR") {
                        alert("密码修改失败！")
                    } else {
                        window.location.href = "step4.jsp";
                    }
                });
    });


});

function distype() {
    $(".tohide ").hide();
    $(".c" + $("#fangshi").val()).show();
}

function CountDown() {
    if (nowShengYu <= 0) {
        nowShengYu = 0;
        $("#smssend").html("获取短信验证码")
        clearInterval(intervalId); //取消由 setInterval() 设置的 timeout  
        $(".timeDiv").hide()
        return;
    }
    nowShengYu--;
    $(".tdleft").html(nowShengYu);
    $("#smssend").html("<font color=red>" + nowShengYu + "</font>")
}

function checkPass(pass) {
    if (pass.length < 6) {
        return 0;
    }
    if (pass.length > 20) {
        return 0;
    }
    var ls = 0;
    if (pass.match(/([a-zA-Z])+/)) {
        ls++;
    }
    if (pass.match(/([0-9])+/)) {
        ls++;
    }
//    if (pass.match(/([_])+/)) {
//        ls++;
//    }
    return ls;
}   