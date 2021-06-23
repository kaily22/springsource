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

@Component //��ü ����
@Log4j2
public class FileCheckTask {
   @Autowired
   private BoardAttachMapper attach;
   
   //������ ������ ����Ʈ ������ �� ��
   private String getFolderYesterDay() {
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      Calendar c= Calendar.getInstance();
      
      c.add(Calendar.DATE, -1);
      String str=sdf.format(c.getTime());
      
      return str.replace("-", File.separator);   //2021-06-20 => 2021\06\20
   }
   
   
   //�����ͺ��̽��� ��ġ���� �ʴ� ������ �����Ѵٸ� ����
   
   @Scheduled(cron="0 * * * * *") //�ڵ����� ���ư�����
   public void checkFiles() {
      log.info("file check task ����..... ");
      
      //�����ͺ��̽� ������¥ ���� ����Ʈ ��������
      List<AttachFileDTO> oldList= attach.getOldFiles();
      
      // 2021\06\20\.u.uid_fileName =>�������� ���Ͽ� ���� ����
      //uploadPath + 
      
      List<Path> fileListPaths= oldList.stream()
         /* �� �����ͺ��̽� ���� ���*/      .map(vo->Paths.get("c:\\upload",vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
                              .collect(Collectors.toList());
      //List<Path> => c:\\upload\\2021\\06\\20\\sfsdfgsfd((uuid))_1.jpg
   
      

   //�����ͺ��̽� ���� ����� �������� ����� �̹��� ��θ� �����Ͽ� 
   //�����ͺ��̽� ���� ��Ͽ� �߰��Ѵ�.
   oldList.stream()
         .filter(vo->vo.isFileType()==true)
         .map(vo->Paths.get("c:\\upload",vo.getUploadPath(),"s_"+vo.getUuid()+"s_"+vo.getFileName()))
         .forEach(p->fileListPaths.add(p));
   
   //����(������ϰ� �����ͺ��̽� ���� ����� ���� �� ����)
   
   //���� ��¥�� ���� ��� �������� -������ �ִ� �� ������
   //�� ���� ��¥ ���� ���ϱ�
   File targetDir=Paths.get("c:\\upload",getFolderYesterDay()).toFile();
   //�� targetDir�� ���� - ���� ��� ������ �� �����ͺ��̽� ���� ��ϰ� ��ġ���� �ʴ´ٸ�
   //   removeFiles�� �߰�
   File[] removeFiles = targetDir.listFiles(f->fileListPaths.contains(f.toPath())==false);
   
   //removeFiles�� �ִ� ���� ���丮���� ����
   for(File remove:removeFiles) {
      log.warn(remove.getAbsolutePath()); //�������� ���ϵ��� ���
      remove.delete();
   }
   }
   
}