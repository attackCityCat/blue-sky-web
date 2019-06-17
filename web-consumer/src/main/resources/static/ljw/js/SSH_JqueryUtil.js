
/*批量删除


	contro:		字符串参数 后台controller层映射值，实参传递时要加 ''

	boo:		布尔类型参数 是否开启问询模式  true 开启 false 不开启
*/

delMany = function(contro,boo){
  		
  		var ids="";
  		var n=0;
  		$("input[name='ck']:checked").each(function(){
			ids += ids == "" ? $(this).val() : ","+$(this).val();
			n++;
		})
		if (n==0){
			alert("请选择要删除的数据");
		}else{
				if (boo)
				{
					if(confirm("确定要删除这"+n+"条数据吗？")&&n>0){
  					del(contro,ids);
  				}
				return;
			}
			del(contro,ids);
		}
		 		
}





/*单删

	contro:		字符串参数		后台controller层映射值，实参传递时要加 ''
	id:			数值类型参数	对应数据主键
	name:		对应数据名称
	boo:		布尔类型参数	是否开启问询模式  true 开启 false 不开启
*/
delOne = function(contro,id,name,boo){
	
	if (boo)
	{
		if(confirm("确定要删除"+name+"吗？")){
  			del(contro,id);
  		}
		return;
	}
	del(contro,id);
  	
}

/*全选*/
allCheck = function(){
		
    	$("[name='ck']").each(function(){
			$(this).prop("checked",$("#all").prop("checked"));
		});

}


/*反选*/
backCheck = function(){
		
    	$("[name='ck']").each(function(){
			if($(this).prop("checked")){
				$(this).prop("checked",false);
			}else{
				$(this).prop("checked",true);
			}
		});
}



/*删除

	contro:		字符串参数		后台controller层映射值，实参传递时要加 ''
	id:			字符串类型参数	对应实际传入后台主键集合字符串
*/
del = function(contro,id){
	
	$.ajax({
		url:contro+"/del.do",
		type:"post",
		data:{
			id:id
		},
		dataType:"json",
		success:function(){
			show();
		},
		error:function(){}
	});
}


/*上下架
	contro:		字符串参数 后台controller层映射值，实参传递时要加 ''
	id:			数值类型参数 对应数据主键，一般为ID
	flag:		数值类型参数，用来判断	上架或下架
*/
changeStatus = function(contro,id,flag){

	$.ajax({
		url:contro+"/changeStatus.do",
		type:'post',
		data:{
			id:id,
			flag:flag
		},
		dataType:'json',
		success:function(){
			show();
		},
		error:function(){
		
		}
	});

}


/*数据库查询下拉列表	实现联动效果
	contro:		字符串参数	后台controller层映射值，实参传递时要加 ''
	selectId:	字符串参数	所属下拉列表框ID，实参传递时要加 ''
	val:		数值型参数	所属上级数据编号
*/


get = function(contro,selectId,val){
				
				$.ajax({
  					
  					url:contro+"/querySelect.do",
  					type:"post",
					data:{
						val:val
					},
					dataType:'json',
  					success:function(data){
  						var op = "<option value='-1'>请选择</option>";
  						for (var i=0;i<data.length;i++) {
							op+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
						}
  						$("#"+selectId).html(op);
  					},
  					error:function(){}
  					
  				});
}


/*数据库查询数字型下拉列表
	contro:		字符串参数	后台controller层映射值，实参传递时要加 ''
	selectId:	字符串参数	所属下拉列表框ID，实参传递时要加 ''
*/

getIntSelect = function(contro,selectId){
				
				$.ajax({
  					
  					url:contro+"/get"+selectId+".do",
  					type:"post",
					dataType:'json',
  					success:function(data){
  						var op = "<option value='0'>请选择</option>";
  						for (var i=0;i<data.length;i++) {
							op+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
						}
  						$("#"+selectId).html(op);
  					},
  					error:function(){}
  					
  				});
}

/*数据库查询字符串型下拉列表
contro:		字符串参数	后台controller层映射值，实参传递时要加 ''
selectId:	字符串参数	所属下拉列表框ID，实参传递时要加 ''
*/
getStrSelect = function(contro,selectId){
	
	$.ajax({
			
			url:contro+"/get"+selectId+".do",
			type:"post",
		dataType:'json',
			success:function(data){
				var op = "<option value=''>请选择</option>";
				for (var i=0;i<data.length;i++) {
				op+="<option value='"+data[i]+"'>"+data[i]+"</option>";
			}
				$("#"+selectId).html(op);
			},
			error:function(){}
			
		});
}


