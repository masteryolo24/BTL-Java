import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class BufferedReaderExample1 {
	private static final String FILENAME = "C:\\Users\\Dell\\Desktop\\New Text Document (3).txt";
 
	public static void main(String[] args) {
		String s="";
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			findClass f= new findClass();
			String currentLine;
 
			br = new BufferedReader(new FileReader(FILENAME));
 
			while ((currentLine = br.readLine()) != null) {
				currentLine = currentLine.trim();
				currentLine = currentLine.replaceAll("\\s+"," ");
				f.nameClass(currentLine);
				//System.out.println(currentLine);
				s +=currentLine + " ";
			
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
		//System.out.println(s);
		s=s.replaceAll("\\s+"," ");
		System.out.println(s);
	}

}