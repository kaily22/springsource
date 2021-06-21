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
	
	//������ ������ ����Ʈ ������ �� ��
	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DATE, -1);
		String str = sdf.format(c.getTime());
		
		return str.replace("-", File.separator); //2021-06-20 => 2021\06\20
		
	}
	
	
	//db�� ��ġ���� �ʴ� ������ �����Ѵٸ� ����
	
	@Scheduled(cron="0 * * * * *")
	public void checkFiles() {
		log.info("file check task ����....");
		
		//�����ͺ��̽� ���� ���� ��¥ ���� ����Ʈ ��������
		List<AttachFileDTO> oldList=attach.getOldFiles();
		
		List<Path> fileListPaths = oldList.stream()
				                   .map(vo -> Paths.get("c:\\upload", vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
				                   .collect(Collectors.toList());

		// List<Path> => "c:\\upload\\2021\\06\\20\\...1.jpg
		
		
		//����(�̹��� �����)
		oldList.stream()
		       .filter(vo -> vo.isFileType() == true)
		       .map(vo -> Paths.get("c:\\upload", vo.getUploadPath(), "s_"+vo.getUuid()+"_"+vo.getFileName()))
		       .forEach(p -> fileListPaths.add(p));
		
		
		//���� (���� ��ϰ� �����ͺ��̽� ���� ����� ���� �� ����)
		
		//���� ��¥�� ���� ��� ��������
		//1) ���� ��¥ ���� ���ϱ�
		File targetDir = Paths.get("c:\\upload",getFolderYesterDay()).toFile();
		//2) targetDir�� ���� �� ���� ��� ��������
		//removeFiles�� �߰�
		File[] removeFiles = targetDir.listFiles(f->fileListPaths.contains(f.toPath()) == false);
		
		//3) removeFiles �� �ִ� ���� ���͸����� ����
		for(File remove : removeFiles) {
			log.warn(remove.getAbsolutePath());
			remove.delete();
		}
		
	}


}
