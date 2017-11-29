import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class mainProject {
	public void printOutput(String path) throws FileNotFoundException {
		readFile2 r = new readFile2();
		//System.out.println(r.docFile(".\\diagram.txt"));
		//final String path = "C:\\Users\\7th\\Desktop\\New folder";
		mainClass m = new mainClass();
		//path dan ra file source code
		//m.readAllClass(path);
		//path dan ra file output
		File file = new File(".\\diagram.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		m.readAllClass(path);
	}
}
