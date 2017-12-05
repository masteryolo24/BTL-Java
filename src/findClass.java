package BaiTapLon;

import java.util.*;

class findClass{
    public void nameClass (String s) {
    	int count =0, tmp3;
    	String str;
    	findClass f = new findClass();
    	//System.out.println("Class: ");
        int i1 = s.indexOf(" class ");
        //int i2;
        for (int i=i1; i< s.length(); i++) {
        	int temp = s.lastIndexOf(" ", i-1);
        	if (i ==-1) break;
        	int i2 = s.indexOf(" ", i+7);
        	String tmp = s.substring(i +7,  i2);
        	String tmp2 = s.substring(temp, i+1);
        	if (tmp2.equals(" abstract ")) System.out.println("=== Abstract Class ===");
        	else System.out.println("=== Class ===");
        	System.out.println("+Name: " + tmp);
        	int k1 = s.indexOf("{", i);
        	for (int j=k1; j <s.length(); j++){
    			if(j ==-1) break;
    			if(count==0) {
    			}
    			if(s.charAt(j) == '{') {
                    count++;
                }
    			if(s.charAt(j) == '}') {
    		        count--;
    		        if(count ==0) {
    		            tmp3=j;	      
    		            j = s.indexOf("{", tmp3)-1;
                        str = s.substring(i, tmp3-1);
                        if (str.indexOf(" class ", str.indexOf("class") +7)!=-1) {
                        	int l = str.indexOf(" class ", str.indexOf("class") +7);
                        	String str2 = str.substring(l-2, str.length()-2);
                        	f.innerClass(str2, tmp);
                        	i = s.indexOf(" class " , i+1);
                        }
                        if(str.indexOf(" extends ") !=-1) {
                        	System.out.println("* " + tmp + " is a " + f.getExtend(str) + " *");
                        }
                        f.nameAttribute(str, s);
                        f.nameMethod(str);

                        if (f.hasImplement(str)) {
                        	System.out.println("* " + tmp + " is a: ");
	                        for (int x= 0; x<f.getImplement(str).length; x++) {
	                        	System.out.print(f.getImplement(str)[x].trim() + " *");
	                        }
	                        System.out.println(" *");
                        }
                        break;
                    }
                }
            }
        	i = s.indexOf(" class ", i+1) -1;
        	
        }
    }
    
    public void innerClass (String s, String s2) {
    	int count =0, tmp3;
    	String str;
    	findClass f = new findClass();
    	//System.out.println("Class: ");
        int i1 = s.indexOf(" class ");
        //int i2;
        for (int i=i1; i< s.length(); i++) {
        	int temp = s.lastIndexOf(" ", i-1);
        	if (i ==-1) break;
        	int i2 = s.indexOf(" ", i+7);
        	String tmp = s.substring(i +7,  i2);
        	String tmp2 = s.substring(temp, i+1);
        	if (tmp2.equals(" abstract ")) System.out.println("=== Abstract Class ===");
        	else System.out.println("=== Inner Class " + s2 +"===");
        	System.out.println("+Name: " + tmp);
        	int k1 = s.indexOf("{", i);
        	for (int j=k1; j <s.length(); j++){
    			if(j ==-1) break;
    			if(count==0) {
    			}
    			if(s.charAt(j) == '{') {
                    count++;
                }
    			if(s.charAt(j) == '}') {
    		        count--;
    		        if(count ==0) {
    		            tmp3=j;	      
    		            j = s.indexOf("{", tmp3)-1;
                        str = s.substring(i, tmp3-1);      
                        
                        if(str.indexOf(" extends ") !=-1) {
                        	System.out.println("*" + tmp + " is a " + f.getExtend(str) + " *");
                        }
                        f.nameMethod(str);
                        f.nameAttribute(str, s);
                        if (f.hasImplement(str)) {
                        	System.out.println("* " + tmp + " is a: ");
	                        for (int x= 0; x<f.getImplement(str).length; x++) {
	                        	System.out.print(f.getImplement(str)[x].trim()+ " ");
	                        }
	                        System.out.println(" *");
                        }
                        break;
                    }
                }
            }
        	i = s.indexOf(" class ", i+1) -1;
        	
        }
    }
    
    public void nameInterface (String s) {
    	int count =0, tmp3;
    	String str;
    	findClass f = new findClass();
    	//System.out.println("Class: ");
        int i1 = s.indexOf(" interface ");
        //int i2;
        for (int i=i1; i< s.length(); i++) {
        	if (i ==-1) break;
        	int i2 = s.indexOf(" ", i+11);
        	String tmp = s.substring(i +11,  i2);
        	System.out.println("=== Interface Class ===");
        	System.out.println("+Name: " + tmp);
        	int k1 = s.indexOf("{", i);
        	for (int j=k1; j <s.length(); j++){
    			if(j ==-1) break;
    			if(count==0) {
    			}
    			if(s.charAt(j) == '{') {
                    count++; 
                }
    			if(s.charAt(j) == '}') {
    		        count--;
    		        if(count ==0) {
    		            tmp3=j;	      
    		            j = s.indexOf("{", tmp3)-1;
    		            str = s.substring(i, tmp3-1);      
                        f.nameMethod(str);
                        f.nameAttribute(str, s);
                        if (f.hasImplement(str)) {
                        	System.out.println("* " + tmp + " is a: ");
	                        for (int x= 0; x<f.getImplement(str).length; x++) {
	                        	System.out.print(f.getImplement(str)[x].trim() + " ");
	                        }
	                        System.out.println(" *");
                        }
                        break;
                    }
                }
            }
        	i = s.indexOf(" interface ", i+1) -1;
        }
    }
    
