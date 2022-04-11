package src.TT0;

public class Matrix {
    private final int[][] matrix;
    String str;

    // store matrix
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // Hack: create toString method using nested for loops to format output of a matrix


    // declare and initialize a matrix for a keypad
    static int[][] keypad() {
        return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
    }

    // declare and initialize a random length arrays
    static int[][] numbers() {
        return new int[][]{ { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    public void getString() {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        System.out.println("# of rows: " + row);
//        System.out.println("# of columns: " + col);

        int maxRows = 0;
        int maxCols = 0;

        int x = 0;
        for (int n =0; n < matrix.length; n++) { //counting rows
            for (int k = 0; k < matrix[x].length; k++) { //counting columns
                if (matrix[n][k] >= 0) { //value is positive
                    System.out.print(matrix[n][k] + " ");
                }
                else {
                    System.out.print("  "); //placeholder for negative values
                }
            }
            System.out.println("");
            x++;

        }
    }

    public void reverseString() {
        int x = matrix.length-1;
        for (int n =matrix.length-1; n >= 0; n--) { //counting rows
            for (int k = matrix[x].length-1; k >= 0 ; k--) { //counting columns
                if (matrix[n][k] >= 0) { //value of
                    System.out.print(matrix[n][k] + " ");
                }
                else {
                    System.out.print("  "); //placeholder for negative values
                }

            }
            System.out.println("");
            x--;

        }

    }

    public void toHex() {
        String hexOut = "";
        for (int i = (matrix.length - 1); i >= 0; --i) { // comparing for the row number, starting with last row
            for(int j = (matrix[i].length - 1); j >= 0; --j) { // starts at the last element
                if (matrix[i][j] == -1) { // if the value in the matrix = -1
                    hexOut = " "; // replace the value in the matrix with a space
                }
                else {
                    hexOut += Integer.toHexString(matrix[i][j]); // if not -1, use original matrix value, changing values to Hex String
                }
                if (j != 0) { // check when loop reaches beginning of each row
                    hexOut += " "; // if not beginning of row, adds a space between ints
                }
                else {
                    hexOut += "\n"; // reaches beginning of row, jumps to next line
                }
            }
        }
        System.out.println(hexOut);
    }

    public String toString() {
        getString();
        reverseString();
        toHex();
        return str;
    }

    // tester method for matrix formatting
    public static void main(String[] args) {
        Matrix m0 = new Matrix(keypad());
        System.out.println("Keypad:");
        System.out.println(m0);

        Matrix m1 = new Matrix(numbers());
        System.out.println("Numbers Systems:");
        System.out.println(m1);
    }

}
