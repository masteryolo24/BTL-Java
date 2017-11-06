import java.util.*;
import java.io.*;
import java.lang.reflect.*;

class findClass{
    public void nameClass (String s) {
        int i1 = s.indexOf("class");
        int i2 = s.indexOf(" ", i1+6);
        String tmp = s.substring(i1+6, i2);
        tmp = tmp.replace("{", "");
        System.out.println("Class's Name: " +tmp);
    }


    public void namePackage(String s) {
        int i1= s.indexOf("package");
        if(i1 != -1) {
            int i2= s.indexOf(";");
            System.out.println("Package's Name: "+s.substring(i1+8, i2));
        }
    }

    public void nameMethod(String s) {
        String str1 = s;
        String tmp = new String();
        if ((str1.contains("public ") || str1.contains("private ") || str1.contains("protected "))  && (str1.endsWith("{") == true || str1.endsWith(")") == true) && !str1.contains("class ")) {
            str1= str1.replace("public ", "");
            str1= str1.replace("private ", "");
            str1= str1.replace("protected ", "");
            str1= str1.replace("static ", "");
            str1= str1.replace("{", "");
            str1 =str1.replace(" (", "(");
            str1= str1.replace(" args", "");
            String[] str = str1.split(" ");
            System.out.println("Method: " +str[1] + ": " + str[0]);
        }
    }

//	public void nameMethod(String s) {
//		int i1 = s.indexOf("{", s.indexOf("{"));
//		for (int i=i1; i<s.length(); i1++) {
//
//		}
//
//	}

    public void nameAttribute(String s) {
        String str = s;
        String tmp = new String();
    }

}
