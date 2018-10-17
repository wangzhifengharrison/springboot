/**
 * 
 */
$(function(){
	var registerEmployeeUrl = '/demo2/superadmin/addlogin';
	/*if click on the submit button will submit to database*/
	$('#registersubmit').click(function(){
    	var formData = {
    		loginName : $("#register_name").val(),
    		loginPassword : $("#register_password").val(),
    		
    	}
    	
    	var username = $.trim($('#register_name').val());
		var password = $.trim($('#register_password').val());
		
		if (username == "" || password == "") {
			alert("username and password can't be null");
		}else{
			$.ajax({
				url:registerEmployeeUrl,
				type:'POST',
				data:JSON.stringify(formData),
				contentType : "application/json",
				dataType : 'json',
				success:function(data){
					if(data.success){
						location.href='/demo2/registeradmin/index.html';
						$.toast("success to submit");
					}else{
						$.toast("fail to submit");
					}
				}
			});
		}
    	
    	resetData();
	});
	
	function resetData(){
    	$("#register_name").val("");
    	$("#register_password").val("");
    }
	
})