/*===================*/
//全局变量
var msgErrorGlobal = "大眼睛票务需要休息下，请稍后再试！";

/**
判断值是否为null
@method isNull
@param value 要判断的值
@return {Boolean} true:表示值为null；false：表示值不为null
**/
function isNull(value) {
    if (value == null)
        return true;
    if (value == undefined)
        return true;
    if (value === "")
        return true;
    if (value === "null")
        return true;
    return false;
}

/**
显示文字处理，如果为null的输出空
@method txtShow
@param str 要判断的值
@return {string}
**/
function txtShow(str) {
    return isNull(str) ? "" : str;
}

/**
设置cookie值
@method setCookie
@param name cookie键值名称
@param value cookie值
@param issession 有效期，单位天/true session模式，关闭全部页面自动清除
@return {void} 无返回值
**/
function setCookie(name, value, issession) {
    if (issession == true) {
        document.cookie = name + "=" + encodeURIComponent(value) + ";path=/";
    }
    else {
        var Days = 365;
        if (!isNaN(issession)) {
            Days = issession;
        }
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + encodeURIComponent(value) + ";expires=" + exp.toGMTString() + ";path=/";
    }
}

/**
获取cookie值
@method getCookie
@param name cookie键值名称
@return {string} 返回cookie对应值
**/
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null)
        return decodeURIComponent(arr[2]);
    return null;
}

/**
删除对应cookie
@method delCookie
@param name cookie键值名称
@return {void} 无返回值
**/
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

/**
根据cityCode查询城市所属地区名称
@method getCityArea
@param cityCode 城市对应cityCode
@return {Array} 城市地区数组
**/
function getCityArea(cityCode) {
    var temp = [];
    var cityDate = $.cityDate;
    var clength = cityDate.length;
    for (var i = 0; i < clength; i++) {
        if (cityDate[i].code == cityCode) {
            temp = cityDate[i]['sub'];
            break;
        }
    }
    return temp;
}

/**
设置城市cookie
@method setCityCode
@param code 城市cityCode
@return {void}
**/
function setCookieCity(code,name) {
    setCookie("cityCode", code);
    setCookie("cityName", name);
}

/**
获取当前城市cityCode值
@method findCityCode
@return {string} 返回对应值
**/
function findCityCode() {
    var cityCode = getCookie("cityCode");
    if (isNull(cityCode)) {
        cityCode = "110100";
    }
    return cityCode.toString();
}

/**
获取当前城市名称
@method findCityName
@return {string} 返回对应值
**/
function findCityName() {
    var cityName = getCookie("cityName");
    if (isNull(cityName)) {
        cityName = "北京";
    }
    return cityName.toString();
}

/**
获取url上参数名对应的值
@method getQueryString
@param name 需要获取值的参数名
@param strlocation url链接，不传改参数，默认是当前url
@return {string} 参数名对应的值
**/
function getQueryString(name, strlocation) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r;
    if (strlocation == undefined || strlocation == null)
        r = window.location.search.substr(1).match(reg);
    else
        r = strlocation.substr(strlocation.indexOf("?") + 1).match(reg);
    if (r != null) return decodeURIComponent(r[2]); return null;
}

/**
字符串格式化输出，如果长度为1，则前面加0，一般用于小时，分，秒输出，如果小于10则前面加0
@method formatNumber
@param n 格式化字符串
@return {string} 格式化后的字符串
**/
function formatNumber(n) {
    n = n.toString();
    return n[1] ? n : '0' + n;
}

/**
时间格式化输出
@method formatTime
@param date 时间对象，一般new Date("2017/10/18 10:12:23")
@param format 格式化字符串 年：yyyy 月份：MM 天：dd 小时：HH 分钟：mm 秒：ss
@return {string} 格式化后输出时间字符串
**/
function formatTime(format,date) {
    var date = date || new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();

    if (format) {
        return format.replace("yyyy", formatNumber(year)).replace("MM", formatNumber(month)).replace("dd", formatNumber(day)).replace("HH", formatNumber(hour)).replace("mm", formatNumber(minute)).replace("ss", formatNumber(second));
    } else {
        return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':');
    }
}

