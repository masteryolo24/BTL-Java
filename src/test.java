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
    	this.tmp2 =r3.docFile("./diagram.txt");
    	
        this.numberClass = r3.countClass(tmp);
        this.numberClassAttributes  = r3.numberAttribute(tmp);
        this.maxNumberInfo = maxNumberInfo();
        this.maxNumberClassInfo = maxNumberClassInfo();
        
        this.numberClassMethods = r3.numberMethod(tmp);
        this.numberClassInfo= numberClassInfo();
        this.longestStringLen = longestStringLen();
        this.relationship = relationship();
        this.getInfo = getInfo();
    }

    int maxNumberInfo() {
        int maxNumberInfo = 0;
        for(int i = 0; i < numberClass; i++) {
            if(numberClassInfo()[i] > maxNumberInfo)
                maxNumberInfo = numberClassInfo()[i];
        }
        return maxNumberInfo;
    }
    int maxNumberClassInfo() {
        int maxNumberClassInfo = 0;
        for(int i = 0; i < numberClass; i++) {
                maxNumberClassInfo = numberClassInfo()[i];
        }
        return maxNumberClassInfo;
    }
    int [] numberClassAttributes() {
    	int[] number = new int[r3.countClass(tmp)];
    	number = r3.numberAttribute(tmp);
    	return number;
    }
    int [] numberClassMethods() {
    	int[] number = new int[r3.countClass(tmp)];
    	number = r3.numberMethod(tmp);
    	return number;
    }
    int [] numberClassInfo() {
        int [] numberClassInfo = new int[numberClass];
        for(int i = 0; i < numberClass; i++) {
            numberClassInfo[i] = numberClassAttributes()[i] + numberClassMethods()[i] + 1;
        }
        return numberClassInfo;	
    }
    int [] longestStringLen() {
        int [] longestStringLen = new int[numberClass];
        for(int i = 0; i < numberClass; i++) {
            longestStringLen[i] = 0;
            for(int j = 0; j < numberClassInfo()[i]; j++) {
                if(getInfo()[i][j].length() > longestStringLen[i])
                    longestStringLen[i] = getInfo()[i][j].length();
            }
        }
        return longestStringLen;
    }
    int [][] relationship() {
        // 0 : no relationship
        // 1 : generalization
        // 2 : realization / implementation
        // 3 : association

    	int r[][] = new int[100][100];
    	r = r3.getRelationship(tmp2);
        return r;
    }
    String[][] getInfo() {
		readFile2 r3 = new readFile2();
		String tmp = r3.docFile("./diagram.txt");
        String[][] getInfo = new String[maxNumberInfo()][maxNumberInfo()];
        getInfo = r3.getAll(tmp);
        return getInfo;
    }
}
