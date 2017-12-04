package BaiTapLon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile2 {
    private static final Object[] String = null;

	public String docFile(String FILENAME) {
        String s = "";
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String currentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((currentLine = br.readLine()) != null) {
                currentLine = currentLine.trim();

                s = s + currentLine + " ";
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        //s = s.trim();
        //s = s.replace("{", " {").replace("(", " (").replace(") ", ")").replace("\"", " \" ").replace(" ;", ";").replace(" = ", "=").replace("= ", "=").replace(" =", "=").replaceAll(";", " ;").replaceAll("\\s+", " ");

       
        return s;
    }
    
    public int countClass(String s) {
    	int count=0;
    	int i= s.indexOf(" Class ");
    	while (i!=-1) {
    		count++;
    		i= s.indexOf(" Class " , i+1);
    	}
    	return count;
    }
    
    public String getClassName(String s) {
    	String str = null;
    	int k=0;
    	int i = s.indexOf(" Class ");
    		int j =s.indexOf("+Name: ", i);
    		str =  s.substring(j, s.indexOf(" ", j+6));
    	return str;
    }
    
    public int countName(String s) {
    	int count=0;
    	int i= s.indexOf("+ ");
    	while (i!=-1) {
    		count++;
    		i= s.indexOf("+ " , i+1);
    	}
    	return count;
    }
    
    public String[] getName(String s) {
    	String[] str = null;
    	int i = s.indexOf("+ ");
    	int count =1;
    	while (i!=-1) {
    		int j = s.indexOf("+ ", i+1);
    		if (j==-1) {
    			j = s.indexOf("=", i+1);
    		}
    		str[count] = s.substring(i+1, j-1);
    		i = s.indexOf("+ ", i+1);
    	}
    	return str;
    }

    public String[][] getAll(String s ) {
    	readFile2 r= new readFile2();
    	String[][] getInfo = null;
    	int count=0;
    	int i = s.indexOf(" Class ");
    	while (i!=-1) {
    		int j = s.indexOf(" Class ", i+1);
    		String tmp = s.substring(i, j-1);
    		getInfo[count][0] = r.getClassName(tmp);
    		for (int k = 1 ; k<=countName(s); k++) {
    			getInfo[count][k] = r.getName(tmp+9)[k];
    		}
    		i = s.indexOf(" Class ", i+1);
    		count++;
    	}
    	return getInfo;
    }
}
