package idea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
	  
	  int xuehao;
      String name,major,clssroom;
      NeFiles cr=new NeFiles();
      
      public void handIn() throws IOException{
    	  Scanner sc=new Scanner(System.in);
    	  FileWriter fw=new FileWriter("E:\\home\\practice\\TextA.txt");
    	  try{
    		  System.out.println("ѧ�ţ�"); 
    		  xuehao=sc.nextInt();
        	  fw.write("ѧ�ţ�"+String.valueOf(xuehao)+"\r\n");//��д��int������һ��ֻ��д��ȥһ�� ��Ҫ����ת�� ��String����
        	  System.out.println("������");
        	  fw.write("������"+sc.next()+"\r\n");
        	  System.out.println("�༶��");
        	  fw.write("�༶��"+sc.next()+"\r\n");
        	  System.out.println("רҵ��");
        	  fw.write("רҵ��"+sc.next()+"\r\n"); 	  
        	  fw.flush();
    	      fw.close();
    	      System.out.println("�������ļ�����");
        	  String n;
        	  n=sc.next(); 
        	  if(n.equals("TextB")){
        		  cr.create();
        		  cr.read();  
        		System.out.println("�ύ�ɹ���");  	    		
        	  }else{
        		  System.out.println("δ�ҵ���ҵ���������ύ��");   
        	  } 
         }catch(Exception e){
        	 System.out.println("��ʽ����");  
    	  }
    	 
      }
}