/*
	根据主键查询对象	一般用于修改之前回显
	contro:		字符串参数		后台controller层映射值，实参传递时要加 ''
	id:			数值类型参数	对应数据主键，一般为ID
*/
queryById=function(contro,id){
  	location.href=contro+"/queryById.do?id="+id;
}



/*
	ajax 新增修改
	contro:		字符串参数 后台controller层映射值，实参传递时要加 ''
*/
addOrUpdate = function(contro,path){
			var form = new FormData($("#addForm")[0]);
			$.ajax({
					
					url:contro+"/addOrUpdate.do",
					data:form,//$("#addForm").serialize(),
					type:"post",
					dataType:'json',
					contentType:false,
					cache:false,
					processData:false,
					async:true,
					success:function(){
						if(confirm("操作成功是否继续？")){
							$("#addForm")[0].reset();
							return;
						}
						location.href=path+"view/list.jsp";
					},
					error:function(){}
			});

}


/*
ajax 注册
contro:		字符串参数 后台controller层映射值，实参传递时要加 '' 对应user
path:		字符串参数 根目录
*/

reg = function(contro,path){
	var form = new FormData($("#regForm")[0]);
	//var form = $("#regForm").serialize();
	$.ajax({
			
			url:contro+"/reg.do",
			data:form,
			type:"post",
			dataType:'json',
			contentType:false,
			cache:false,
			processData:false,
			async:true,
			success:function(data){
				if (data==0) {
					location.href=path+"user/login.jsp";
				}
				
				if (data==1) {
					$("#msg4").html("<font color='red'>验证码错误</font>");
					return;
				}

				if (data==2) {
					$("#msg1").html("<font color='red'>用户名已被注册</font>");
					return;
				}

			},
			error:function(){
				
				alert('后台出错了');
				
			}
	});

}

/*
ajax 登录
contro:		字符串参数 后台controller层映射值，实参传递时要加 '' 对应user
path:		字符串参数 根目录
*/
login = function(contro,path){

    			$.ajax({
    				
    				url:contro+"/login.do",
    				type:"post",
    				data:$("#loginForm").serialize(),
    				success:function(data){
    					
    					if (data==0) {
							top.location.href=path+"frame/main.jsp";
						}else if(data==1){
							$("#sp2").html("<font color='red'>验证码错误</font>");
						}else{
							$("#sp1").html("<font color='red'>用户名或密码错误</font>");
						}
    				
    				},
    				error:function(){
    				
    					alert('后台出错了');
    				}

    			})
    		
}






/*上传插件
 * 
 * contro：	字符串型参数		后台控制层映射值
 * path：	字符串型参数		根目录路径
 * 
 * */
ready = function(contro,path){
	//文件域ID
	$("#imgFile").uploadify({
	//插件自带  不可忽略的参数                                  
		'swf': path+'js/uploadify/uploadify.swf',
	//前台请求后台的url 不可忽略的参数                          //*****要修改路经
		'uploader': contro+'/addFile.do',
	//给div的进度条加背景 不可忽略 DIV ID
		'queueID': 'divDom',
	//上传文件文件名，和后台参数列表中形式参数保持一致
		'fileObjName' : 'file',
	//给上传按钮设置文字
		'buttonText': '上传图片',
	//设置文件是否自动上传
		'auto': true,
	//可以同时选择多个文件 默认为true  不可忽略
		'multi': false,
	//上传后队列是否消失
		'removeCompleted': true,
	//允许上传的文件后缀  
		'fileExt': '*.jpg;*.gif;*.png', 
	//
		'cancelImg': path+'js/uploadify/uploadify-cancel.png',  
	//队列消失时间
		'removeTimeout' : 1,
	//上传文件的个数，项目中一共可以上传文件的个数
		'uploadLimit':  -1,
		'fileTypeExts': '*.jpg;*.png;*.gif',
	//开始执行上传
		'onUploadStart':function(files){
			//$.messager.progress({ title:'提示',msg:'上传中...' });
		},
	//上传失败
		'onUploadError':function(){
			//$.messager.progress('close');
			//$.messager.alert('提示','上传失败');
		  	alert("上传失败");
		},
	//成功回调函数 file：文件对象。data后台输出数据
		'onUploadSuccess':function(file,data,response){
		  	//$.messager.progress('close');
			//  alert(data+file.name)
			if(data.substr(0,1)==("\"")){
				data = data.substr(1,data.length-2);
			}
			  var imgurl = path+"upload/"+data;
			  $("#imgDom").prop("src",imgurl);
			  $("#imgName").val(data);
		}
	});
}
/* 	验证用户名不可为空		checkUserName
 * 	
 * contro：		字符串型参数		后台控制层映射值	对应user	
 * 
 */

