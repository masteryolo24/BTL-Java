public class test {
    final int numberClass;
    final int maxNumberInfo;
    final int maxNumberClassInfo;
    final int[] numberClassAttributes;
    final int[] numberClassMethods;
    final int[] numberClassInfo;
    final int[] longestStringLen;
    final String[][] getInfo;

    public test() {
        this.numberClass = numberClass();
        this.maxNumberInfo = maxNumberInfo();
        this.maxNumberClassInfo = maxNumberClassInfo();
        this.numberClassAttributes  = numberClassAttributes();
        this.numberClassMethods = numberClassMethods();
        this.numberClassInfo= numberClassInfo();
        this.longestStringLen = longestStringLen();
        this.getInfo = getInfo();
    }
    int numberClass() {
        return 6;
    }
    int maxNumberInfo() {
        int maxNumberInfo = 0;
        for(int i = 0; i < numberClass(); i++) {
            if(numberClassInfo()[i] > maxNumberInfo)
                maxNumberInfo = numberClassInfo()[i];
        }
        return maxNumberInfo;
    }
    int maxNumberClassInfo() {
        int maxNumberClassInfo = 0;
        for(int i = 0; i < numberClass(); i++) {
                maxNumberClassInfo = numberClassInfo()[i];
        }
        return maxNumberClassInfo;
    }
    int [] numberClassAttributes() {
        int[] numberClassAttributes = new int[]{2, 5, 2, 1, 2, 3};
        return numberClassAttributes;
    }
    int [] numberClassMethods() {
        int [] numberClassMethods = new int[] {7, 7, 8, 8, 10, 9};
        return numberClassMethods;
    }
    int [] numberClassInfo() {
        int [] numberClassInfo = new int[numberClass()];
        for(int i = 0; i < numberClass(); i++) {
            numberClassInfo[i] = numberClassAttributes()[i] + numberClassMethods()[i] + 1;
        }
        return numberClassInfo;
    }
    int [] longestStringLen() {
        int [] longestStringLen = new int[numberClass()];
        for(int i = 0; i < numberClass(); i++) {
            longestStringLen[i] = 0;
            for(int j = 0; j < numberClassInfo()[i]; j++) {
                if(getInfo()[i][j].length() > longestStringLen[i])
                    longestStringLen[i] = getInfo()[i][j].length();
            }
        }
        return longestStringLen;
    }
    String[][] getInfo() {
        String[][] getInfo = new String[maxNumberInfo()][maxNumberInfo()];

        getInfo[0][0] = "Shape";
        getInfo[0][1] = "+ color: String";
        getInfo[0][2] = "+ check: boolean";
        getInfo[0][3] = "+ Shape()";
        getInfo[0][4] = "+ Shape(String,boolean)";
        getInfo[0][5] = "+ getColor(): String";
        getInfo[0][6] = "+ setColor(String): void";
        getInfo[0][7] = "+ isCheck(): boolean";
        getInfo[0][8] = "+ setCheck(boolean): void";
        getInfo[0][9] = "+ toString(): String";

        getInfo[1][0] = "Layer";
        getInfo[1][1] = "+ createShape: Shape[]";
        getInfo[1][2] = "+ createCircle: Circle[]";
        getInfo[1][3] = "+ createTriangle: Triangle[]";
        getInfo[1][4] = "+ createSquare: Square[]";
        getInfo[1][5] = "+ createRectangle: Rectangle[]";
        getInfo[1][6] = "+ Layer()";
        getInfo[1][7] = "+ getCreateCircle(): Circle[]";
        getInfo[1][8] = "+ getCreateRectangle(): Rectangle[]";
        getInfo[1][9] = "+ getCreateShape(): Shape[]";
        getInfo[1][10] = "+ getCreateSquare(): Square[]";
        getInfo[1][11] = "+ getCreateTriangle(): Triangle[]";
        getInfo[1][12] = "+ deleteTriangle(): void";

        getInfo[2][0] = "Circle";
        getInfo[2][1] = "+ radius: double";
        getInfo[2][2] = "- PI: double";
        getInfo[2][3] = "+ Circle()";
        getInfo[2][4] = "+ Circle(double)";
        getInfo[2][5] = "+ Circle(double, String, boolean)";
        getInfo[2][6] = "+ getRadius(): double";
        getInfo[2][7] = "+ setRadius(double): void";
        getInfo[2][8] = "+ getArea(): double";
        getInfo[2][9] = "+ getPerimeter(): double";
        getInfo[2][10] = "+ toString(): String";

        getInfo[3][0] = "Square";
        getInfo[3][1] = "+ size: double";
        getInfo[3][2] = "+ Square()";
        getInfo[3][3] = "+ Square(double)";
        getInfo[3][4] = "+ Square(double, String, boolean)";
        getInfo[3][5] = "+ getSide(): double";
        getInfo[3][6] = "+ setSize(double): void";
        getInfo[3][7] = "+ setWidth(double): void";
        getInfo[3][8] = "+ setLength(double): void";
        getInfo[3][9] = "+ toString(): String";

        getInfo[4][0] = "Rectangle";
        getInfo[4][1] = "+ width: double";
        getInfo[4][2] = "+ length: double";
        getInfo[4][3] = "+ Rectangle()";
        getInfo[4][4] = "+ Rectangle(double, double)";
        getInfo[4][5] = "+ Rectangle(double, double, String, boolean)";
        getInfo[4][6] = "+ getWidth(): double";
        getInfo[4][7] = "+ setWidth(double): void";
        getInfo[4][8] = "+ getLength(): double";
        getInfo[4][9] = "+ setLength(double): void";
        getInfo[4][10] = "+ getArea(): double";
        getInfo[4][11] = "+ getPerimeter(): double";
        getInfo[4][12] = "+ toString(): String";

        getInfo[5][0] = "Triangle";
        getInfo[5][1] = "+ edge1: double";
        getInfo[5][2] = "+ edge2: double";
        getInfo[5][3] = "+ edge3: double";
        getInfo[5][4] = "+ Triangle()";
        getInfo[5][5] = "+ Triangle(double, double, double, String, boolean)";
        getInfo[5][6] = "+ getEdge1(): double";
        getInfo[5][7] = "+ getEdge2(): double";
        getInfo[5][8] = "+ getEdge3(): double";
        getInfo[5][9] = "+ setEdge1(double): void";
        getInfo[5][10] = "+ setEdge2(double): void";
        getInfo[5][11] = "+ setEdge3(double): void";
        getInfo[5][12] = "+ toString(): String";

        return getInfo;
    }
}
