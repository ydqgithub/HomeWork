# HomeWork
### 计 G201 杨东奇 2020322083
## 实验报告
### 一、实验目的
* 掌握字符串String及其方法的使用
* 掌握文件的读取/写入方法
* 掌握异常处理结构
### 二、业务要求
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。<br/>
文件A包括两部分内容：<br/>
* 一是学生的基本信息；<br/>
* 二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：<br/>
1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”<br/>
2.允许提供输入参数，统计古诗中某个字或词出现的次数<br/>
3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A<br/>
4.考虑操作中可能出现的异常，在程序中设计异常处理程序<br/>

输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续><br/>
输出：<br/>
汉皇重色思倾国，御宇多年求不得。<br/>
杨家有女初长成，养在深闺人未识。<br/>
天生丽质难自弃，一朝选在君王侧。<br/>
回眸一笑百媚生，六宫粉黛无颜色。<br/>
春寒赐浴华清池，温泉水滑洗凝脂。<br/>
侍儿扶起娇无力，始是新承恩泽时。<br/>
云鬓花颜金步摇，芙蓉帐暖度春宵。<br/>
春宵苦短日高起，从此君王不早朝。<br/>
…………<br/>
### 三、实验要求
* 设计学生类（可利用之前的）；<br/>
* 采用交互式方式实例化某学生；<br/>
* 设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。<br/>
### 四、实验过程
1.写作业（即将字符串写入TextB文件）所以写一个NeFiles类，需要先建立一个TextB文件来存放作业。<br/>

    File file1 = new File(path, "TextB.txt"); 
    
2.在此类里面添加写作业的方法create(){}，将作业内容赋值给一个String对象，然后将其添加到TextB文件夹。<br/>

    output = new BufferedWriter(new FileWriter(file1));
    output.write(text);
    
3.在此类里写一个查看批改作业的方法read(){}，这个方法也是核心代码，用循环和条件语句算法，实现文本形式的转化和标点符号的添加。<br/>

		                int i=1;
		                char[] str=line.toCharArray();
		                for(char hz:str){
		                	output0.write(hz);		                	
		                	if(i%7==0&&i%14!=0)
		                		output0.write(",");
		                	if(i%14==0)
		                		output0.write("。"+"\r\n");
		                	i++;
		                }
                    
 4.继续在此类写实现查找字符出现次数的代码。<br/>
 
    while(line.indexOf(str1)!=-1){
			            	int c=line.indexOf(str1);
			            	line=line.substring(c+str1.length());
			            	count++;
			            }

5.开始写Student类，记录学生基本信息，使用Filewriter建立一个txt文件B，并且使用Scanner类获取控制台输入的内容（学生的基本信息），实例化NeFiles类。<br/>

      NeFiles cr=new NeFiles();
      FileWriter fw=new FileWriter("E:\\home\\practice\\TextA.txt");
      Scanner sc=new Scanner(System.in);
      xuehao=sc.nextInt();
      fw.write("学号："+String.valueOf(xuehao)+"\r\n");
      
6.在Student类中一个提交作业的方法，将学生的基本信息写入到TextA文件里，例如以下将姓名写进去。<br/>

    System.out.println("姓名：");
    fw.write("姓名："+sc.next()+"\r\n");
     
7.将作业名写到控制台中，仍然使用Scanner类实现。<br/>

     System.out.println("请输入文件名：");
        	  String n;
        	  n=sc.next(); 
            
8.在CreateFiles类中写一个readFile()方法，读取txt文件TextB并且将其写入另一个txt文件TextA中，且不能覆盖原来文件内容。<br/>

    output0=new BufferedWriter(new OutputStreamWriter(
		                		new FileOutputStream(file0, true )));
                        
9.作业存放在TextB中所以需要提交TextB，若不是B即不是本次作业，此处需要if语句来判断，只有正确提交作业名才能被批改作业（将实例化的对象cr调用写作业和批改作业的方法）。<br/>

              if(n.equals("TextB")){
        		  cr.create();
        		  cr.read();  } 
10.写主类Test，实例化Student类，在main方法里调用提交作业的方法。<br/>

     Student st=new Student();
         st.handIn();
	  
### 六、系统运行截图
![images](https://github.com/ydqgithub/HomeWork/blob/main/images/ydq.jpg)
### 七、实验感想
1.在这个实验中我练习使用了缓冲流、字节流、字符流。<br/>
2.写入字符流时int型特殊，需要强制转化成字符型。<br/>
3.练习使用了异常捕获eg：类名之后直接throws IOException，以及Scanner类和try...catch异常捕获。<br/>
4.练习使用了条件语句if...else、循环语句while、for。<br/>
5.学习使用了类的实例化。<br/>


