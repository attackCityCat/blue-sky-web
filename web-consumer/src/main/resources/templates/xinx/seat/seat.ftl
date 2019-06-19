<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>选座购票_大眼睛票务.电影</title>
    <meta name="renderer" content="webkit" />
    <meta name="keywords" content="大眼睛,大眼睛票务，大眼睛电影，电影，票务" />
    <meta name="description" content="大眼睛票务是覆盖全国的电影票在线选座平台，同时还提供全国电影排期，影院信息查询、电影行业资讯等服务。看电影，来大眼睛票务选座" />
    <link href="../css/seat/base.min.css" rel="stylesheet" />
    <link href="../css/seat/main.min.css" rel="stylesheet" />
    <script src="../js/seat/jquery.1.7.2.min.js" type="text/javascript"></script>
    <script src="../js/seat/json2.min.js" type="text/javascript"></script>
    <script src="../js/seat/jquery.tool.tabs.min.js" type="text/javascript"></script>
    <script src="../js/seat/layer.js" type="text/javascript"></script>
    <#--<script>
        var mobile = getCookie("Mobile");
        var cinemaID = getQueryString("cinemaID");
        var showNo = getQueryString("showNo");
        var salePrice = getQueryString("salePrice");

        var siteArr = new Array();
        var submiting = false;

        var filmWarnPop = false;
        var filmWarnMsg = "";
        var cinemaShowPopWin = false;
        var cinemaPopWinMsg = "";

        var isLogin = checkLogin();
        checkParam("cinemaID,showNo");

        function chooseChangCi(date, filmid) {
            var dataChangCi = "";
            $.ajax({
                url: '',
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                    "pMobile": window.sessionStorage.getItem("Mobile"),
                    "pCinemaID": cinemaID
                }),
                success: function (respDate) {
                    var data = respDate.d;
                    if (data.ResultCode == "0") {
                        var dataAll = data.Dates;
                        for (var i = 0; i < dataAll.length; i++) {
                            if (dataAll[i].ShowDate == date) {
                                var dataDay = dataAll[i].Films;
                                for (var j = 0; j < dataDay.length; j++) {
                                    if (dataDay[j].Film.FilmID == filmid) {
                                        dataChangCi = dataDay[j].Shows;
                                        break;
                                    }
                                }
                                break;
                            }
                        }

                        var htmlChooseChangci = '';

                        htmlChooseChangci += '<div class="cinema-info">';
                        htmlChooseChangci += '<h3>' + dataChangCi[0].CinemaName + '</h3>';
                        htmlChooseChangci += '<p><img src="' + dataChangCi[0].LogoPath + '" width="100%" /></p>';
                        htmlChooseChangci += '<p class="addr">地址：' + dataChangCi[0].Addr + '</p>';
                        if (!isNull(dataChangCi[0].Phone)) {
                            htmlChooseChangci += '<p>电话：' + dataChangCi[0].Phone + '</p>';
                        }
                        //htmlChooseChangci += '<p>营业时间：9：00-24：00</p>';
                        htmlChooseChangci += '</div>';
                        htmlChooseChangci += '<div class="changci">';
                        htmlChooseChangci += '<h4>场次</h4>';
                        htmlChooseChangci += '<ul>';
                        for (var i = 0; i < dataChangCi.length; i++) {
                            var salePrice = parseFloat((dataChangCi[i].SaleSettle + dataChangCi[i].SaleFee).toFixed(2));
                            htmlChooseChangci += '<li><a href="/filmchooseseat.html?cinemaID=' + dataChangCi[i].CinemaID + '&showNo=' + dataChangCi[i].ShowNo + '&salePrice=' + salePrice + '">' + dataChangCi[i].ShowTime + '</a></li>';
                        }
                        htmlChooseChangci += '</ul>';
                        htmlChooseChangci += '</div>';
                        $(".choose-changci").html(htmlChooseChangci);

                        if (dataChangCi.length > 0) {
                            $(".chooseci").removeClass("hide").on("click", function () {
                                if ($(".choose-changci").hasClass("hide")) {
                                    $(".choose-changci").removeClass("hide");
                                } else {
                                    $(".choose-changci").addClass("hide");
                                }

                            })
                        }
                    } else {
                        alert(data.ErrMsg);
                    }
                },
                error: function () {
                    //alert(msgErrorGlobal);
                }
            });
        }

        var sessionid="";
        //设置sessionid
        $.ajax({
            url: '',
            type: 'get',
            success: function (respDate) {
                sessionid = respDate;
            },
            error: function () {
                //alert(msgErrorGlobal);
            }
        })

        var systemName = "";

        $(function () {
            if (!isLogin) return;
            //获取排期信息
            $.ajax({
                url: '',
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                    "pMobile": mobile,
                    "pCinemaID": cinemaID,
                    "pShowNo": showNo
                }),
                success: function (respDate) {
                    var data = respDate.d;
                    if (data.ResultCode == "0" || data.ResultCode == "300001"|| data.ResultCode == "300002" ||data.ResultCode == "300003") {
                        if (data.Shows && data.Shows.length > 0) {
                            var filmScheduling = data.Shows[0].Show;

                            var cinemaName = filmScheduling.CinemaName;
                            var phone = filmScheduling.Phone;
                            var addr = filmScheduling.Addr;
                            var busInfo = filmScheduling.BusInfo;
                            var filmId = filmScheduling.FilmID;
                            var filmName = filmScheduling.FilmName;
                            var copyLanguage = filmScheduling.CopyLanguage;
                            var logoPath = filmScheduling.LogoPath;
                            var postPath = filmScheduling.Post_Path;
                            var copyType = filmScheduling.CopyType;
                            var duration = filmScheduling.Duration;
                            var hallName = filmScheduling.HallName;
                            var showDate = filmScheduling.ShowDate;
                            var showTime = filmScheduling.ShowTime;

                            chooseChangCi(showDate, filmId);

                            //var saleSettle = parseFloat(filmScheduling.SaleSettle);
                            //var saleFee = parseFloat(filmScheduling.SaleFee);
                            //salePrice = parseFloat((saleSettle + saleFee).toFixed(2));

                            $(".choose-seat .seat-description").html("<span>" + cinemaName + hallName + "&nbsp;屏幕方向</span>");

                            var cinemaDescription = '<h4>影院信息：</h4>';
                            cinemaDescription += '<p><span>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</span><span>' + txtShow(filmScheduling.Phone) + '</span></p>';
                            cinemaDescription += '<p><span>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</span><span>' + txtShow(filmScheduling.Addr) + '</span></p>';
                            cinemaDescription += '<p><span>公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交：</span><span>' + txtShow(filmScheduling.BusInfo) + '</span></p>';
                            $(".cinema-description .cinema-info").html(cinemaDescription);

                            var htmlFilm = '<h2>' + filmName + '</h2><p>语言版本：' + copyLanguage + '/' + copyType + '</p><p>时长：' + duration + '分钟</p><span class="flim-pic"><img src="' + postPath + '" width="100%" height="93" /></span>';
                            $(".seat-info .film").html(htmlFilm);
                            $(".cinemaname .name").html(cinemaName);
                            $(".hallname").html(hallName);
                            $(".showtime").html(showDate + "&nbsp;" + showTime);
                            $(".ticket-price .num").text(salePrice + "元/1张");

                            var ticketNum = 0;
                            if (!isNull(getCookie("LockSiteInfo"))) {
                                ticketNum = getCookie("LockSiteInfo").split('|').length;
                            }
                            $(".ticket-num .num").text(ticketNum + "张");
                            var ticketTotal =parseFloat((ticketNum * salePrice).toFixed(2));
                            $(".total .num").text("¥" + ticketTotal);

                            $("input[name=mobile]").val(getCookie("Mobile"));

                        } else {
                            //没有排期信息
                        }
                    } else {
                        alert(data.ErrMsg);
                    }
                },
                error: function () {
                    //alert(msgErrorGlobal);
                },
                complete: function () {

                }
            })

            //获取座位图信息
            $.ajax({
                url: '',
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                    "pMobile": mobile,
                    "pCinemaID": cinemaID,
                    "pShowNo": showNo
                }),
                success: function (respDate) {
                    var data = respDate.d;
                    if (data.ResultCode == "0") {
                        systemName = data.SystemName.toLowerCase();
                        filmWarnMsg = data.Film_Warn_Msg;
                        filmWarnPop = data.Film_Warn_Pop;
                        //影片温馨提示
                        if (!isNull(filmWarnMsg)) {
                            $(".tip-import").html("温馨提示：<strong>" + filmWarnMsg + "</strong>").removeClass("hide");
                        }
                        if (filmWarnPop && !isNull(filmWarnMsg)) {
                            tipsImport(filmWarnMsg);
                        }
                        var isVista = systemName == "vista" ? true : false;
                        var seats = data.Areas;
                        var seatArea = seats.length;
                        if (seatArea > 0) {
                            var htmlSeats = "";
                            for (var i = 0; i < seatArea; i++) {
                                var start = i > 0 ? seats[i - 1].RowCount : 0;
                                var seatAreaName = seats[i].ShowSeatPiceName;
                                htmlSeats += setSeats(seats[i].RowCount, seats[i].ColCount, seats[i].Sites, start, seatAreaName, seatArea, seats[i].RowStart, seats[i].ColStart);
                            }
                            $("#seatmap").html(htmlSeats);
                        } else {
                            //没有座位图
                        }

                        function setSeats(row, col, seats, start, seatAreaName, seatArea, rowStart, colStart) {
                            //var colStart = 0;
                            var GraphRow = parseInt(row);
                            var GraphCol = parseInt(col);
                            var startIndex = start;
                            var strHtml = "";
                            if (seatArea > 1) {
                                strHtml += '<h2>' + seatAreaName + '</h2>';
                                strHtml += '<div class="seat-area"><div class="seattable-wrap"><table id="seattable" class="seatdt">';
                            } else {
                                strHtml += '<div class="seat-area"><div class="seattable-wrap"><table id="seattable" class="seatdt">';
                            }

                            var chooseseatArr = [];
                            //if (getCookie("LockSiteInfo") != null)
                            //    chooseseatArr = getCookie("LockSiteInfo").split('|');
                            var indexdtHtml = '<table id="indextable">';
                            for (var i = startIndex + rowStart; i <= GraphRow + rowStart; i++) {
                                var seatCol = "";
                                var strTemp = "<tr>";
                                var numTemp = 0;
                                for (var j = colStart; j <= GraphCol + colStart; j++) {
                                    var seat = getseat(seats, i, j, GraphRow, GraphCol, isVista);
                                    if (!isNull(seat)&&isNull(seatCol)) {
                                        seatCol = seat.Site.SeatRow;
                                    }
                                    if (seat != null) {
                                        if (seat.State === "0") {
                                            if (chooseseatArr.indexOf(seat.Site.SeatNo) > -1) {
                                                siteArr.push(seat.Site.SeatNo);
                                                setseat(seat.Site.SeatNo, seat.Site.SeatRow, seat.Site.SeatCol);
                                                strTemp += '<td><img data-seatcol="' + seat.Site.SeatCol + '" data-seatrow="' + seat.Site.SeatRow + '" data-seatno="' + seat.SeatNo + '" data-loveSite="' + seat.Site.loveSite + '" src="resource/images/seat_seled.png" onclick="seatclick(this)"/></td>';
                                            } else {
                                                if (seat.Site.loveSite == "0") {
                                                    strTemp += '<td><img data-seatcol="' + seat.Site.SeatCol + '" data-seatrow="' + seat.Site.SeatRow + '" data-seatno="' + seat.Site.SeatNo + '" data-loveSite="' + seat.Site.loveSite + '" src="resource/images/seat_able.png" onclick="seatclick(this)"/></td>';
                                                } else if (seat.Site.loveSite == "-1") {
                                                    strTemp += '<td><img data-seatcol="' + seat.Site.SeatCol + '" data-seatrow="' + seat.Site.SeatRow + '" data-seatno="' + seat.Site.SeatNo + '" data-loveSite="' + seat.Site.loveSite + '" src="resource/images/seat_unable.png"/></td>';
                                                } else if (seat.Site.loveSite == "-2") {
                                                    strTemp += '<td class="noseat"></td>';
                                                } else {
                                                    strTemp += '<td><img data-seatcol="' + seat.Site.SeatCol + '" data-seatrow="' + seat.Site.SeatRow + '" data-seatno="' + seat.Site.SeatNo + '" data-loveSite="' + seat.Site.loveSite + '" src="resource/images/seat_love.png" onclick="seatclick(this)"/></td>';
                                                }
                                            }
                                        }
                                        else
                                            strTemp += '<td><img data-seatcol="' + seat.Site.SeatCol + '" data-seatrow="' + seat.Site.SeatRow + '" data-seatno="' + seat.Site.SeatNo + '" data-loveSite="' + seat.Site.loveSite + '" src="resource/images/seat_unable.png" onclick="seatclick(this)"/></td>';
                                    }
                                    else {
                                        strTemp += '<td class="noseat"></td>';
                                        numTemp++;
                                    }
                                }
                                strTemp += "</tr>";
                                strHtml += strTemp;

                                if (numTemp == GraphCol) {
                                    if (start > 0) {
                                        indexdtHtml += '<tr><td align="center" valign="middle" >' + seatCol + '</td></tr>';
                                    } else {
                                        indexdtHtml += '<tr><td class="noseat"></td></tr>';
                                    }
                                } else {
                                    indexdtHtml += '<tr><td align="center" valign="middle" >' + seatCol + '</td></tr>';
                                }
                            }
                            strHtml += "</table>";
                            indexdtHtml += "</table>";
                            strHtml = strHtml + indexdtHtml + "</div></div>";
                            return strHtml;
                        }

                        //座位提示
                        $("#seattable td:not(.noseat)").find("img").hover(function (e) {
                            var _self = $(this);
                            var top = _self.offset().top-45;
                            var left = _self.offset().left - 3;
                            var seatcol = _self.attr("data-seatcol");
                            var seatrow = _self.attr("data-seatrow");
                            $("#uitips").css({ "top": top, "left": left }).removeClass("hide");
                            $("#uitips .ui-tips-main").html(seatrow + "排" + seatcol + "座");
                        }, function () {
                            $("#uitips").addClass("hide");
                        });

                        //提交订单
                        $("#confirmOrder").removeClass("disable ").on("click", function () {
                            var smsMobile = $.trim($("input[name=mobile]").val());
                            var checkcode = $.trim($("input[name=checkcode]").val());
                            var regMobile = /^((\(\d{2,4}\))|(\d{3,4}\-))?1[3|4|5|7|8]\d{9}$/;
                            var regCheckcode = /^[a-zA-Z0-9]{4,6}$/;
                            var siteInfo = "";
                            if (isNull(getCookie("Mobile"))) {
                                window.location.href = "/login.html";
                                return false;
                            }
                            if (!regMobile.test(smsMobile)) {
                                alert("手机号码不正确！");
                                $("input[name=mobile]").focus();
                                return false;
                            }
                            if (!regCheckcode.test(checkcode)) {
                                alert("验证码不正确！");
                                $("input[name=checkcode]").focus();
                                return false;
                            }
                            if (siteArr.length < 1) {
                                alert("请至少选择一个座位");
                                return false;
                            } else {
                                for (var i = 0; i < siteArr.length; i++) {
                                    if (i != siteArr.length - 1) {
                                        siteInfo += siteArr[i].seatno + "|";
                                    } else {
                                        siteInfo += siteArr[i].seatno;
                                    }
                                }
                            }
                            if (submiting == true) return false;
                            submiting = true;
                            confirmOrder(cinemaID, showNo, siteInfo, smsMobile, checkcode);
                        });

                    } else {
                        $("#seatmap").html('<p class="error">' + data.ErrMsg + '</p>');
                    }
                },
                error: function () {
                    //alert(msgErrorGlobal);
                },
                complete: function () {

                }
            });


        })

        function getseat(Sites, GraphRow, GraphCol, GraphRowTotal, GraphColTotal, isVista) {
            var site = null;
            //var GraphCol = GraphCol + colStart - 1;
            //console.log(GraphRow + "-" + GraphCol);
            for (var i = 0; i < Sites.length; i++) {
                var siteTemp = Sites[i];
                //console.log(siteTemp.Site.GraphRow + ":" + siteTemp.Site.GraphCol);
                if (!isVista) {
                    if (siteTemp.Site.GraphRow == GraphRow && siteTemp.Site.GraphCol == GraphCol) {
                        site = siteTemp;
                        break;
                    }
                } else {
                    if (GraphRowTotal - siteTemp.Site.GraphRow == GraphRow && GraphColTotal-siteTemp.Site.GraphCol == GraphCol) {
                        site = siteTemp;
                        break;
                    }
                }
            }
            return site;
        }

        function reductSite(seatno) {
            if (siteArr.length > 0) {
                var arryIndex = null;
                for (var i = 0; i < siteArr.length; i++) {
                    if (siteArr[i].seatno == seatno) {
                        arryIndex = i;
                        break;
                    }
                }
                arryIndex === null ? false : siteArr.splice(arryIndex, 1);
            }
        }

        function updateStatus() {
            var ticketNum = siteArr.length;
            var ticketTotal = parseFloat((ticketNum * salePrice).toFixed(2));
            var html = '<li class="noseat">你还未选择座位</li>';
            if (ticketNum > 0) {
                html = "";
                for (var i = 0; i < ticketNum; i++) {
                    html += '<li>' + siteArr[i].seatrow + '排' + siteArr[i].seatcol + '座</li>';
                }
            }
            $(".seat-list").html(html);
            $(".ticket-num .num").text(ticketNum + "张");
            $(".total .num").text("¥" + ticketTotal);
        }

        function seatclick(obj) {
            var _self = $(obj);
            var siteOtherTemp = {};
            var loveSite = _self.attr("data-loveSite");
            var seatno = _self.attr("data-seatno");
            var seatcol = _self.attr("data-seatcol");
            var seatrow = _self.attr("data-seatrow");
            var src = _self.attr("src");
            src = src.substr(src.lastIndexOf("/") + 1);
            var siteTemp = {
                "seatno": seatno,
                "seatcol": seatcol,
                "seatrow": seatrow
            };
            if (src === "seat_able.png") {
                if (siteArr.length > 3) {
                    alert("一次最多只能选择4个座位");
                } else {
                    _self.attr("src", "/resource/images/seat_seled.png");
                    siteArr.push(siteTemp);
                }
            } else if (src === "seat_love.png") {
                if (siteArr.length > 2) {
                    alert("一次最多只能选择4个座位");
                } else {
                    var otherobj = null;
                    var otherobjStatus = null;
                    if (loveSite == "1") {
                        otherobj = _self.parent().next().find("img"); //情侣座二座
                        otherobjStatus = otherobj.attr("src").indexOf("seat_love.png") > -1 ? 1 : 2;
                    } else {
                        otherobj = _self.parent().prev().find("img"); //情侣座首座
                        otherobjStatus = otherobj.attr("src").indexOf("seat_love.png") > -1 ? 1 : 2;
                    }
                    _self.attr("src", "/resource/images/seat_seled.png");
                    siteArr.push(siteTemp);
                    siteOtherTemp = {
                        "seatno": otherobj.attr("data-seatno"),
                        "seatcol": otherobj.attr("data-seatcol"),
                        "seatrow": otherobj.attr("data-seatrow")
                    };
                    if (otherobjStatus == 1) {
                        otherobj.attr("src", "/resource/images/seat_seled.png");
                        siteArr.push(siteOtherTemp);
                    }
                }
            } else if (src === "seat_seled.png") {
                if (loveSite === "0") {
                    _self.attr("src", "/resource/images/seat_able.png");
                    reductSite(seatno);
                } else {
                    var otherobj = null;
                    var otherobjStatus = null;
                    if (loveSite == "1") {
                        otherobj = _self.parent().next().find("img"); //情侣座二座
                        otherobjStatus = otherobj.attr("src").indexOf("seat_seled.png") ? 1 : 2;
                    } else {
                        otherobj = _self.parent().prev().find("img"); //情侣座首座
                        otherobjStatus = otherobj.attr("src").indexOf("seat_seled.png") ? 1 : 2;
                    }
                    _self.attr("src", "/resource/images/seat_love.png");
                    reductSite(seatno);
                    var seatnoOther = otherobj.attr("data-seatno");
                    if (otherobjStatus == 1) {
                        otherobj.attr("src", "/resource/images/seat_love.png");
                        reductSite(seatnoOther);
                    }
                }
            }

            updateStatus();
        }

        function confirmOrder(cinemaID, showNo, siteInfo, smsMobile, checkcode) {
            layer.load(2);
            $.ajax({
                url: '/local.asmx/LockSite',
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                    "pMobile": getCookie("Mobile"),
                    "pCinemaID": cinemaID,
                    "pShowNo": showNo,
                    "pSiteInfo": siteInfo,
                    "pSmsMobile": smsMobile,
                    "sessionId": sessionid,
                    "checkCode": checkcode
                }),
                success: function (respDate) {
                    var data = respDate.d;
                    if (data.ResultCode == "0") {
                        window.location = "/pay.html?orderNo=" + data.LocalOrderNo;
                    } else if (data.ResultCode == "200002") {
                        alert(data.ErrMsg);
                        window.location.reload();
                    } else {
                        $(".checkcode .imgshow").trigger("click");
                        alert(data.ErrMsg);
                    }
                },
                error: function () {
                    //alert(msgErrorGlobal);
                },
                complete: function () {
                    submiting = false;
                    layer.closeAll();
                }
            });
        }

        function getRandom(n) {
            return Math.floor(Math.random() * n + 1);
        }
    </script>-->

	<style type="text/css">
		.containe .block{
 			box-sizing:border-box;
 		}

		.containe{
 			width:600px;
 			height:600px;
 			border:1px solid #3c3c3c;
 			margin:0 auto;
 		}

		.able{
			background: url('../img/seat_able.png') no-repeat center center/
 			100% 100%;
		}

		.seled{
			background: url('../img/seat_seled.png') no-repeat center center/
 			100% 100%;
		}

		.unable{
			background: url('../img/seat_unable.png') no-repeat center center/
 			100% 100%;
		}

		.love{
			background: url('../img/seat_love.png') no-repeat center center/
 			100% 100%;
		}


	</style>
