import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
    public void docFile(String FILENAME) {
        findClass f2 = new findClass();
        String s = "";
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            findClass f = new findClass();
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
//        +


//        f2.nameClass(s);
//        f2.namePackage(s);
//        System.out.println(s);
       // return f2.nameClass(s) + "\n" + f2.namePackage(s);
        //System.out.println(s);
        f2.nameMethod(s);
    }

}