/**
赋值session对应值
@method setsessionstorage
@param respData 赋值数据来源(对象数组)
@return {void} 无返回值
**/
function setsessionstorage(respData) {
    setCookie("Account", respData.Account, true);
    setCookie("AccountExpTime", respData.AccountExpTime, true);
    setCookie("Append1", respData.Append1, true);
    setCookie("Append2", respData.Append2, true);
    setCookie("Append3", respData.Append3, true);
    setCookie("Append4", respData.Append4, true);
    setCookie("Append5", respData.Append5, true);
    setCookie("EMail", respData.EMail, true);
    setCookie("Flag", respData.Flag, true);
    setCookie("HeaderIcon", respData.HeaderIcon, true);
    setCookie("LastLoginIP", respData.LastLoginIP, true);
    setCookie("LastLoginTime", respData.LastLoginTime,true);
    setCookie("LastLoginType", respData.LastLoginType, true);
    setCookie("LoginFailDate", respData.LoginFailDate, true);
    setCookie("LoginFailTimes", respData.LoginFailTimes, true);
    setCookie("LoginTimes", respData.LoginTimes, true);
    setCookie("MemberFrom", respData.MemberFrom, true);
    setCookie("Mobile", respData.Mobile,true);
    setCookie("NickName", respData.NickName, true);
    setCookie("Pass", respData.Pass, true);
    setCookie("Points", respData.Points, true);
    setCookie("RegTime", respData.RegTime, true);
    setCookie("Sex", respData.Sex, true);
    setCookie("StatusFlag", respData.StatusFlag, true);
    setCookie("TotalFailTimes", respData.TotalFailTimes, true);
    setCookie("UserID", respData.UserID, true);
}

/**
清除setsessionstorage方法赋值了的session值
@method clearsessionstorage
@return {void} 无返回值
**/
function clearsessionstorage() {
    delCookie("Account");
    delCookie("AccountExpTime");
    delCookie("Append1");
    delCookie("Append2");
    delCookie("Append3");
    delCookie("Append4");
    delCookie("Append5");
    delCookie("EMail");
    delCookie("Flag");
    delCookie("HeaderIcon");
    delCookie("LastLoginIP");
    delCookie("LastLoginTime");
    delCookie("LastLoginType");
    delCookie("LoginFailDate");
    delCookie("LoginFailTimes");
    delCookie("LoginTimes");
    delCookie("MemberFrom");
    delCookie("Mobile");
    delCookie("NickName");
    delCookie("Pass");
    delCookie("Points");
    delCookie("RegTime");
    delCookie("Sex");
    delCookie("StatusFlag");
    delCookie("TotalFailTimes");
    delCookie("UserID");
}

/**
根据导航链接选中对应的导航菜单
@method menuStamp
@param url 当前url链接
@return {void} 无返回值
**/
function menuStamp(url) {
    var pagename = url.substr(url.indexOf("/") + 1);
    var tag = "";
    if (pagename == "" || pagename.indexOf("index") > -1) tag = "index";
    if (pagename.indexOf("filmshowing") > -1) tag = "filmshowing";
    if (pagename.indexOf("filmfeature") > -1) tag = "filmfeature";
    if (pagename.indexOf("cinemas") > -1) tag = "cinemas";
    $(".header .main-nav li a").each(function (i) {
        var _self = $(this);
        _self.removeClass("act");
        if (_self.attr("data-index") == tag) {
            _self.addClass("act");
        }
    });
}

/**
退出登录，清楚session
@method loginOut
@return {void} 无返回值
**/
function loginOut() {
    clearsessionstorage();
    window.location.reload();
}

