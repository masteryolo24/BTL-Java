import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile2 {
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
                //bo 2 dong dau tien
                s += currentLine + "\n";
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
        //s = f2.deleteString3(s);
        // s = f2.deleteString4(s);

        return s;
    }

}
