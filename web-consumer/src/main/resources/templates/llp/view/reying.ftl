<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>大眼睛票务</title>



</head>

<body>

<script type="text/javascript">
    showInfo = function (id) {
        $("#info"+id).show('slow');
    }
    hideInfo = function (id) {
        $("#info"+id).hide('slow');
    }

</script>
<div class="main filmshowingpage">
    <div class="crumb">
        <p>
            <span>大眼睛</span><i>&gt;</i><span>热映影片</span>
        </p>

        <div class="search-box-films clearfix">
            <p class="des">共为您搜出<strong>#{count}</strong>部影片</p>
        </div>
    </div>


    <div class="film-list">
        <ul class="clearfix">
            <#list list as i >
                <li class="">
                    <div class="flogo" onmouseover="showInfo(${i.id})" onmouseout="hideInfo(${i.id})">
                        <a  href="JavaScript:toDetail(${i.id});">
                            <img class="logo" src="${i.img}" alt="${i.name}">
                        </a>
                        <div class="film-layer" id="info${i.id}" style="bottom: 0px;display: none">
                            <div class="info" >
                                <p>类型：${i.tagName}</p>
                                <p>片长：${i.length}分钟</p>
                            </div>
                            <div class="mask"></div>
                        </div>
                    </div>
                    <h3 class="texthide">${i.name}
                        <span class="price">
							<strong class="">¥${i.price}</strong>
						</span>
                    </h3>
                </li>
            </#list>
        </ul>
    </div>

    <div class="pagination">
        <ul class="clearfix">
            <li><a class="prev" onclick="toPage(1)">上一页</a></li>
            <li><a class="next" onclick="toPage(2)">下一页</a></li>
        </ul>
    </div>
    <input type="hidden" id="page" placeholder="当前页" value="${page}">
    <input type="hidden" id="pageSize" placeholder="最大页数" value="${pageSize}">
    <input type="hidden" id="pageNow" placeholder="总条数" value="${total}">
    <input type="hidden" id="rows" placeholder="每页条数" value="${rows}">
</div>




    <!-- tan -->
<script type="text/javascript">
    function tan(){
       alert("功能正在开发中！~~")
    }

    toPage = function (flag) {
        var page = $("#page").val();
        var pageSize = $("#pageSize").val();
        if (flag == 1){
            if (page == 1){
                alert("已经是第一页了")
                return;
            }
            $("#page").val(Number(page)-1);
            search();
        }

        if (flag == 2){
            if (page == pageSize){
                alert("已经是最后一页了")
                return;
            }
            $("#page").val(Number(page)+1);
            search();
        }

    }
</script>


</body>
</html>