    public String deleteString3 (String s) {
    	String tmp, tmp2 = s;
    	int i = s.indexOf("\""), j;
    	while (i!=-1) {
    		for (j = i+1; j<s.length(); j++) {
    			if (s.charAt(j) == '\"' && s.charAt(j-1)!= '\\') { 
    				tmp = s.substring(i, j+1);
    				tmp2 = tmp2.replace(tmp, "");
    				break;
    			}
    			
    		}
    		i = s.indexOf("\"", j+1);
    	}
		return tmp2;
    }
    
    public String deleteString4 (String s) {
    	String tmp, tmp2 = s;
    	int i = s.indexOf("\'"), j;
    	while (i!=-1) {
    		for (j = i+1; j<s.length(); j++) {
    			if (s.charAt(j) == '\'' && s.charAt(j-1)!= '\\') { 
    				tmp = s.substring(i, j+1);
    				tmp2 = tmp2.replace(tmp, "");
    				break;
    			}
    			
    		}
    		i = s.indexOf("\'", j+1);
    	}
		return tmp2;
    }
    
    
    public String getSimpleNameClass(String s) {
    	int i1 = s.indexOf(" class ");
        int i2 = s.indexOf(" ", i1+7);
        String tmp = s.substring(i1 +7,  i2).replace("{", "");
        return tmp;
    }
    
    public Vector<String> getNameClass(String s) {
    	Vector<String> v = new Vector<String>(10,2);
    	int i1 = s.indexOf(" class ");
        for (int i=i1; i< s.length(); i++) {
        	int j =0;
        	if (i ==-1) break;
        	int i2 = s.indexOf(" ", i+7);
        	String tmp = s.substring(i +7,  i2).replace("{", "");
        	i = s.indexOf(" class ", i+1) -1;
        	v.add(j, tmp);
        	j++;
        }
    	return v;
    }

    public String namePackage(String s) {
        int i3= s.indexOf(" package ");
        String s2 = new String();
        if(i3 != -1) {
            int i4= s.indexOf(";");
            s2 = "+ Package's Name: "+s.substring(i3+9, i4);
        }
        return s2;
    }
    
	public String deleteString(String s) {
		findClass f = new findClass();
		String s1= s;
		int i1 = s.indexOf("{");
		int tmp = 0, tmp2;
		int count =0;
		String str;
		for (int i=i1; i <s.length(); i++){
			if(i ==-1) break;
			if(count==0) {
				tmp = i;
			}
			if(s.charAt(i) == '{') {
                count++;
            }
			if(s.charAt(i) == '}') {
		        count--;
		        if(count ==0) {
		            tmp2=i;	      
		            i = s.indexOf("{", tmp2)-1;
                    str = s.substring(tmp+1, tmp2-1);      
                    s1= s1.replace(str, f.deleteString2(str));
                }
            }
        }
		return s1;
	}
	
	
	   public String deleteString2(String s) {
			String s1= s;
			int i1 = s.indexOf("{");
			int tmp = 0, tmp2;
			int count =0;
			String str;
			for (int i=i1; i <s.length(); i++){
				if(i ==-1) break;
				if(count==0) {
					tmp = i;
				}
				if(s.charAt(i) == '{') {
	                count++;
	            }
				if(s.charAt(i) == '}') {
			        count--;
			        if(count ==0) {
			            tmp2=i;	      
			            i = s.indexOf("{", tmp2)-1;
	                    str = s.substring(tmp+1, tmp2-1);
	                    s1= s1.replace(str, "");
	                }
	            }
	        }
			return s1;
	   }	   
	   
