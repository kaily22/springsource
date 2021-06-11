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
})