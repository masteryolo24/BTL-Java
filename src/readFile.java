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
                currentLine = currentLine.replaceAll("\\s+", " ").replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
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
        s = s.replaceAll("\\s+", " ").replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "").trim();
        s= s.replace("{", " {").replace("(", " (").replace(") ", ")").replace("\"", " \" ").replace(" ;", ";").replace(" = ", "=").replace("= ", "=").replace(" =", "=");
        s = f2.deleteString(s);
        return s;
    }

}
