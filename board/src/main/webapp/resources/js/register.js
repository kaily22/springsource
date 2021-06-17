/**
 *  파일 업로드
 */


$(function(){
	 $("input[type='file']").change(function(){
         
         //첨부 파일 가져오기
         var files=$("input[name='uploadFile']")[0].files;
         console.log(files);
         
         
         //첨부파일을 formData로 만들어 전송
         var formData=new FormData();
         for(var i=0;i<files.length;i++){
            formData.append("uploadFile",files[i]);
         }
         
         //인코딩
         //enctype="multipart/form-data" => processData:false, contentType:false,
         
         $.ajax({
            url:'/uploadAjax', //도착지 
            type:'post',
            processData:false,
            contentType:false,
            data:formData, //url~data/ : 1번으로 실행 => 서버로 =>'/uploadAjax' & post방식으로 받는 컨트롤러가 응답
            success:function(result){
               console.log(result);
               showUploadedFile(result);
            },
            error:function(xhr,status,error){
               console.log("에러");
            }
         })
      })//uploadBtn 종료
      
      function showUploadedFile(uploadResultArr){
         var str="";
         var uploadResult = $(".uploadResult ul");
         
         $(uploadResultArr).each(function(i,obj){
            if(obj.fileType){//image
               //썸네일 이미지 경로 링크
               // 2021\\06\\17\\s_693d3e90-ff28-4b18-963c-95320753376d_sa_pixar_virtualbg_insideout_16x9_cbaa0517
                 var fileCallPath = encodeURIComponent(obj.uploadPath+"\\s_"+obj.uuid+"_"+obj.fileName);
            
               //원본 이미지 경로
               var originPath=obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
               originPath=originPath.replace(new RegExp(/\\/g),"/");
            
                 str+="<li><a href=\"javascript:showImage(\'"+originPath+"\')\">";
                 str+="<img src='/display?fileName="+fileCallPath+"'>"+ obj.fileName+"</a>";
                 str+="<button type='button' class='btn btn-warning btn-circle btn-sm'><i class='fa fa-times'></i></button>";
                 str+="</li>";
            }else{
                var fileCallPath = encodeURIComponent(obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName);
               str+="<li><a href='/download?fileName="+fileCallPath+"'>";
               str+="<img src='/resources/img/attach.png'>"+ obj.fileName+"</a>";
               str+="<button type='button' class='btn btn-warning btn-circle btn-sm'><i class='fa fa-times'></i></button>";
               str+="</li>";
            }
         })
         
         uploadResult.append(str);
      }
      
})