testUsername = function(){
	if($("[name='username']").val()!=""){
		$("#msg1").html("<font color='green'>√</font>");
		return true;
	}
	
	$("#msg1").html("<font color='red'>用户名不能为空</font>");
	return false;
	
}


//验证验证码不能为空
testCheckCode = function(){
	
	if ($("#checkCode").val()!='') {
		$("#msg4").html("<font color='green'>√</font>");
		return true;
	}
	$("#msg4").html("<font color='red'>验证码不能为空</font>");
	return false;
}





/* 	验证用户名是否已被注册		checkUserName
 * 	
 * contro：		字符串型参数		后台控制层映射值	对应user	
 * 
 */



checkUsername = function(contro){
	
	$.ajax({
		
		url:contro+"/checkUsername.do",
		data:{
			username:$("[name='username']").val()
		},
		dataType:'json',
		type:"post",
		success:function(data){

			if (data) {
				$("#msg1").html("<font color='green'>√</font>");
				return true;
			}
			$("#msg1").html("<font color='red'>该用户名太受欢迎，请换一个试一试</font>");
			return false;
		},
		error:function(){
			alert("后台出错了");
		}	
	});
}


//验证密码框不能为空
testPassword = function(){
	if($("[name='password']").val()!=""){
		$("#msg2").html("<font color='green'>√</font>");
		return true;
	}
	
	$("#msg2").html("<font color='red'>密码不能为空</font>");
	return false;
}


//验证重复密码与密码一致
testPassword2 = function(){
	if($("[name='password2']").val() == $("[name='password']").val()){
		$("#msg3").html("<font color='green'>√</font>");
		return true;
	}
	
	$("#msg3").html("<font color='red'>两次密码保持一致</font>");
	return false;
}


//表单验证，需要根据页面要求增删验证方法
//contro	对应控制层映射值
//path		根目录

test = function(){

	if (testCheckCode()&testPassword()&testPassword2()&testCheckCode()) {

		return true;
	}
	return false;

}

/*	跳转页面
 * 	basePath	根目录
 * 	path		目标页面目录
 */
go = function(basePath,path){
	location.href = basePath+path+".jsp";
}




//上下首尾
function toPage(flag){
 					
 					var now = document.getElementById("now");
 					
 					//总页数 
 					var size = document.getElementById("size").innerHTML;
 					//下一页
 					if(flag==3){
 					
 						if(now.value == size){
 							alert("sorry,已经是最后一页了！");
 							return;
 						}
 						
 						now.value++;

 					}
 					
 					//上一页
 					if(flag==2){
 					
 						if(now.value == 1){
 							alert("sorry,已经是最前边了！");
 							return;
 						}
 						
 						now.value--;
 					}
 					//首页
 					if(flag==1){
 					
 						if(now.value == 1){
 							alert("sorry,已经是第一页了！");
 							return;
 						}
 						
 						now.value=1;
 					}
 					//尾页
 					if(flag==4){
 					
 						if(now.value == size){
 							alert("sorry,已经是尾页了！");
 							return;
 						}
 						
 						now.value=size;
 					}
 					//提交
 					show();		
}




//跳转到指定页数
toChangeNow = function(flag){
  	$("#now").val(flag);
  	show();
}



//跳转到新增修改页面
//path 为 根目录
toAdd = function(path){
	location.href=path+"view/addOrUpdate.jsp";
}

//修改密码
updatePassword = function(contro,path){
	
	$.ajax({
		url:contro+"/updatePassword.do",
		type:"post",
		data:$("#updatePwForm").serialize(),
		dataType:"json",
		success:function(data){
			if (data==0) {
				if (confirm("修改密码成功，是否跳转到登录页面？")) {
					location.href=path+"user/login.jsp";
				}
				return;
			}else if(data==1){
				$("#msg4").html("<font color='red'>验证码错误</font>");
			}else{
				$("#msg1").html("<font color='red'>用户不存在</font>");
			}
		},
		error:function(){
			alert('后台出错了');
		}
	});
}

//获取验证码
getCode = function(){
	$("#img").prop("src",$("#img").prop("src")+"?"+new Date());
}

//下载
//contro	对应控制层映射值
//imgname	需要下载的文件名
download = function(contro,imgname){
	location.href=contro+"/download.do?imgname="+imgname;
}

//排序
//obj	隐藏域的jquery对象   name为sort的文本框
sort = function(obj){
	if(obj.val() == "asc"){
		obj.val("desc");
	}else{
		obj.val("asc");
	}
	show();
}
