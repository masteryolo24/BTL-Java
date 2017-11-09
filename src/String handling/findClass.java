import java.util.*;
import java.io.*;
import java.lang.reflect.*;

class findClass{
    public String nameClass (String s) {
        int i1 = s.indexOf("class");
        int i2 = s.indexOf(" ", i1+6);
        String tmp = s.substring(i1+6, i2);
        tmp = tmp.replace("{", "");
        return "Class's Name: " + tmp;
    }


    public String namePackage(String s) {
        int i3= s.indexOf("package");
        String s2 = new String();
        if(i3 != -1) {
            int i4= s.indexOf(";");
            s2 = "Package's Name: "+s.substring(i3+8, i4);
        }
        return s2;
    }

//    public String nameMethod(String s) {
//        String str1 = s;
//        String tmp = new String();
//        if ((str1.contains("public ") || str1.contains("private ") || str1.contains("protected "))  && (str1.endsWith("{") == true || str1.endsWith(")") == true) && !str1.contains("class ")) {
//            str1= str1.replace("public ", "");
//            str1= str1.replace("private ", "");
//            str1= str1.replace("protected ", "");
//            str1= str1.replace("static ", "");
//            str1= str1.replace("{", "");
//            str1 =str1.replace(" (", "(");
//            str1= str1.replace(" args", "");
//            String[] str = str1.split(" ");
//            tmp=  "Method: " +str[1] + ": " + str[0];
//        }
//        return tmp;
//    }

	public void nameMethod(String s) {
		int i1 = s.indexOf("{");
		int i2 = s.indexOf("{", i1+1);
		int tmp = 0, tmp2;
		int count =0;
		String str;
		for (int i=i2; i <s.length()-1; i++){
		    if(count == 0){
		        tmp = i;
            }
		    if(s.charAt(i) == '{') {
                count++;
            }
		    if(s.charAt(i) == '}') {
		        count--;
		        if(count ==0) {
		            tmp2=i;
		            i = s.indexOf("{", tmp2);
                    str = s.substring(tmp, tmp2+1);
                    s= s.replace(str, "");
                    System.out.println(s);
                }
            }
        }
	}

//    public void nameAttribute(String s) {
//        String str = s;
//        String tmp = new String();
//    }

}
