package TT0;

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