</head>
<body>
    <div class="header">
        <div class="adv-top"></div>
        <div class="tip-web">尊敬的用户：大眼睛网站<strong>【电影售票系统】</strong> 目前正处于开展测试阶段，如有不足之处，敬请谅解，感谢您关注本网站！</div>
        <div class="header-nav">
            <div class="container clearfix"></div>
        </div>
        <div class="search-box clearfix">
            <div class="logo"><a href="/"><img src="resource/images/logo.jpg" alt="大眼睛票务网" /></a></div>
            <div class="search">
                <div class="search-input">
                    <input type="text" name="keywords" placeholder="请输入电影进行搜索" />
                    <span class="submit">搜索</span>
                </div>
                <div class="search-hot hide">
                    <a href="javascript:void(0);">星际特工</a>
                    <a href="javascript:void(0);">赛车总动员3</a>
                    <a href="javascript:void(0);">极盗车神</a>
                </div>
            </div>
            <div class="channel"><a href="http://www.daeyes.com/portal/eyes/perform/index.htm">演出</a><a href="/">电影</a></div>
        </div>
        <div class="main-nav">
            <div class="container clearfix">
                <ul class="menu clearfix">
                    <li class="city-btn"></li>
                    <li><a href="/index.html" data-index="index">首页</a></li>
                    <li><a href="/filmshowing.html" data-index="filmshowing">热映影片</a></li>
                    <li><a href="/filmfeature.html" data-index="filmfeature">即将上映</a></li>
                    <li><a href="/cinemas.html" data-index="cinemas">影院</a></li>
                </ul>
                <ul class="other clearfix">
                    <li><a href="/proTicket.html">新影联票卡产品</a></li>
                    <li><a href="/proCinema.html">新影联院线</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="main filmchooseseat">
        <div class="nav-tip">
            <ul class="clearfix">
                <li class="step_1 act1">1.选择影片场次</li>
                <li class="step_2 act2">2.在线选座，填写手机号码</li>
                <li class="step_3">3.确认订单并支付</li>
                <li class="step_4">4.终端机取票</li>
            </ul>
        </div>
        <div class="film-chooseseat clearfix">
            <div class="choose-seat">
                <div class="seat-description"></div>
                <div class="ico-description">
                    <ul class="clearfix">
                        <li><img src="../img/seat_able.png" height="28" />可选</li>
                        <li><img src="../img/seat_seled.png" height="28" />已选</li>
                        <li><img src="../img/seat_unable.png" height="28" />已售</li>
                        <li><img src="../img/seat_love.png" height="28" />情侣座</li>
                        <li> 空白为 不可用</li>
                    </ul>
                </div>
                <div class="seat-map" id="seatmap">
                    <div class="containe" id="box">
						
					</div>
                </div>
                <div class="tip-import hide"></div>
            </div>
            <div class="seat-info">
                <div class="seat-wrap">
                    <div class="film">
                        <!--<h2>王牌特工2：黄金圈</h2>
                        <p>语言版本：国语/数字2D</p>
                        <p>时长：107分钟</p>
                        <span class="flim-pic"><img src="/resource/images/default_1.jpg" width="100%" /></span>-->
                    </div>
                    <p class="item cinemaname"><span class="tt">影院：</span><span class="name">蓝天影城</span></p>
                    <p class="item hallname-wrap"><span class="tt">影厅：</span><span class="hallname"></span></p>
                    <p class="item"><span class="tt">场次：</span><span class="showtime"></span><span class="chooseci hide">更换</span></p>
                    <div class="item seats">
                        <span class="tt">座位：</span>
                        <ul class="seat-list clearfix" id="seatBox"></ul>
                        <p class="tip">单击左侧座位图选择座位，再次单击取消。</p>
                        
                    </div>
                </div>
                <div class="price-wrap">
                    <p class="item ticket-price"><span class="tt">票价：</span><span class="num"></span></p>
                    <p class="item ticket-num"><span class="tt">票数：</span><span class="num"></span></p>
                    <p class="item total"><span class="tt">总计（含手续费）：</span><span class="num"></span></p>
                </div>
                <div class="form">
                    <p class="item tip">输入取票的手机号码</p>
                    <p class="item"><span>手机号：</span><span class="mobile"><input type="text" id="phone" placeholder="请输入手机号码" /></span></p>
                    <p class="item checkcode clearfix"><span class="tt">验证码：</span><span><input id="checkcode" type="text" /></span><span class="imgshow"><a href="javascript:void(0);"><img src="/verificationCode" width="100%" alt="验证码" /></a></span></p>
                    <p class="item submit"><a class="btn" href="javascript:submitOrder(1);" id="confirmOrder">完成选择</a></p>
                </div>
                <div class="choose-changci clearfix hide">
                    <!--<h3>北京耀莱国际影城</h3>
                    <div class="cinema-info">
                        <p>地址：北京市海淀区55号</p>
                        <p>电话：010-65122222</p>
                        <p>营业时间：9：00-24：00</p>
                    </div>
                    <div class="changci">
                        <h4>场次</h4>
                        <ul>
                            <li>09:55</li>
                            <li>09:55</li>
                            <li>09:55</li>
                            <li>09:55</li>
                            <li>09:55</li>
                        </ul>
                    </div>-->
                </div>
            </div>

            <div class="cinema-description">
                <div class="cinema-info">
                    <!--<h4>影院信息：</h4>
                    <p><span>电　　话：</span><span>010-63522472</span></p>
                    <p><span>地　　址：</span><span>北京市西城区白广路8号</span></p>
                    <p><span>公　　交：</span><span>公交车19路、40路、741路枣林前街下车。 10路、48路、717路、88路牛街礼拜寺下车。 特5路、6路、38路、57路、109路、381路、477路、613路、676路、687路、715路、717路、831路、832路（原917专线）、835路（原917支线）、917路广安门内下车。</span></p>-->
                </div>
                <div class="description">
                    <h4>使用说明：</h4>
                    <p>1、每笔订单最多可选购4张电影票，情侣座不单卖；</p>
                    <p>2、选座时，请尽量选择相邻座位，不要留下单个座位；</p>
                    <p>3、点击“完成选座”后，请在10分钟内完成支付，超时系统将释放你选定的座位。</p>
                </div>
            </div>
            <div class="tips">
                <div class="container">
                    <h4>温馨提示：</h4>
                    <p>请您认真核对订单信息，电影票售出后，受票务系统限制，无法进行退换操作。</p>
                </div>
            </div>
        </div>
    </div>
    <!--ui tips-->
    <div class="ui-tips ui-tips-bottom hide" id="uitips">
        <div class="ui-tips-main"></div>
        <span class="ui-tips-arrow"></span>
    </div>
    <div class="footer">
        <div class="nav-quick">
            <ul class="clearfix">
                <li>
                    <h3>新手指南</h3>
                    <p><i>></i><a href="#">在线订购</a></p>
                    <p><i>></i><a href="#">电话订购</a></p>
                    <p><i>></i><a href="#">上门订购</a></p>
                    <p><i>></i><a href="#">大客户团体订购</a></p>
                </li>
                <li>
                    <h3>配送方式</h3>
                    <p><i>></i><a href="#">送货上门</a></p>
                    <p><i>></i><a href="#">电子票</a></p>
                    <p><i>></i><a href="#">上门自取</a></p>
                </li>
                <li>
                    <h3>支付方式</h3>
                    <p><i>></i><a href="#">电话支付</a></p>
                    <p><i>></i><a href="#">柜台支付</a></p>
                </li>
                <li>
                    <h3>账户安全</h3>
                    <p><i>></i><a href="#">找回密码</a></p>
                    <p><i>></i><a href="#">账户注册</a></p>
                    <p><i>></i><a href="#">账户绑定</a></p>
                </li>
                <li>
                    <h3>售后服务</h3>
                    <p><i>></i><a href="#">退换及缺货说明</a></p>
                    <p><i>></i><a href="#">发票帮助</a></p>
                    <p><i>></i><a href="#">验票说明</a></p>
                </li>
                <li>
                    <h3>特色服务</h3>
                    <p><i>></i><a href="#">大眼睛卡</a></p>
                    <p><i>></i><a href="#">积分商城</a></p>
                    <p><i>></i><a href="#">票务系统</a></p>
                    <p><i>></i><a href="#">场馆库</a></p>
                </li>
                <li class="code">
                    <div class="container">
                        <p>
                            <img src="resource/images/code.jpg" alt="公众号二维码" /></p>
                        <p>扫描关注大眼睛</p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="copyright">
            <div class="nav-copyright clearfix">
                <ul class="clearfix">
                    <li><a href="#">公司介绍</a></li>
                    <li><a href="#">合作机会</a></li>
                    <li><a href="#">法律公告</a></li>
                    <li><a href="#">友情链接</a></li>
                    <li><a href="#">联系我们</a></li>
                </ul>
            </div>
            <p>北京新影联文化传播有限责任公司 版权所有 Copyright 2003-2017 All Rights Reserved 京ICP备12006157号 营业性演出许可证 编号：京演（机构）［2017］3083号</p>
            <p>京公网安备 11010102002123号</p>
        </div>
    </div>

