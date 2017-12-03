package BaiTapLon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
    public String docFile(String FILENAME) {
        findClass f2 = new findClass();
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
                currentLine = currentLine.replace("(", " (").replace(") ", ")").replace("{", " {").replace("\"", " \" ").replace(" ;", ";").replace(" = ", "=").replace("= ", "=").replace(" =", "=").replaceAll(";", " ;").replaceAll("\\s+", " ");

                currentLine = currentLine.replaceAll("\\s+", " ").replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
                if(currentLine.indexOf("\"") < currentLine.indexOf("\'") || currentLine.indexOf("\'") == -1) {
                	currentLine = f2.deleteString3(currentLine);
                }
                if(currentLine.indexOf("\"") > currentLine.indexOf("\'") || currentLine.indexOf("\"") == -1) {
                	currentLine = f2.deleteString4(currentLine);
                }
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
        
        s = f2.deleteString(s);
        //s = s.trim();
        //s = s.replace("{", " {").replace("(", " (").replace(") ", ")").replace("\"", " \" ").replace(" ;", ";").replace(" = ", "=").replace("= ", "=").replace(" =", "=").replaceAll(";", " ;").replaceAll("\\s+", " ");

       
        return s;
    }

}
