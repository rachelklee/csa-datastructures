<h2 align="center"> <a href="https://rachelklee.github.io/csa-datastructures/">Home</a> | <a href="https://rachelklee.github.io/csa-datastructures/techtalknotes">Tech Talk Notes</a> | <a href="https://rachelklee.github.io/csa-datastructures/testprep">Test Prep Notes</a></h2>

# Week 0 Data Structures

## Code Snippets

### Challenge 1
Main.java
```java
public class Main {
    //Create a new menu with the input class being this class
    public static Menu newMenu = new Menu(Main.class);
    //Run the menu function to start the menu
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        //Create a sample banner
        String[] newBanner = 
            {"-----------------------",
            "This is a sample banner",
            "-----------------------"};
        //Save the banner
        newMenu.changeBanner(newBanner);
        try {
            Main.class.getDeclaredMethod("sample");
            //Add new item to the menu with a name of same, method of sample, and description of run sample
            newMenu.addItem("Sample", Main.class.getDeclaredMethod("sample"), "run sample");
        //No such method: A method of type name doesn't exist
        //Permission to run a certain function aren't given to the user running the program
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        //Print starting banner
        newMenu.printBanner();
        //Run with terminal code before line being >
        newMenu.run(" > ");

        
    }
    //Sample function for the sample item
    public static void sample(){
        System.out.println("This is a sample");
    }
}
```

Menu.java
```java
public final class Menu {
    //Class needed for invoking method
    private Class menuClass;
    
    //Dictionary connecting menu item name to method reference
    private HashMap<String, Method> menuItemHashtable = new HashMap<>();

    //Dictionary connecting menu item name to item description
    private HashMap<String, String> itemDescriptionHashtable = new HashMap<>();
    
    //Array representation of banner with each elment being each line of the banner
    private String[] banner = {""};
    
    //Menu constructor
    public Menu(Class inputClass){
        menuClass = inputClass;
        //Create a default menu item to quit
        this.addItem("Quit", null, "Quit Program");
    }

    //Change the banner
    public final boolean changeBanner(String[] newBanner){
        banner = newBanner;
        return true;
    }
    //Return the banner
    public final String getBanner(){
        //Concatinate the banner to one string 
        return String.join("\n",banner);
    }
    //Add item to the menu
    //Returns true if runs successfuly, false if fails
    public final boolean addItem(String name, Method item, String itemDescription){
        //Set name of item to lowercase so accessing item from menu becomes easier
        String newName = name.toLowerCase();
        //Make sure there are no overlaps
        if (menuItemHashtable.containsKey(newName)) return false;
        //Add item method refernce to menu
        menuItemHashtable.put(newName, item);
        //Add item description to menu
        itemDescriptionHashtable.put(newName, itemDescription);
        return true;
    }
    //Get the method reference
    public final Method getItem(String name){
        //Set name to lowercase to fit the menu pattern
        String newName = name.toLowerCase();
        //Get the reference from the method reference dictionary
        return menuItemHashtable.get(newName);
    }
    //Get the item description
    public final String GetItemDescription(String name){
        //Set name to lowercase to fit the menu pattern
        String newName = name.toLowerCase();
        //Get the description from the method reference dictionary
        return itemDescriptionHashtable.get(newName);
    }
    //Remove items from the menu
    public final boolean removeItem(String name){
        //Set name to lowercase to fit the menu pattern
        String newName = name.toLowerCase();
        //Make sure that the menu contains string names
        if (!menuItemHashtable.containsKey(newName)) return false;
        //Remove menu items from the two dictionaries
        menuItemHashtable.remove(newName);
        itemDescriptionHashtable.remove(newName);
        return true;
    }
    //Get the method reference dictionary
    public final HashMap<String, Method> getMethodReferenceMenu(){
        return menuItemHashtable;
    }
    //Get the item description dictionary
    public final HashMap<String, String> getItemDescriptionMenu(){
        return itemDescriptionHashtable;
    }
    //Get the menu banner
    public final String getMenuBanner(String delimiter){
        //Temp menu banner
        //Use lists instead of array because you can add items to lists
        List<String> menuBanner = new LinkedList<>();
        //Make sure menu isn't empty
        if (menuItemHashtable.size()>0){
            //Loop through the item description menu
            itemDescriptionHashtable.forEach(
                //Create a runnable with the method being 
                //adding adding item to the temp banner 
                //and the variables passed in being the 
                //keys and values of the item description menu
                (key,value)->menuBanner.add(
                    //Join the delimiter, key and value
                    //For some reason, you need to put the delimiter first I don't know why
                    String.join(
                        delimiter, 
                        //Capitalize the first letter of the keys so it looks better
                        key.substring(0, 1).toUpperCase() + key.substring(1), 
                        value)));
            //Join the menu banner to one string
            return String.join("\n", menuBanner);
        }
        else{
            //Throw error for an empty list
            throw new EmptyStackException();
        }
    }
    //Print the menu banner and menu item + item description
    public void printBanner(){
        try{
            System.out.println(this.getBanner());
            System.out.println(this.getMenuBanner(" > "));
        }
        catch (Exception e){
            //Error from get menuBanner
            System.out.println(e.getMessage());
        }
        
    }
    //Run method reference
    //MUST BE LOWERCASE
    void runMethod(String name){
        try {
            //Invoke method invoked from class passed in from the constructor
            menuItemHashtable.get(name).invoke(menuClass);
        //Empty stack: Menu is empty
        //Illegal access: Accessing something it cannot
        //Illegal argument: Argument doesn't belon
        //Invocation Target: Something is wrong with invoking the menu
        } catch (EmptyStackException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    //Run the menu
    public void run(String lineStart){
        System.out.print(lineStart);
        //User input
        String selection;
        //Initialize the scanner to scan the terminal inputs
        Scanner scan = new Scanner(System.in);
        //Get the next input
        selection = scan.next().toString();
        //Lowercase, then check if it should quit
        if (selection.toLowerCase().equals("quit")){
            //Exit with status code of 0
            System.exit(0);
        }
        //Check if input is in the menu
        if (menuItemHashtable.containsKey(selection.toLowerCase())){
            //Execute method connected to menu item
            runMethod(selection.toLowerCase());
        }
        else{
            //Item is not in menu
            System.out.println("Item: " + selection + " does not exist");
        }
        //Run the menu run again until it quits
        run(lineStart);
    }
}
```

