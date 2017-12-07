package BaiTapLon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

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
	               if (currentLine.charAt(0)== '*' || currentLine.charAt(0) == 'D') currentLine = "";
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
	            s =s.replaceAll("\\s+", " ");
	        }
	        
	        return s;
	    }
	 
	 public String docFile2(String FILENAME) {
	        String s = "";
	        BufferedReader br = null;
	        FileReader fr = null;

	        try {

	            fr = new FileReader(FILENAME);
	            br = new BufferedReader(fr);
	            String currentLine;

	            br = new BufferedReader(new FileReader(FILENAME));

	            while ((currentLine = br.readLine()) != null) {
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
	            s =s.replaceAll("\\s+", " ");
	        }
	        
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
    		str =  s.substring(j+7, s.indexOf(" ", j+7));
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
    	String[] str = new  String[10000];
    	int i = s.indexOf("+ ");
    	int count =1;
    	while (i!=-1) {
    		int j = s.indexOf(": ", i+1);
    		str[count] = s.substring(i+2, s.indexOf(" ", j+2));
    		i = s.indexOf("+ ", i+1);
    		count++;
    	}
    	return str;
    }
    
    public void printAll(String s) {
    	System.out.println(s);
    }
    
    public String[][] getAll(String s ) {
    	readFile2 r= new readFile2();
    	String[][] getInfo = new String[10000][10000];
    	int count=0;
    	int i = s.indexOf(" Class ");
    	while (i!=-1) {
        	//System.out.println(i);
    		int j = s.indexOf(" Class ", i+1);
    		if(j ==-1) j = s.length();
    		//System.out.println(j);
    		String tmp = s.substring(i, j);
    		//System.out.println(tmp);
    		//System.out.println(r.getClassName(tmp));
    		getInfo[count][0] = r.getClassName(tmp);
    		for (int k = 1 ; k<=countName(s); k++) {
    			getInfo[count][k] = r.getName(tmp)[k];
    		}
    		i = s.indexOf(" Class ", i+1);
    		count++;
    	}
    	return getInfo;
    }
    
    public int countMethod(String s) {
    	int count =0;
    	for (int i=0; i<s.length(); i++) {
    		if (s.charAt(i) == '(') count++;
    	}
    	return count;
    }
    
    
    public int[] numberMethod(String s) {
    	int[] count1 = new int[10000];
    	readFile2 r= new readFile2();
    	int count=0;
    	int i = s.indexOf(" Class ");
    	while (i!=-1) {
    		int j = s.indexOf(" Class ", i+1);
    		if(j ==-1) j = s.length();
    		String tmp = s.substring(i, j);
    		//System.out.println(r.countName(tmp));
    		count1[count] = r.countMethod(tmp);
    		i = s.indexOf(" Class ", i+1);
    		count++;
    	}
    	return count1;
    }
    
    public int[] numberAttribute(String s) {
    	int[] count1 = new int[10000];
    	readFile2 r= new readFile2();
    	int count=0;
    	int i = s.indexOf(" Class ");
    	while (i!=-1) {
    		int j = s.indexOf(" Class ", i+1);
    		if(j ==-1) j = s.length();
    		String tmp = s.substring(i, j);
    		//System.out.println(r.countName(tmp));
    		//System.out.println(r.countName(tmp));
    		//System.out.println(r.countMethod(tmp));
    		count1[count] = r.countName(tmp) - r.countMethod(tmp);
    		i = s.indexOf(" Class ", i+1);
    		count++;
    	}
    	return count1;
    }
    
    
    public Vector<String> getLocationClass(String s){
    	Vector<String> v = new Vector<String>(10,2);
    	readFile2 r = new readFile2();
    	int count = 0;
    	int i = s.indexOf(" Class ");
    	while(i!=-1) {
    		int j = s.indexOf(" Class ", i+1);
    		if(j==-1) j =s.length();
    		String tmp = s.substring(i,j);
    		v.add(count, r.getClassName(tmp));
    		i = s.indexOf(" Class ", i+1);
    		count++;
    	}
    	return v;
    }
    
    public int[][] getRelationship(String s){
    	readFile2 r= new readFile2();
    	int count = r.countClass(s);
    	int[][] relationship = new int[count][count];
    	for(int i=0; i<count; i++) {
    		for(int j=0;j <count; j++) {
    			relationship[i][j] = 0;
    		}
    	}
    	int l =s.indexOf(" Class ");
    	while (l!=-1) {
    		int j2 = s.indexOf(" Class ", l+1);
    		if(j2 ==-1) j2 = s.length();
    		String tmp = s.substring(l, j2);
    		int k = tmp.indexOf("* ");
    		int x = tmp.indexOf("^ ");
    		int z = tmp.indexOf("$ ");
    		while(k!=-1) {
    			//System.out.println(tmp);
    			//System.out.println(k);
    			int k2 = tmp.indexOf("*", k+1);
    			String s2 = tmp.substring(k+2, tmp.indexOf(" *",k));
    			//System.out.println(s2);
    			String temp[] = s2.split(" ");
    			//System.out.println(temp[3]);
    			//System.out.println(r.getLocationClass(s).indexOf(temp[3]));
    			relationship[r.getLocationClass(s).indexOf(temp[0])][r.getLocationClass(s).indexOf(temp[3])] =1;
    			k = tmp.indexOf("* ", k2+1);
    		}
    		
    		while(x!=-1) {
    			//System.out.println(tmp);
    			//System.out.println(k);
    			int x2 = tmp.indexOf("^", x+1);
    			String s2 = tmp.substring(x+2, tmp.indexOf(" ^",x));
    			//System.out.println(s2);
    			String temp[] = s2.split(" ");
    			//System.out.println(temp[3]);
    			//System.out.println(r.getLocationClass(s).indexOf(temp[3]));
    			relationship[r.getLocationClass(s).indexOf(temp[0])][r.getLocationClass(s).indexOf(temp[3])] =4;
    			x = tmp.indexOf("^ ", x2+1);
    		}
    		
    		while(z!=-1) {
    			//System.out.println(tmp);
    			//System.out.println(k);
    			int z2 = tmp.indexOf("$", z+1);
    			String s2 = tmp.substring(z+2, tmp.indexOf(" $",z));
    			//System.out.println(s2);
    			String temp[] = s2.split(" ");
    			String temp2[] = temp[3].split(",");
    			for(String w:temp2) {
    			//System.out.println(temp[3]);
    			//System.out.println(r.getLocationClass(s).indexOf(temp[3]));
    			relationship[r.getLocationClass(s).indexOf(temp[0])][r.getLocationClass(s).indexOf(w)] =2;
    			}
    			z = tmp.indexOf("$ ", z2+1);
    		}
    		
    		l = s.indexOf(" Class ", l+1);
    		
    		
    		
    	}
    	//System.out.println(relationship[2][1]);
    	
    	
    	return relationship;
    }
    
    public void test(String s){
    	readFile2 r= new readFile2();
    	int count = r.countClass(s);
    	int[][] relationship = new int[count][count];
    	for(int i=0; i<count; i++) {
    		for(int j=0;j <count; j++) {
    			relationship[i][j] = 0;
    		}
    	}
    	int l =s.indexOf(" Class ");
    	while (l!=-1) {
    		int j2 = s.indexOf(" Class ", l+1);
    		if(j2 ==-1) j2 = s.length();
    		String tmp = s.substring(l, j2);
    		//System.out.println(tmp);
    		int k = tmp.indexOf("$ ");
    		//System.out.println(k);
    		while(k!=-1) {
    			//System.out.println(tmp);
    			//System.out.println(k);
    			int k2 = tmp.indexOf(" $", k+1);
    			String s2 = tmp.substring(k+2, k2);
    			//System.out.println(s2);
    			String temp[] = s2.split(" ");
    			System.out.println(temp[3]);
    			String temp2[] = temp[3].split(",");
    			for(String w:temp2) {
    				System.out.println(w);
    			}
    			//System.out.println(r.getLocationClass(s).indexOf(temp[3]));
    			//relationship[r.getLocationClass(s).indexOf(temp[0])][r.getLocationClass(s).indexOf(temp[3])] =2;
    			k = tmp.indexOf("* ", k2+1);
    		}
    		l = s.indexOf(" Class ", l+1);
    	}
    	System.out.println(relationship[2][1]);
    	
    }
    
}
