package BaiTapLon;

public class test {
	final String tmp;
	final String tmp2;
	final readFile2 r3 = new readFile2();
	final int numberClass;
    final int maxNumberInfo; 
    final int maxNumberClassInfo;
    final int[] numberClassAttributes;
    final int[] numberClassMethods;
    final int[] numberClassInfo;
    final int[] longestStringLen;
    final int[][] relationship;
    final String[][] getInfo;

    public test() {
    	
    	//readFile2 r3 = new readFile2();
    	this.tmp = r3.docFile("./diagram.txt");
    	this.tmp2 =r3.docFile2("./diagram.txt");
    	
    	this.numberClass = r3.countClass(tmp);
    	this.numberClassAttributes  = r3.numberAttribute(tmp);
    	this.numberClassMethods = r3.numberMethod(tmp);
        
        int [] numberClassInfo = new int[numberClass];
        for(int i = 0; i < numberClass; i++) {
            numberClassInfo[i] = numberClassAttributes[i] + numberClassMethods[i] + 1;
        }
        this.numberClassInfo = numberClassInfo;
        
        int maxNumberInfo = 0;
        for(int i = 0; i < numberClass; i++) {
            if(numberClassInfo[i] > maxNumberInfo)
                maxNumberInfo = numberClassInfo[i];
        }
        this.maxNumberInfo = maxNumberInfo;
        
        int maxNumberClassInfo = 0;
        for(int i = 0; i < numberClass; i++) {
                maxNumberClassInfo = numberClassInfo[i];
        }
        this.maxNumberClassInfo = maxNumberClassInfo;
   
        String[][] getInfo = new String[maxNumberInfo][maxNumberInfo];
        getInfo = r3.getAll(tmp);
        this.getInfo = getInfo;
        
        int [] longestStringLen = new int[numberClass];
        for(int i = 0; i < numberClass; i++) {
            longestStringLen[i] = 0;
            for(int j = 0; j < numberClassInfo[i]; j++) {
                if(getInfo[i][j].length() > longestStringLen[i])
                    longestStringLen[i] = getInfo[i][j].length();
            }
        }
        this.longestStringLen = longestStringLen;
        
        int relationship[][] = new int[100][100];
        relationship = r3.getRelationship(tmp2);
        this.relationship = relationship;

    }
}
