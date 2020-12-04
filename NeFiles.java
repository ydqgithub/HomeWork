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
	 String path= "E:\\home\\practice"; //所创建文件的路径      
     String fileName = "TextB.txt"; //文件名及类型       
     File file1 = new File(path, "TextB.txt"); 
     File file0 = new File(path, "TextA.txt");
	public void create() throws IOException{ 
	        String text = "汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王" +
	        		"侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新" +
	        		"承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专" +
	        		"夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心" +
	        		"不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九" +
	        		"重城阙烟尘生千乘万骑西南行";
	        File f = new File(path);          
	        if(!f.exists()){       
	            f.mkdirs(); //创建目录 
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
	             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
	             String line;         
		            while ((line = br.readLine()) != null) {
		                // 一次读入一行数据
		                output0=new BufferedWriter(new OutputStreamWriter(
		                		new FileOutputStream(file0, true )));//读取一个txt文件并且将其写入另一个txt文件，不能覆盖原来文件内容
		                int i=1;
		                char[] str=line.toCharArray();//字符串转数组
		                for(char hz:str){
		                	output0.write(hz);		                	
		                	if(i%7==0&&i%14!=0)
		                		output0.write(",");
		                	if(i%14==0)
		                		output0.write("。"+"\r\n");
		                	i++;
		                }
		                int count=0;
		                System.out.println("请查找：");  
		                Scanner scan=new Scanner(System.in);
			            String str1= scan.next();
			            while(line.indexOf(str1)!=-1){
			            	int c=line.indexOf(str1);
			            	line=line.substring(c+str1.length());
			            	count++;
			            }
			            output0.write("“"+str1+"”出现的次数为："+count+"\r\n");
		            }        
	        output0.flush();
	        output0.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

