package com.spring.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		
		//������¥ ����
		LocalDate yesterday = LocalDate.now().minusDays(1);	
		
		String str = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		return str.replace("-", File.separator);  // 2021-06-20  => 2021\06\20
	}
	
	
	
	//�����ͺ��̽��� ��ġ���� �ʴ� ������ �����Ѵٸ� ����
	
	@Scheduled(cron="0 0 2 * * *")
	public void checkFiles() {
		log.info("file check task ����....");
		
		//�����ͺ��̽� ������¥ ���� ����Ʈ ��������
		List<AttachFileDTO> oldList=attach.getOldFiles();
		
		List<Path> fileListPaths= oldList.stream()
				                         .map(vo -> Paths.get("e:\\upload",vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
				                         .collect(Collectors.toList());
		
		//  List<Path> => e:\\upload\\2021\\06\\20\\dcdfdfee2ddfdf_1.jpg
		
		
		// �����ͺ��̽� ���� ����� �������� ����� �̹��� ��θ� �����Ͽ� 
		// �����ͺ��̽� ���� ��Ͽ� �߰��Ѵ�.
		oldList.stream()
		       .filter(vo -> vo.isFileType() == true)
		       .map(vo -> Paths.get("e:\\upload",vo.getUploadPath(),"s_"+vo.getUuid()+"_"+vo.getFileName()))
		       .forEach(p -> fileListPaths.add(p));
		
		
		//����(������ϰ� �����ͺ��̽� ���ϸ���� ���� �� ����)
		
		//������¥�� ���� ��� ��������
		//�� ������¥ ���� ���ϱ�
		File targetDir = Paths.get("e:\\upload", getFolderYesterDay()).toFile();
		//�� targetDir�� ���� �� ���� ��� ������ �� �����ͺ��̽� ���� ��ϰ� ��ġ���� �ʴ´ٸ�
		//   removeFiles �� �߰�
		File[] removeFiles = targetDir.listFiles(f -> fileListPaths.contains(f.toPath())==false);
		
		//removeFiles �� �ִ� ���� ���丮���� ����
		for(File remove:removeFiles) {
			log.warn(remove.getAbsolutePath());
			remove.delete();
		}		
	}	
}
