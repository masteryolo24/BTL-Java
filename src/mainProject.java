package BaiTapLon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class mainProject {
	public static void main(String[] args) throws FileNotFoundException {
		mainClass m = new mainClass();
		m.readAllClass("C:\\Users\\DELL\\Desktop\\New folder\\Source Code\\");
		File file = new File("C:\\Users\\DELL\\Desktop\\New folder\\src\\BaiTapLon\\test.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		m.readAllClass("C:\\Users\\DELL\\Desktop\\New folder\\Source Code\\");
	}
}
