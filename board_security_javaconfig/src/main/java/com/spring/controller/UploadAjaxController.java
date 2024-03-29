package com.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j2
public class UploadAjaxController {

   @PreAuthorize("isAuthenticated()")
   @PostMapping("/uploadAjax")
   public ResponseEntity<List<AttachFileDTO>> uploadFormPost(MultipartFile[] uploadFile) {
      log.info("파일 업로드 요청");
      
      String uploadFileName = null;
      String uploadFolder = "c:\\upload";
      
      String uploadFolderPath = getFolder();
      File uploadPath = new File(uploadFolder, uploadFolderPath);
      
      if(!uploadPath.exists()) {
         uploadPath.mkdirs();
      }
      List<AttachFileDTO> attachList = new ArrayList<AttachFileDTO>();
      
      for (MultipartFile f : uploadFile) {
//         log.info("upload File Name : " + f.getOriginalFilename());
//         log.info("upload File Size : " + f.getSize());

         // 서버 폴더에 전송된 파일 저장하기
         // UUID 값 생성
         
         UUID uuid = UUID.randomUUID();
         
         uploadFileName = uuid.toString() + "_" + f.getOriginalFilename();
         
         AttachFileDTO attach = new AttachFileDTO();
         attach.setFileName(f.getOriginalFilename());
         attach.setUploadPath(uploadFolderPath);
         attach.setUuid(uuid.toString());
         
         try { 
            File saveFile = new File(uploadPath, uploadFileName);
            
            if(checkImageType(saveFile)) {
               attach.setFileType(true);
               //썸네일로 저장
               FileOutputStream thumnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
               InputStream in = f.getInputStream();
               Thumbnailator.createThumbnail(in, thumnail, 100,100);
               in.close();
               thumnail.close();
            }

            //파일 저장(원본 그대로)
            f.transferTo(saveFile);               
            attachList.add(attach);
            
         } catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      return new ResponseEntity<List<AttachFileDTO>>(attachList, HttpStatus.OK);
   }
   
   //썸네일 보여주기
   @GetMapping("/display")
   public ResponseEntity<byte[]>getFile(String fileName){
      log.info("썸네일 요청" +fileName);
      
      File file = new File("c:\\upload\\"+fileName);
      
      ResponseEntity<byte[]> entity = null;
      
      HttpHeaders headers = new HttpHeaders();
      try {
         headers.add("Content-Type", Files.probeContentType(file.toPath()));
         entity = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return entity;
   }
   
   @GetMapping(value= "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
   public ResponseEntity<Resource> downloadFile(String fileName){
      log.info("download file " +fileName);
      
      Resource resource = new FileSystemResource("c:\\upload\\"+fileName);
      
      //2021_06_17_b9a837e9-ebf2-4ca0-a368-81a9abf23298_원천징수.pdf
      
      HttpHeaders headers = new HttpHeaders();
      
      // 전체 파일명에서 uuid값을 제외한 파일명 추출 b9a837e9-ebf2-4ca0-a368-81a9abf23298_원천징수.pdf
      String uidFileName = resource.getFilename();
      //uuid값을 제외한 파일명 추출
      String resourceName = uidFileName.substring(uidFileName.indexOf("_")+1);
      
      try {
         headers.add("Content-Disposition", "attachment;filename="+URLEncoder.encode(resourceName,"utf-8"));
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
      
      return new ResponseEntity<Resource>(resource, headers,HttpStatus.OK);
   }
   
   //upload 폴더에 있는 파일 삭제
   @PreAuthorize("isAuthenticated()")
    @PostMapping("/deleteFile")
    public ResponseEntity<String> deleteFile(String fileName,String type){
       log.info("파일 삭제 : "+fileName+" type : "+type);
       
       try {
         File file=new File("c:\\upload\\"+URLDecoder.decode(fileName,"utf-8"));
         
         file.delete(); //일반 파일 삭제, 이미지인 경우 썸네일만 삭제
         
         if(type.equals("image")) {
            //원본 이미지 파일명 추출
            String largeName = file.getAbsolutePath().replace("s_", "");
            file=new File(largeName);
            file.delete(); //원본 이미지 파일 삭제
         }
         
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
       
       
       return new ResponseEntity<String>("success", HttpStatus.OK);
    }
   //첨부 파일이 이미지인지 아닌지 판단
   private boolean checkImageType(File file) {
      String  contentType;
      try {
         contentType=Files.probeContentType(file.toPath());
         return contentType.startsWith("image");
      }catch(IOException e) {
         e.printStackTrace();
      }
      return false;
   } //폴더 생성
   private String getFolder() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      
      Date date = new Date();
      String str = sdf.format(date); //"2021-06-17"
      
      return str.replace("-", File.separator);
   }
}