/**
设置顶部登录信息
@method loginSet
@return {void} 无返回值
**/
function loginTopSet() {
    var mobile = getCookie("Mobile");
    var nickName = getCookie("NickName");
    var html = '<p class="tip-login">您好，欢迎访问大眼睛票务网，请<a href="/login.html">登录</a><a href="/reg.html">免费注册</a></p>';
    if (!isNull(mobile)) {
        html = '<p class="tip-login">您好' + nickName + '，欢迎访问大眼睛票务网<a href="javascript:void(0)" onclick="loginOut()">退出登录</a></p>';
    }
    html += '<ul class="user-menu clearfix"><li class="my-eye"><a href="javascript:;">我的大眼睛</a><span class="animate"></span><div class="son hide"><p><a href="http://www.daeyes.com/portal/eyes/personal/user/index.htm">个人资料</a></p><p><a href="http://www.daeyes.com/portal/eyes/personal/piaoka/index.htm">我的新影联卡</a></p></div></li><li><a href="http://www.daeyes.com/portal/eyes/personal/pcmovie/index.htm">我的订单</a></li><li>关注大眼睛</li><li class="tel-film">电影热线：400-687-0707</li><li class="tel-perform">演出热线：400-617-0707</li></ul></div>'
    $(".header-nav .container").html(html);

    $(".user-menu .my-eye").hover(function () {
        $(this).find(".son").removeClass("hide");
    }, function () {
        $(this).find(".son").addClass("hide");
    });
}

/**
验证是否登录，验证session Mobile值
@method checkLogin
@param url 未登录跳转链接 默认跳转 reg.html
@return {void} 无返回值
**/
function checkLogin(url) {
    var url = url || "/login.html";
    var mobile = getCookie("Mobile");
    if (isNull(mobile)) {
        setCookie("urlBack", window.location.href, true);
        window.location.href = url;
        return false;
    } else {
        return true;
    }
}

/**
验证url上参数的值是否有效，获取参数值使用getQueryString查询
@method checkParam
@param str 参数字符串
@param msg 验证未通过提示信息 默认提示：页面发生错误，请重新打开页面！
@param url 验证未通过跳转链接 默认跳转 index.html
@return {void} 无返回值
**/
function checkParam(str, msg, url) {
    var str = str || false;
    var msg = msg || "页面发生错误，请重新打开页面！";
    var url = url || "/index.html";
    var param = [];
    var flag = true;
    if (str) {
        param = str.split(",");
        for (var i = 0; i < param.length; i++) {
            if (isNull(getQueryString(param[i]))) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            alert(msg);
            window.location.href = url;
            return false;
        }
    } else {
        alert("参数错误！");
    }
}

/**
设置选择当前城市名称和cookie
@method setCity
@return {void} 无返回值
**/
function setCity(code,name) {
    var cityCode = code || findCityCode();
    var cityName = name || findCityName();
    setCookieCity(cityCode, cityName);
    $(".city-btn").attr({ "data-citycode": cityCode, "data-cityname": cityName }).html(cityName + "<i class='arrow down'></i>");
}

/**
温馨提示弹窗
@param msg 弹窗内容
@method tipsImport
@return {void} 无返回值
**/
function tipsImport(msg) {
    layer.alert(msg, {
        title: "温馨提示",
        skin:"tip-import-layer"
    })
}


