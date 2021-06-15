/**
 * read.jsp에서 사용할 스크립트
 */

$(function(){
   //operForm 가져온 후 전송하기
   var operForm=$("#operForm");
   
   //Modify버튼 클릭시 modify get 방식 /board/modify
   $(".btn-default").click(function(){
      operForm.attr('action','/board/modify');
      operForm.submit();
      
   })
   //list버튼 클릭시 get /board/list
   $(".btn-info").click(function(){
      operForm.find("input[name='bno']").remove();
      operForm.attr('action','/board/list');
      operForm.submit();
      
})
    //댓글 작업
    //모달 영역 가져오기
	let modal = $(".modal");
	
	$("#addReplyBtn").click(function(){
		modal.modal("show");
	})
     
    //댓글 삽입 - bno, reply(댓글 내용), replyer(작성자)
     $("modalRegisterBtn").click(function(){
	    replyService.add({bno:bno, reply:'댓글 테스트 중', replyer:'테스트'}, function(result){
		
		if(result){
			alert(result);
		}
		
	  }); //add 종료
     }) //#ModalRegisterBtn 종료
 
   //댓글 목록 가져오기
   replyService.getList({bno:bno,page:1},function(data){
	console.log(data);
   })
  

  //댓글 삭제
   $("#modalRemoveBtn").click(function(){
      
      replyService.remove(31, function(result){
	      alert(result);
      });

    }) //#ModalRemoveBtn 종료


  //댓글 수정
   $("#modalModifyBtn").click(function(){
       
      replyService.update({rno:1,reply:'댓글 수정'},function(result){
	    if(result){
		alert(result);
 	    }
     });
   }) //#ModalModifyBtn 종료


   //댓글 하나 가져오기
    replyService.get(10, function(data){
	  console.log(data)
  })

})