<input type="" id="paiqiId" value=${id}>
<input type="" id="seatId">

</body>

<script type="text/javascript">
    var n = 0;
	//按照难度等级加载
	init = function(n){

        $.ajax({
            url:'/xinx/init',
            data:{
                id:$("#paiqiId").val()
            },
            success:function (result) {
                if (result.hallType == 1)
                    n = 10;
                if (result.hallType == 2)
                    n = 15

                //定义单元格
                var block = '';

                var paiQiSeatBeans = result.paiQiSeatBeans;

                //行
                for (var i = 1; i <= n; i++) {
                    //列
                    for (var j = 1; j <= n; j++) {
                        var b = false;
                        for (var r = 0;r < paiQiSeatBeans.length;r++){
                            var status = paiQiSeatBeans[r].status;

                            if (status == 0)
                                status = "able";
                            if (status == 2)
                                status = "unable";

                            if (i == paiQiSeatBeans[r].seatBean.seatRow && j == paiQiSeatBeans[r].seatBean.seatCol){

                                block += '<div class="block '+status+'" seatId="'+paiQiSeatBeans[r].seatBean.id+'"  id="a'+i+'_'+j+'"  style="width:'+600/n+'px ;height:'+600/n+'px;float:left;line-height:'+600/n+'px;" onclick="leftClick()"></div>';
                                b = true;
                                break;
                            }
                        }

                        if (b){
                            continue;
                        }
                        //动态拼接单元格   id = ai_j  宽高 = 600/n  浮动    边框   行高   600/n   class = block
                        block += '<div class="block white"  id="a'+i+'_'+j+'"  style="width:'+600/n+'px ;height:'+600/n+'px;float:left;line-height:'+600/n+'px;" onclick="leftClick()"></div>';

                    }

                }

                //动态布局
                $("#box").html(block);

                var arr = document.querySelectorAll('.block');
                //给block绑定单击事件和右击事件
                for (var i = 0; i < arr.length; i++) {
                    arr[i].onclick = function(){
                        leftClick(this);
                    }
                }
            }
        })
	}

    leftClick = function(obj){
        if (obj.classList.contains('white')) {
            alert("此处不可选");
            return;
        }

        if (obj.classList.contains('unable')) {
            alert("已售");
            return;
        }

        if (obj.classList.contains('bad')) {
            alert("此处已坏");
            return;
        }

        if (obj.classList.contains('able')) {



            var id = obj.id;
            $("#"+id).toggleClass('able').toggleClass('seled');

            var seatId = $("#"+id).attr('seatId');
            var seatIds = $("#seatId").val();

            seatIds += seatIds == '' ? seatId : ','+seatId;
            $("#seatId").val(seatIds);
            var r_c = id.substr(1);
            var arr = r_c.split("_");

            var seats = $("#seatId").val().split(",");

            if (seats.length >= 4){
                alert("一次最多选四个");
                return;
            }

            var row = arr[0];
            var col = arr[1];
            var li = $("#seatBox").html() + '<li id="a'+id+'">'+row+'排'+col+'座</li>'
            $("#seatBox").html(li);
            return;
        }


        if (obj.classList.contains('seled')) {
            var id = obj.id;
            $("#"+id).toggleClass('seled').toggleClass('able');

            var seatIds = $("#seatId").val();
            var arr = seatIds.split(",");
            var ids = '';
            for (var i=0;i<arr.length;i++){
                if(arr[i] == $("#"+id).attr('seatId')){
                    continue;
                }
                ids += ids == '' ? arr[i] : ','+arr[i]
            }
            $("#seatId").val(ids);


            var r_c = id.substr(1);
            var arr = r_c.split("_");

            var row = arr[0];
            var col = arr[1];
            var li = $("#seatBox").html().replace('<li id="a'+id+'">'+row+'排'+col+'座</li>','');
            $("#seatBox").html(li);


            return;
        }



    }

    changeStatus = function(paiQiId,seatId,flag){

        $.ajax({
            url:'/xinx/changeStatus',
            data:{
                paiQiId:paiQiId,
                seats:seatId,
                flag:flag
            },
            success:function () {
                
            }
        })

    }
    submitOrder = function(userId){
	    var paiQiId = $("#paiqiId").val();
	    var seatIds = $("#seatId").val();
	    var phone = $("#phone").val();
        changeStatus(paiQiId,seatIds,2);

        $.ajax({
            url:'http://192.168.1.134:8082/queryOrderRJF',
            data:{
                phone:phone,
                paiqiId:paiQiId,
                userId:userId,
                seatIds:seatIds
            },
            success:function (data) {
                if (data)
                    location.href="http://192.168.1.134:8082/page/toOrder";
            }
        })

    }


	$(function(){
		init(10);
	})

    //更换图片验证码
    $(".checkcode .imgshow").on("click", function () {
        $(this).find("img").attr("src", "/verificationCode?t=" + new Date());
    });


	
</script>
</html>