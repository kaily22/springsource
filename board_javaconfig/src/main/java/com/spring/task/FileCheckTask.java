package com.spring.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.domain.AttachFileDTO;
import com.spring.mapper.BoardAttachMapper;

import lombok.extern.log4j.Log4j2;

@Component //객체 생성
@Log4j2
public class FileCheckTask {
   @Autowired
   private BoardAttachMapper attach;
   
   //전일자 폴더의 리스트 추출한 후 비교
   private String getFolderYesterDay() {
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      Calendar c= Calendar.getInstance();
      
      c.add(Calendar.DATE, -1);
      String str=sdf.format(c.getTime());
      
      return str.replace("-", File.separator);   //2021-06-20 => 2021\06\20
   }
   
   
   //데이터베이스랑 일치하지 않는 파일이 존재한다면 삭제
   
   @Scheduled(cron="0 * * * * *") //자동으로 돌아가도록
   public void checkFiles() {
      log.info("file check task 시작..... ");
      
      //데이터베이스 어제날짜 파일 리스트 가져오기
      List<AttachFileDTO> oldList= attach.getOldFiles();
      
      // 2021\06\20\.u.uid_fileName =>폴더안의 파일에 접근 가능
      //uploadPath + 
      
      List<Path> fileListPaths= oldList.stream()
         /* ㄴ 데이터베이스 파일 목록*/      .map(vo->Paths.get("c:\\upload",vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
                              .collect(Collectors.toList());
      //List<Path> => c:\\upload\\2021\\06\\20\\sfsdfgsfd((uuid))_1.jpg
   
      

   //데이터베이스 파일 목록을 기준으로 썸네일 이미지 경로를 추출하여 
   //데이터베이스 파일 목록에 추가한다.
   oldList.stream()
         .filter(vo->vo.isFileType()==true)
         .map(vo->Paths.get("c:\\upload",vo.getUploadPath(),"s_"+vo.getUuid()+"s_"+vo.getFileName()))
         .forEach(p->fileListPaths.add(p));
   
   //삭제(폴더목록과 데이터베이스 파일 목록을 비교한 후 삭제)
   
   //어제 날짜의 파일 목록 가져오기 -폴더에 있는 것 가져옴
   //① 어제 날짜 폴더 구하기
   File targetDir=Paths.get("c:\\upload",getFolderYesterDay()).toFile();
   //② targetDir에 접근 - 파일 목록 가져온 후 데이터베이스 파일 목록과 일치하지 않는다면
   //   removeFiles에 추가
   File[] removeFiles = targetDir.listFiles(f->fileListPaths.contains(f.toPath())==false);
   
   //removeFiles에 있는 내용 디렉토리에서 삭제
   for(File remove:removeFiles) {
      log.warn(remove.getAbsolutePath()); //지워지는 파일들의 경로
      remove.delete();
   }
   }
   
}