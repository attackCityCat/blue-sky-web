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
