package tools;

import java.io.File;

public class readfilesname {
	public static void main(String[] args) {
		String lujin = "D:\360Downloads/JAVA/apache-tomcat-6.0.30/apache-tomcat-6.0.30/webapps/ROOT/";
		File dir = new File(lujin);   
	    //杩斿洖姝ゆ娊璞¤矾寰勪笅鐨勬枃浠� 
	    File[] files = dir.listFiles();
	    if (files == null)   
            return; 
	    for (int i = files.length-1; i >=0; i--) {   
	    //鍒ゆ柇姝ゆ枃浠舵槸鍚︽槸涓�釜鏂囦欢  
	        if (!files[i].isDirectory()) {   
	            String filename = files[i].toString();
	            System.out.println(filename);
	        }
	    }
	}
	
}
