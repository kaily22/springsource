/**
 * joinForm.jsp 유효성 검증
 */
$(function(){
	$("#modifyform").validate({
		rules:{			
			new_password:{
				required:true,
				validPwd:true
			},
			confirm_password:{
				required:true,
				validPwd:true,
				equalTo:"#new_password"
			}			
		},
		messages:{			
			new_password:{
				required:"비밀번호는 필수 요소입니다."				
			},
			confirm_password:{
				required:"비밀번호는 필수 요소입니다.",				
				equalTo:"이전 비밀번호와 다릅니다."
			}
		},
		errorPlacement:function(error,element){
			$(element).closest("form")
					  .find("small[id='"+element.attr('id')+"']")
					  .append(error);
		}
	})
})
//사용자만의 규칙 정의
$.validator.addMethod("validPwd",function(value){
    const regPwd=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^*])[A-Za-z\d!@#$%^*]{8,16}$/;
    return regPwd.test(value);
},"비밀번호는 영문자,숫자,특수문자의 조합으로 8~16자리로 만들어야 합니다.");







