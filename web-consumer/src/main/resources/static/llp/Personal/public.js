/////////判断是否为PC/////////////

function IsPC()
{
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}
function msgLoading(msg) {
    if(isUndefined(msg)){
        msg="数据加载中...";
    }
    var html = "";
    html += '<div class="eye_loading">';
    html += '<img src="' + '/portal/eyes/common/images/loading.gif" alt="'+ msg +'"><span  style="display:inline-block;width:100px;text-align:left;">'+ msg +'</span>';
    html += '</div>';
    return html;
}
function msgError(msg) {
    var html = "";
    html += '<div class="eye_error red">';
    html += '<span>' + msg + '</span>';
    html += '</div>';
    return html;
}
function dayanLogin() {
    layer.open({
        type: 2,
        title: ['', 'font-size:16px;color:#d73388;font-family:微软雅黑;'],
        area: ['400px', '470px'],
        fix: true, //不固定
        maxmin: false,
        content: G_sysBasePath + '/portal/eyes/slogin.htm?abcurl=' + abcurl
    });
}
/////////判断是否为PC端****/////////////

function checkPass(mobilestr) {
    if (!mobilestr.match(/^[0-9A-Aa-z_]+$/)) {
        return false;
    }
    return true;
}
function checkSubmitMobil(mobilestr) {
    if (!mobilestr.match(/^(\d{11})$/)) {
        return false;
    }
    return true;
}

//函数名:Str1CharAllInStr2
//功能介绍：str1中的字符是否都在str2中
//参数说明：str1是要检查的字符串，str2是特征字符集
//返回值：1：是  0：不是
function Str1CharAllInStr2(str1, str2)
{
    var i, j;
    for (i = 0; i < str1.length; i++)
    {
        j = str2.indexOf(str1.charAt(i));
        if (j == -1)
            return 0;
    }
    return 1;

}
/**
  * PlaceHolder组件
  * $(input).placeholder({
  *   word:     // @string 提示文本
  *   color:    // @string 文本颜色
  *   evtType:  // @string focus|keydown 触发placeholder的事件类型
  * })
  *
  * NOTE：
  *   evtType默认是focus，即鼠标点击到输入域时默认文本消失，keydown则模拟HTML5 placeholder属性在Firefox/Chrome里的特征，光标定位到输入域后键盘输入时默认文本才消失。
  *   此外，对于HTML5 placeholder属性，IE10+和Firefox/Chrome/Safari的表现形式也不一致，因此内部实现不采用原生placeholder属性
  */
$.fn.placeholder = function (option, callback) {
        var settings = $.extend({
                word: '',
                color: '#ccc',
                evtType: 'focus'
        }, option)
 
        function bootstrap($that) {
                // some alias
                var word    = settings.word
                var color   = settings.color
                var evtType = settings.evtType
 
                // default
                var defColor = $that.css('color')
                var defVal   = $that.val()
 
                if (defVal == '' || defVal == word) {
                        $that.css({color: color}).val(word)
                } else {
                        $that.css({color: defColor})
                }
 
                function switchStatus(isDef) {
                        if (isDef) {
                                $that.val('').css({color: defColor})   
                        } else {
                                $that.val(word).css({color: color})
                        }
                }
                function asFocus() {
                        $that.bind(evtType, function () {
                                var txt = $that.val()
                                if (txt == word) {
                                        switchStatus(true)
                                }
                        }).bind('blur', function () {
                                var txt = $that.val()
                                if (txt == '') {
                                        switchStatus(false)
                                }
                        })
                }
                function asKeydown() {
                        $that.bind('focus', function () {
                                var elem = $that[0]
                                var val  = $that.val()
                                if (val == word) {
                                        setTimeout(function () {
                                                // 光标定位到首位
                                                $that.setCursorPosition({index: 0})
                                        }, 10)                 
                                }
                        })
                }
 
                if (evtType == 'focus') {
                        asFocus()
                } else if (evtType == 'keydown') {
                        asKeydown()
                }
 
                // keydown事件里处理placeholder
                $that.keydown(function () {
                        var val = $that.val()
                        if (val == word) {
                                switchStatus(true)
                        }
                }).keyup(function () {
                        var val = $that.val()
                        if (val == '') {
                                switchStatus(false)
                                $that.setCursorPosition({index: 0})
                        }
                })
        }
 
        return this.each(function () {
                var $elem = $(this)
                bootstrap($elem)
                if ($.isFunction(callback))
            callback($elem)
        })
}
function isUndefined(variable) {
    return typeof variable == 'undefined' ? true : false;
}

//当前所在城市
function getNowCity() {
    var nowcity = $.cookie('daeyescity');
    if (!nowcity) {
        nowcity = "110000";
    }
    return nowcity;
}
function setNowCity(zonecode) {
    $.cookie('daeyescity', zonecode);
}