### Challenge 2

IntByReference.java
```java
public class IntByReference {
    public int value;

    // Hack: create IntByReference, swapToLowHighOrder and toString methods
    public IntByReference(int n){
        value = n;
    }
    public void swapToLowHighOrder(IntByReference n){
   
        //If the the current value is larger, then swap the values
        //If you use n.value instead of temp, then it makes 
        //both values to what the original value was
        if (value > n.value){
            //Create a temperary value for switching
            int temp = n.value;
            n.value = value;
            value = temp;
        }
    }
    public String intoString(){
        return String.valueOf(value);
    }
    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a.intoString() + " " + b.intoString());
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a.intoString() + " " + b.intoString());
        System.out.println();
    }

    // static main method that provides some simple test cases
    public static void main(String[] ags) {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }
}
```

### Challenge 3
Matrix
```java
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

    }

    public String toString() {
        getString();
        reverseString();
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
```

## Github

| Challenge | Link |
| -- | -- |
| Challenge 1 | [TT0.Main](https://github.com/rachelklee/csa-datastructures/blob/main/src/Main.java), [TT0.Menu](https://github.com/rachelklee/csa-datastructures/blob/main/src/Menu.java)
| Challenge 2 | [Int By Reference](https://github.com/rachelklee/csa-datastructures/blob/main/src/IntByReference.java) |
| Challenge 3 | [TT0.Matrix](https://github.com/rachelklee/csa-datastructures/blob/main/src/Matrix.java) |


