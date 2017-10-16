import java.util.*;
import java.io.*;
class findClass{
	public void nameClass(String s){
//		String tmp = new String();
//		if(s.contains("public ")) {
//			tmp= s.substring(13);
//			tmp=tmp.replace("{", "");
//			System.out.println(tmp);
//		}
//		else if(s.contains("class ")){
//			tmp= s.substring(7);
//			tmp=tmp.replace("{", "");
//			System.out.println(tmp);
//		}
//
		String tmp = new String();
		if(s.contains("public class ") || s.contains("class ")) {
			if(s.contains("public class "))
				tmp= s.substring(13);
			else
				tmp= s.substring(6);
			tmp=tmp.replace("{", "");
			System.out.println(tmp);
		}

		public void nameMethod(String s){
			String[] tmp;
			int count;
			if(!s.contains("class") && s.contains("public ")){
				s= s.replace("public ", "");
				tmp = s.split("\\s");
				System.out.println(s[2]);
			}
	}
	}
}