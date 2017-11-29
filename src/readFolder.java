//package BaiTapLon;

import java.io.File;

public class readFolder {
	public String listFilesForFolder(final File folder)   {
		String s= "";
		readFile r = new readFile();
		try {
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					listFilesForFolder(fileEntry);
				} else {
					//path dan ra file source code
					s += r.docFile("C:\\Users\\7th\\Desktop\\New folder\\" + fileEntry.getName()) + " ";
				}
			}
		}
		catch (NullPointerException e){
//			System.out.println("ERROR");
//			e.printStackTrace();
		}
	    return s;
	}
	
}