/**
设置选择城市html
@method setCityHtml
@return {void} 无返回值
**/
function setCityHtml() {
    var html = '<div class="city-choose hide">';
    html += '<div class="tabs-nav"><ul class="clearfix">';
    html += '<li><a href="#" data-id="1">热门</a></li>';
    html += '<li><a href="#" data-id="2">A-G</a></li>';
    html += '<li><a href="#" data-id="3">H-L</a></li>';
    html += '<li><a href="#" data-id="4">M-T</a></li>';
    html += '<li><a href="#" data-id="5">W-Z</a></li>';
    html += '</ul></div>';

    html += '<div class="panel hot">';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="110100" data-cityname="北京">北京</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="310100" data-cityname="上海">上海</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440100" data-cityname="广州">广州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440300" data-cityname="深圳">深圳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="120100" data-cityname="天津">天津</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="500100" data-cityname="重庆">重庆</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320200" data-cityname="无锡">无锡</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130600" data-cityname="保定">保定</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130100" data-cityname="石家庄">石家庄</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320100" data-cityname="南京">南京</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="panel" style="display:none;">';

    html += '<div class="item">';
    html += '<div class="tt">A</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="210300" data-cityname="鞍山">鞍山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="513200" data-cityname="阿坝藏族羌族自治州">阿坝藏族羌族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="520400" data-cityname="安顺">安顺</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610900" data-cityname="安康">安康</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="652900" data-cityname="阿克苏地区">阿克苏地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="654300" data-cityname="阿勒泰地区">阿勒泰地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="152900" data-cityname="阿拉善盟">阿拉善盟</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="340800" data-cityname="安庆">安庆</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410500" data-cityname="安阳">安阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="542500" data-cityname="阿里地区">阿里地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659002" data-cityname="阿拉尔">阿拉尔</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">B</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="110000" data-cityname="北京">北京</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130600" data-cityname="保定">保定</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150200" data-cityname="包头">包头</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150800" data-cityname="巴彦淖尔">巴彦淖尔</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="210500" data-cityname="本溪">本溪</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220600" data-cityname="白山">白山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220800" data-cityname="白城">白城</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450500" data-cityname="北海">北海</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="451000" data-cityname="百色">百色</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="511900" data-cityname="巴中">巴中</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="520500" data-cityname="毕节地区">毕节地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="530500" data-cityname="保山">保山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610300" data-cityname="宝鸡">宝鸡</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620400" data-cityname="白银">白银</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="652700" data-cityname="博尔塔拉蒙古自治州">博尔塔拉蒙古自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="652800" data-cityname="巴音郭楞蒙古自治州">巴音郭楞蒙古自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="340300" data-cityname="蚌埠">蚌埠</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341600" data-cityname="亳州">亳州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="371600" data-cityname="滨州">滨州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469025" data-cityname="白沙黎族自治县">白沙黎族自治县</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469029" data-cityname="保亭黎族苗族自治县">保亭黎族苗族自治县</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659005" data-cityname="北屯">北屯</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="820000" data-cityname="澳门特别行政区">澳门特别行政区</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">C</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="500100" data-cityname="重庆">重庆</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130800" data-cityname="承德">承德</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130900" data-cityname="沧州">沧州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150400" data-cityname="赤峰">赤峰</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="211300" data-cityname="朝阳">朝阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220100" data-cityname="长春">长春</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="445100" data-cityname="潮州">潮州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="451400" data-cityname="崇左">崇左</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469023" data-cityname="澄迈县">澄迈县</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469026" data-cityname="昌江黎族自治县">昌江黎族自治县</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510100" data-cityname="成都">成都</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="532300" data-cityname="楚雄彝族自治州">楚雄彝族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="652300" data-cityname="昌吉回族自治州">昌吉回族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320400" data-cityname="常州">常州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341100" data-cityname="滁州">滁州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341402" data-cityname="巢湖">巢湖</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341700" data-cityname="池州">池州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430100" data-cityname="长沙">长沙</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140400" data-cityname="长治">长治</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430700" data-cityname="常德">常德</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="431000" data-cityname="郴州">郴州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="540300" data-cityname="昌都">昌都</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">D</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="140200" data-cityname="大同">大同</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="210200" data-cityname="大连">大连</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="210600" data-cityname="丹东">丹东</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230600" data-cityname="大庆">大庆</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="232700" data-cityname="大兴安岭">大兴安岭</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441900" data-cityname="东莞">东莞</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="460400" data-cityname="儋州">儋州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469007" data-cityname="东方">东方</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510600" data-cityname="德阳">德阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="511700" data-cityname="达州">达州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="532900" data-cityname="大理白族自治州">大理白族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="533100" data-cityname="德宏傣族景颇族自治州">德宏傣族景颇族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="533400" data-cityname="迪庆藏族自治州">迪庆藏族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="621100" data-cityname="定西">定西</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="321181" data-cityname="丹阳">丹阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370500" data-cityname="东营">东营</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="371400" data-cityname="德州">德州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469021" data-cityname="定安">定安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510181" data-cityname="都江堰">都江堰</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">E</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="150600" data-cityname="鄂尔多斯">鄂尔多斯</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420700" data-cityname="鄂州">鄂州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="422800" data-cityname="恩施土家族苗族自治州">恩施土家族苗族自治州</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">F</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="210400" data-cityname="抚顺">抚顺</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="210900" data-cityname="阜新">阜新</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440600" data-cityname="佛山">佛山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450600" data-cityname="防城港">防城港</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341200" data-cityname="阜阳">阜阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350100" data-cityname="福州">福州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="361000" data-cityname="抚州">抚州</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">G</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="440100" data-cityname="广州">广州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450300" data-cityname="桂林">桂林</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450800" data-cityname="贵港">贵港</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="520100" data-cityname="贵阳">贵阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360700" data-cityname="赣州">赣州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="640400" data-cityname="固原">固原</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="511600" data-cityname="广安">广安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510800" data-cityname="广元">广元</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="632600" data-cityname="果洛藏族自治州">果洛藏族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="623000" data-cityname="甘南藏族自治州">甘南藏族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="513300" data-cityname="甘孜藏族自治州">甘孜藏族自治州</a></li>';

    html += '</ul>';
    html += '</div>';

    html += '</div>';

    html += '<div class="panel" style="display:none;">';

    html += '<div class="item">';
    html += '<div class="tt">H</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="330100" data-cityname="杭州">杭州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="340100" data-cityname="合肥">合肥</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="451200" data-cityname="河池">河池</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441600" data-cityname="河源">河源</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="371700" data-cityname="菏泽">菏泽</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="451100" data-cityname="贺州">贺州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410600" data-cityname="鹤壁">鹤壁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230400" data-cityname="鹤岗">鹤岗</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="231100" data-cityname="黑河">黑河</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="131100" data-cityname="衡水">衡水</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430400" data-cityname="衡阳">衡阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="532500" data-cityname="红河哈尼族彝族自治州">红河哈尼族彝族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150100" data-cityname="呼和浩特">呼和浩特</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150700" data-cityname="呼伦贝尔">呼伦贝尔</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330500" data-cityname="湖州">湖州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="211400" data-cityname="葫芦岛">葫芦岛</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="431200" data-cityname="怀化">怀化</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320800" data-cityname="淮安">淮安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="340600" data-cityname="淮北">淮北</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="340400" data-cityname="淮南">淮南</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="421100" data-cityname="黄冈">黄冈</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="632300" data-cityname="黄南藏族自治州">黄南藏族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341000" data-cityname="黄山">黄山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420200" data-cityname="黄石">黄石</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441300" data-cityname="惠州">惠州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230100" data-cityname="哈尔滨">哈尔滨</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="652200" data-cityname="哈密地区">哈密地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="632200" data-cityname="海北藏族自治州">海北藏族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="630200" data-cityname="海东">海东</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="460100" data-cityname="海口">海口</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130400" data-cityname="邯郸">邯郸</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610700" data-cityname="汉中">汉中</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="653200" data-cityname="和田地区">和田地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="632500" data-cityname="海南藏族自治州">海南藏族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="632800" data-cityname="海西蒙古族藏族自治州">海西蒙古族藏族自治州</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">J</div>';
    html += '<ul class="clearfix">';
    
     html += '<li><a href="javascript:void(0);" data-citycode="360800" data-cityname="吉安">吉安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220200" data-cityname="吉林">吉林</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370100" data-cityname="济南">济南</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370800" data-cityname="济宁">济宁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="419001" data-cityname="济源">济源</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230800" data-cityname="佳木斯">佳木斯</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330400" data-cityname="嘉兴">嘉兴</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620200" data-cityname="嘉峪关">嘉峪关</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440700" data-cityname="江门">江门</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410800" data-cityname="焦作">焦作</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="445200" data-cityname="揭阳">揭阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620300" data-cityname="金昌">金昌</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330700" data-cityname="金华">金华</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="210700" data-cityname="锦州">锦州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140500" data-cityname="晋城">晋城</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140700" data-cityname="晋中">晋中</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420800" data-cityname="荆门">荆门</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="421000" data-cityname="荆州">荆州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360200" data-cityname="景德镇">景德镇</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360400" data-cityname="九江">九江</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230300" data-cityname="鸡西">鸡西</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620900" data-cityname="酒泉">酒泉</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">K</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="530100" data-cityname="昆明">昆明</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="653100" data-cityname="喀什地区">喀什地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410200" data-cityname="开封">开封</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="650200" data-cityname="克拉玛依">克拉玛依</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="653000" data-cityname="克孜勒苏柯尔克孜自治州">克孜勒苏柯尔克孜自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659008" data-cityname="可克达拉">可克达拉</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">L</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="540100" data-cityname="拉萨">拉萨</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="451300" data-cityname="来宾">来宾</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="371200" data-cityname="莱芜">莱芜</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620100" data-cityname="兰州">兰州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="131000" data-cityname="廊坊">廊坊</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="511100" data-cityname="乐山">乐山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="530700" data-cityname="丽江">丽江</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="331100" data-cityname="丽水">丽水</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320700" data-cityname="连云港">连云港</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="513400" data-cityname="凉山彝族自治州">凉山彝族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="211000" data-cityname="辽阳">辽阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220400" data-cityname="辽源">辽源</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="371500" data-cityname="聊城">聊城</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="540400" data-cityname="林芝">林芝</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="530900" data-cityname="临沧">临沧</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="141000" data-cityname="临汾">临汾</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="622900" data-cityname="临夏回族自治州">临夏回族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="371300" data-cityname="临沂">临沂</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450200" data-cityname="柳州">柳州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341500" data-cityname="六安">六安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="520200" data-cityname="六盘水">六盘水</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350800" data-cityname="龙岩">龙岩</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="621200" data-cityname="陇南">陇南</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="431300" data-cityname="娄底">娄底</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510500" data-cityname="泸州">泸州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="141100" data-cityname="吕梁">吕梁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410300" data-cityname="洛阳">洛阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="411100" data-cityname="漯河">漯河</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469024" data-cityname="临高">临高</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469027" data-cityname="乐东黎族自治县">乐东黎族自治县</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469028" data-cityname="陵水黎族自治县">陵水黎族自治县</a></li>';
    html += '</ul>';
    html += '</div>';

    

    html += '</div>';

    html += '<div class="panel" style="display:none;">';

    html += '<div class="item">';
    html += '<div class="tt">M</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="340500" data-cityname="马鞍山">马鞍山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440900" data-cityname="茂名">茂名</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="511400" data-cityname="眉山">眉山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441400" data-cityname="梅州">梅州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510700" data-cityname="绵阳">绵阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="231000" data-cityname="牡丹江">牡丹江</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">N</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="511000" data-cityname="内江">内江</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="542400" data-cityname="那曲地区">那曲地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360100" data-cityname="南昌">南昌</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="511300" data-cityname="南充">南充</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320100" data-cityname="南京">南京</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450100" data-cityname="南宁">南宁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350700" data-cityname="南平">南平</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320600" data-cityname="南通">南通</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="411300" data-cityname="南阳">南阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330200" data-cityname="宁波">宁波</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350900" data-cityname="宁德">宁德</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="533300" data-cityname="怒江傈僳族自治州">怒江傈僳族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="533300" data-cityname="怒江傈僳族自治州">怒江傈僳族自治州</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">P</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="510400" data-cityname="攀枝花">攀枝花</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="211100" data-cityname="盘锦">盘锦</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410400" data-cityname="平顶山">平顶山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620800" data-cityname="平凉">平凉</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360300" data-cityname="萍乡">萍乡</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350300" data-cityname="莆田">莆田</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410900" data-cityname="濮阳">濮阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="530800" data-cityname="普洱">普洱</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">Q</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="230900" data-cityname="七台河">七台河</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230200" data-cityname="齐齐哈尔">齐齐哈尔</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="522600" data-cityname="黔东南苗族侗族自治州">黔东南苗族侗族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="522700" data-cityname="黔南布依族苗族自治州">黔南布依族苗族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="522300" data-cityname="黔西南布依族苗族自治州">黔西南布依族苗族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450700" data-cityname="钦州">钦州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130300" data-cityname="秦皇岛">秦皇岛</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370200" data-cityname="青岛">青岛</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441800" data-cityname="清远">清远</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="621000" data-cityname="庆阳">庆阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="530300" data-cityname="曲靖">曲靖</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330800" data-cityname="衢州">衢州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350500" data-cityname="泉州">泉州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469002" data-cityname="琼海">琼海</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469030" data-cityname="琼中黎族苗族自治县">琼中黎族苗族自治县</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="429005" data-cityname="潜江">潜江</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">R</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="540200" data-cityname="日喀则">日喀则</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="371100" data-cityname="日照">日照</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">S</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="411200" data-cityname="三门峡">三门峡</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350400" data-cityname="三明">三明</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="460300" data-cityname="三沙">三沙</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="460200" data-cityname="三亚">三亚</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="540500" data-cityname="山南">山南</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440500" data-cityname="汕头">汕头</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441500" data-cityname="汕尾">汕尾</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="611000" data-cityname="商洛">商洛</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="411400" data-cityname="商丘">商丘</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="310100" data-cityname="上海">上海</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="361100" data-cityname="上饶">上饶</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440200" data-cityname="韶关">韶关</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430500" data-cityname="邵阳">邵阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330600" data-cityname="绍兴">绍兴</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440300" data-cityname="深圳">深圳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="210100" data-cityname="沈阳">沈阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420300" data-cityname="十堰">十堰</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130100" data-cityname="石家庄">石家庄</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="640200" data-cityname="石嘴山">石嘴山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230500" data-cityname="双鸭山">双鸭山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140600" data-cityname="朔州">朔州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220300" data-cityname="四平">四平</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220700" data-cityname="松原">松原</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320500" data-cityname="苏州">苏州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="321300" data-cityname="宿迁">宿迁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341300" data-cityname="宿州">宿州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="231200" data-cityname="绥化">绥化</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="421300" data-cityname="随州">随州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510900" data-cityname="遂宁">遂宁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="429021" data-cityname="神农架林区">神农架林区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659001" data-cityname="石河子">石河子</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659007" data-cityname="双河">双河</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">T</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="654200" data-cityname="塔城地区">塔城地区</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="331000" data-cityname="台州">台州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140100" data-cityname="太原">太原</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370900" data-cityname="泰安">泰安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="321200" data-cityname="泰州">泰州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130200" data-cityname="唐山">唐山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="120100" data-cityname="天津">天津</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620500" data-cityname="天水">天水</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="211200" data-cityname="铁岭">铁岭</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="220500" data-cityname="通化">通化</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150500" data-cityname="通辽">通辽</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610200" data-cityname="铜川">铜川</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="340700" data-cityname="铜陵">铜陵</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="520600" data-cityname="铜仁">铜仁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="650400" data-cityname="吐鲁番">吐鲁番</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469022" data-cityname="屯昌">屯昌</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="429006" data-cityname="天门">天门</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659003" data-cityname="图木舒克">图木舒克</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659006" data-cityname="铁门关">铁门关</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="710000" data-cityname="台湾">台湾</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '</div>';

    html += '<div class="panel" style="display:none;">';

    html += '<div class="item">';
    html += '<div class="tt">W</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="371000" data-cityname="威海">威海</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370700" data-cityname="潍坊">潍坊</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610500" data-cityname="渭南">渭南</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330300" data-cityname="温州">温州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="532600" data-cityname="文山壮族苗族自治州">文山壮族苗族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150300" data-cityname="乌海">乌海</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="150900" data-cityname="乌兰察布">乌兰察布</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="650100" data-cityname="乌鲁木齐">乌鲁木齐</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320200" data-cityname="无锡">无锡</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="640300" data-cityname="吴忠">吴忠</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="340200" data-cityname="芜湖">芜湖</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450400" data-cityname="梧州">梧州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420100" data-cityname="武汉">武汉</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620600" data-cityname="武威">武威</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469001" data-cityname="五指山">五指山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469005" data-cityname="文昌">文昌</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="469006" data-cityname="万宁">万宁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="659004" data-cityname="五家渠">五家渠</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">X</div>';
    html += '<ul class="clearfix">';
    html += '<li><a href="javascript:void(0);" data-citycode="610100" data-cityname="西安">西安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="630100" data-cityname="西宁">西宁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="532800" data-cityname="西双版纳傣族自治州">西双版纳傣族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="152500" data-cityname="锡林郭勒盟">锡林郭勒盟</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350200" data-cityname="厦门">厦门</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="421200" data-cityname="咸宁">咸宁</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610400" data-cityname="咸阳">咸阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430300" data-cityname="湘潭">湘潭</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="433100" data-cityname="湘西土家族苗族自治州">湘西土家族苗族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420600" data-cityname="襄阳">襄阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420900" data-cityname="孝感">孝感</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140900" data-cityname="忻州">忻州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410700" data-cityname="新乡">新乡</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360500" data-cityname="新余">新余</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="411500" data-cityname="信阳">信阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="152200" data-cityname="兴安盟">兴安盟</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130500" data-cityname="邢台">邢台</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320300" data-cityname="徐州">徐州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="411000" data-cityname="许昌">许昌</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="341800" data-cityname="宣城">宣城</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="429004" data-cityname="仙桃">仙桃</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="810000" data-cityname="香港特别行政区">香港特别行政区</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">Y</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="511800" data-cityname="雅安">雅安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370600" data-cityname="烟台">烟台</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610600" data-cityname="延安">延安</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="222400" data-cityname="延边朝鲜族自治州">延边朝鲜族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="320900" data-cityname="盐城">盐城</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="321000" data-cityname="扬州">扬州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441700" data-cityname="阳江">阳江</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140300" data-cityname="阳泉">阳泉</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="230700" data-cityname="伊春">伊春</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="654000" data-cityname="伊犁哈萨克自治州">伊犁哈萨克自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="511500" data-cityname="宜宾">宜宾</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="420500" data-cityname="宜昌">宜昌</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360900" data-cityname="宜春">宜春</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430900" data-cityname="益阳">益阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="640100" data-cityname="银川">银川</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="360600" data-cityname="鹰潭">鹰潭</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="210800" data-cityname="营口">营口</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="431100" data-cityname="永州">永州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="610800" data-cityname="榆林">榆林</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="450900" data-cityname="玉林">玉林</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="632700" data-cityname="玉树藏族自治州">玉树藏族自治州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="530400" data-cityname="玉溪">玉溪</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430600" data-cityname="岳阳">岳阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="445300" data-cityname="云浮">云浮</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="140800" data-cityname="运城">运城</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '<div class="item">';
    html += '<div class="tt">Z</div>';
    html += '<ul class="clearfix">';
     html += '<li><a href="javascript:void(0);" data-citycode="370400" data-cityname="枣庄">枣庄</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440800" data-cityname="湛江">湛江</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430800" data-cityname="张家界">张家界</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="130700" data-cityname="张家口">张家口</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="620700" data-cityname="张掖">张掖</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="350600" data-cityname="漳州">漳州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="530600" data-cityname="昭通">昭通</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="441200" data-cityname="肇庆">肇庆</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="321100" data-cityname="镇江">镇江</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="410100" data-cityname="郑州">郑州</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="442000" data-cityname="中山">中山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="640500" data-cityname="中卫">中卫</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="500100" data-cityname="重庆">重庆</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="330900" data-cityname="舟山">舟山</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="411600" data-cityname="周口">周口</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="430200" data-cityname="株洲">株洲</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="440400" data-cityname="珠海">珠海</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="411700" data-cityname="驻马店">驻马店</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="512000" data-cityname="资阳">资阳</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="370300" data-cityname="淄博">淄博</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="510300" data-cityname="自贡">自贡</a></li>';
    html += '<li><a href="javascript:void(0);" data-citycode="520300" data-cityname="遵义">遵义</a></li>';
    html += '</ul>';
    html += '</div>';

    html += '</div>';

    html += '</div>';
    $(".main-nav .container").append(html);
}


$(function () {
    setCity();
    loginTopSet()
    menuStamp(window.location.pathname);
    setCityHtml();




});