    public void nameAttribute(String s, String s1) {
		String name = null;
		findClass f= new findClass();
		int i2 = s.indexOf(";");
		if (i2==-1)System.out.println("Don't have Attribute!");
		//else System.out.println("Attribute:");
		while (i2!=-1) {
			int j =  s.lastIndexOf("new ", i2);
			//int k = s.lastIndexOf("=", i2);
			int l = s.lastIndexOf(";", i2-1);
			//System.out.println(j);
			//System.out.println(k);
			//System.out.println(l);

			if(s.charAt(i2-2) == ')' && s.charAt(s.lastIndexOf(" " , s.lastIndexOf(" ", s.lastIndexOf("(", i2))-1)-4) == '=') {
				//System.out.print(s.charAt(s.lastIndexOf("=new" , s.lastIndexOf(" ", s.lastIndexOf(" ", i2)-1)-1)));
				int k = s.lastIndexOf("=", i2);
				int k2 = s.lastIndexOf(" ", s.lastIndexOf(" ", k)-1);
				name = s.substring(k2+1, k);

			}
			else{
				int i3 = s.lastIndexOf(" " , s.lastIndexOf(" ", s.lastIndexOf(" ", i2)-1)-1);
				name = s.substring(i3+1, i2);
			}
			
			int temp = s.lastIndexOf(" ", s.indexOf(name)-2);
			if ((s.substring(temp+1 , s.indexOf(name)-1)).equals("private")) {
				System.out.print("+ -");
			}
			if ((s.substring(temp+1 , s.indexOf(name)-1)).equals("protected")) {
				System.out.print("+ #");
			}
			else System.out.print("+ +");
			//System.out.println(s.substring(temp+1 , s.indexOf(name)-1));
			String[] tmp = name.split(" ");
			System.out.println(tmp[1] +": " + tmp[0]);
			if(f.getNameClass(s1).contains(tmp[0])) {
				System.out.println("* " + f.getSimpleNameClass(s) + " has a " + tmp[0] + " *");
			}
			i2 = s.indexOf(";", i2+1);
		}
	}
	
	
    
    public String getExtend (String s) {
    	String tmp;
    	int i = s.indexOf(" extends ");
    	int i2 = s.indexOf(" ", i+9);
        tmp = s.substring(i+9, i2);
    	return tmp;
    }
    
    public boolean hasImplement(String s) {
    	int i = s.indexOf(" implements ");
    	if (i==-1) return false;
    	return true;
    }
    
    public String[] getImplement(String s) {
    	String tmp;
    	int i = s.indexOf(" implements ");
    	//if (i!=-1) {
	    	int i2 = s.indexOf("{", i);
	    	tmp = s.substring(i+12, i2);	    	
	    	String[] temp = tmp.split(",");
	    	return temp;
    	//}
    	//return null;
    }
    
	public void nameMethod(String s) {
		int i = s.indexOf("(");
		if(i==-1) System.out.println("Don't have Method!");
		//else System.out.println("Method: ");
		while (i!=-1) {
			int tmp2 = s.lastIndexOf(" ", i);
			int tmp3 = s.lastIndexOf(" ", tmp2-1);
			int tmp4 = s.indexOf("{", i);
			int tmp7 = s.indexOf(";", i);
			int tmp5 = s.lastIndexOf(" ", tmp3-1);
			int tmp6 = s.lastIndexOf(" " , tmp5-1);
			if(s.charAt((s.indexOf(")", i) +2)) == ';') {
				if ((s.substring(tmp6+1, tmp5)).equals("abstract")){
					//System.out.println("Hello World");
					if((s.substring(s.lastIndexOf(" ", tmp6-1)+1, tmp6)).equals("private")) {
						System.out.print("+ -");
						System.out.println(s.substring(tmp3+1, tmp7-1) + ": " +s.substring(tmp5+1, tmp3) + "  (Abstract Method)");
					}
					else if((s.substring(s.lastIndexOf(" ", tmp6-1)+1, tmp6)).equals("protected")) {
						System.out.print("+ #");
						System.out.println(s.substring(tmp3+1, tmp7-1) + ": " +s.substring(tmp5+1, tmp3) + "  (Abstract Method)");
					}
					else { 
						System.out.print("+ +");
						System.out.println(s.substring(tmp3+1, tmp7-1) + ": " +s.substring(tmp5+1, tmp3) + "  (Abstract Method)");
					}
					i= s.indexOf("(", i+1);
				}
				else i= s.indexOf("(", i+1);
			}
			else {
				
				if ((s.substring(tmp6+1, tmp5)).equals("abstract")){
					System.out.println("Hello World");
					tmp4 = s.indexOf(";",i);
				}
				if((s.substring(tmp6+1, tmp5)).equals("static")) {
					if((s.substring(s.lastIndexOf(" ", tmp6-1)+1, tmp6)).equals("private")) {
						System.out.print("+ -");
					}
					else if((s.substring(s.lastIndexOf(" ", tmp6-1)+1, tmp6)).equals("protected")) {
						System.out.print("+ #");
					}
					else System.out.print("+ +");
				}
				else {
					if ((s.substring(tmp6+1, tmp5)).equals("private")) {
						System.out.print("+ -");
					}
					else if ((s.substring(tmp6+1, tmp5)).equals("protected")) {
						System.out.print("+ #");
					}
					else System.out.print("+ +");
				}
				System.out.println(s.substring(tmp3+1, tmp4-1) + ": " +s.substring(tmp5+1, tmp3));
				i = s.indexOf("(", tmp4);
			}
		}
	}
	
}
