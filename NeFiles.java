package idea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class NeFiles {
	 String path= "E:\\home\\practice"; //�������ļ���·��      
     String fileName = "TextB.txt"; //�ļ���������       
     File file1 = new File(path, "TextB.txt"); 
     File file0 = new File(path, "TextA.txt");
	public void create() throws IOException{ 
	        String text = "������ɫ˼�����������󲻵������Ů���������������δʶ��������������һ��ѡ�ھ���" +
	        		"�����һЦ������������������ɫ������ԡ�������Ȫˮ��ϴ��֬�̶���������ʼ����" +
	        		"�ж���ʱ���޻��ս�ҡܽ����ů�ȴ�����������ո���Ӵ˾������糯�л���������Ͼ���Ӵ���ҹר" +
	        		"ҹ�󹬼�����ǧ����ǧ�谮��һ�����ױ�ɽ���ҹ��¥�����ʹ���õ��ֽ���ʿ����������Ż��������¸�ĸ��" +
	        		"������������Ů�깬�ߴ����������ַ�Ʈ�����Ż���������˿���վ�������������ܱ�Ķ���������������������" +
	        		"�س����̳���ǧ������������";
	        File f = new File(path);          
	        if(!f.exists()){       
	            f.mkdirs(); //����Ŀ¼ 
	        }   
	        if(!file1.exists()){              
	            try { 
	                file1.createNewFile();   
	            } catch (IOException e) { 
	                // TODO Auto-generated catch block 
	                e.printStackTrace(); 
	            } 
	   	            BufferedWriter output = null;
		        try {
//		            File file = new File("example.txt");
		            output = new BufferedWriter(new FileWriter(file1));
		            output.write(text);
		        } catch ( IOException e ) {
		            e.printStackTrace();
		        } finally {
		            if ( output != null ) 
		            	output.flush();
		            	output.close();
		        }
	             
	        } 
	         
	    } 
	  public void read() {
	        String pathname = "E:\\home\\practice\\TextB.txt";
	        BufferedWriter output0 = null;
	        try {
	        	FileReader reader = new FileReader(pathname);
	             BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
	             String line;         
		            while ((line = br.readLine()) != null) {
		                // һ�ζ���һ������
		                output0=new BufferedWriter(new OutputStreamWriter(
		                		new FileOutputStream(file0, true )));//��ȡһ��txt�ļ����ҽ���д����һ��txt�ļ������ܸ���ԭ���ļ�����
		                int i=1;
		                char[] str=line.toCharArray();//�ַ���ת����
		                for(char hz:str){
		                	output0.write(hz);		                	
		                	if(i%7==0&&i%14!=0)
		                		output0.write(",");
		                	if(i%14==0)
		                		output0.write("��"+"\r\n");
		                	i++;
		                }
		                int count=0;
		                System.out.println("����ң�");  
		                Scanner scan=new Scanner(System.in);
			            String str1= scan.next();
			            while(line.indexOf(str1)!=-1){
			            	int c=line.indexOf(str1);
			            	line=line.substring(c+str1.length());
			            	count++;
			            }
			            output0.write("��"+str1+"�����ֵĴ���Ϊ��"+count+"\r\n");
		            }        
	        output0.flush();
	        output0.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

