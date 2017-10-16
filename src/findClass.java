import java.util.*;
class findClass{
	public void nameClass(String s){
		String tmp = new String();
		if(s.contains("class ")) {	
			tmp= s.substring(6);
			tmp=tmp.replace("{", "");
			System.out.println(tmp);
		}
	}
}