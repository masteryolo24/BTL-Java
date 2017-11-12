package BaiTapLon;

import java.io.File;

public class readFolder {
	public String listFilesForFolder(final File folder) {
		String s= "";
		readFile r = new readFile();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	s += r.docFile("C:\\Users\\DELL\\Desktop\\New folder\\Source Code\\" + fileEntry.getName()) + " ";
	        }
	    }
	    return s;
	}
	
}
