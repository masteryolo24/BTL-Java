package BaiTapLon;

import java.io.File;


public class mainClass {
	public static void main(String[] args) {
		File folder  = new File("C:\\Users\\DELL\\Desktop\\New folder\\Source Code");
		readFolder r = new readFolder();
		findClass r2 = new findClass();
		String s = r.listFilesForFolder(folder);
		s =s.trim();
		//System.out.println(s);
		r2.nameClass(s);
		r2.nameAttribute(s);
	}
}
