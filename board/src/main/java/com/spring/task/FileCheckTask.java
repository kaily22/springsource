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

@Component
@Log4j2
public class FileCheckTask {
	
	@Autowired
	private BoardAttachMapper attach;
	
	//전일자 폴더의 리스트 추출한 후 비교
	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DATE, -1);
		String str = sdf.format(c.getTime());
		
		return str.replace("-", File.separator); //2021-06-20 => 2021\06\20
		
	}
	
	
	//db랑 일치하지 않는 파일이 존재한다면 삭제
	
	@Scheduled(cron="0 * * * * *")
	public void checkFiles() {
		log.info("file check task 시작....");
		
		//데이터베이스 파일 어제 날짜 파일 리스트 가져오기
		List<AttachFileDTO> oldList=attach.getOldFiles();
		
		List<Path> fileListPaths = oldList.stream()
				                   .map(vo -> Paths.get("c:\\upload", vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
				                   .collect(Collectors.toList());

		// List<Path> => "c:\\upload\\2021\\06\\20\\...1.jpg
		
		
		//폴더(이미지 썸네일)
		oldList.stream()
		       .filter(vo -> vo.isFileType() == true)
		       .map(vo -> Paths.get("c:\\upload", vo.getUploadPath(), "s_"+vo.getUuid()+"_"+vo.getFileName()))
		       .forEach(p -> fileListPaths.add(p));
		
		
		//삭제 (폴더 목록과 데이터베이스 파일 목록을 비교한 후 삭제)
		
		//어제 날짜의 파일 목록 가져오기
		//1) 어제 날짜 폴더 구하기
		File targetDir = Paths.get("c:\\upload",getFolderYesterDay()).toFile();
		//2) targetDir에 접근 후 파일 목록 가져오기
		//removeFiles에 추가
		File[] removeFiles = targetDir.listFiles(f->fileListPaths.contains(f.toPath()) == false);
		
		//3) removeFiles 에 있는 내용 디렉터리에서 삭제
		for(File remove : removeFiles) {
			log.warn(remove.getAbsolutePath());
			remove.delete();
		}
		
	}


}
