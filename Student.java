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
    		  System.out.println("学号："); 
    		  xuehao=sc.nextInt();
        	  fw.write("学号："+String.valueOf(xuehao)+"\r\n");//若写入int型数据一次只能写进去一个 需要将其转化 成String类型
        	  System.out.println("姓名：");
        	  fw.write("姓名："+sc.next()+"\r\n");
        	  System.out.println("班级：");
        	  fw.write("班级："+sc.next()+"\r\n");
        	  System.out.println("专业：");
        	  fw.write("专业："+sc.next()+"\r\n"); 	  
        	  fw.flush();
    	      fw.close();
    	      System.out.println("请输入文件名：");
        	  String n;
        	  n=sc.next(); 
        	  if(n.equals("TextB")){
        		  cr.create();
        		  cr.read();  
        		System.out.println("提交成功！");  	    		
        	  }else{
        		  System.out.println("未找到作业，请重新提交。");   
        	  } 
         }catch(Exception e){
        	 System.out.println("格式错误");  
    	  }
    	 
      }
}
