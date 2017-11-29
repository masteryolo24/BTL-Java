import java.io.File;

class mainClass {
	public void readAllClass(String s) {
		File folder  = new File(s);
		readFolder r = new readFolder();
		findClass r2 = new findClass();
		String str = r.listFilesForFolder(folder);
		str =str.trim();
		//System.out.println(str);
		r2.nameClass(str);
		r2.nameInterface(str);
		//r2.nameAttribute(s);
		//r2.nameMethod(s);

	}
}
