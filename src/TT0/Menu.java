package src.TT0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//run TT0.Main.java to run TT0.Menu

public final class Menu {
    //Class needed for invoking method
    private Class menuClass;
    
    //Dictionary connecting menu item name to method reference
    private HashMap<String, Method> menuItemHashtable = new HashMap<>();

    //Dictionary connecting menu item name to item description
    private HashMap<String, String> itemDescriptionHashtable = new HashMap<>();
    
    //Array representation of banner with each elment being each line of the banner
    private String[] banner = {""};
    
    //TT0.Menu constructor
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
        //Empty stack: TT0.Menu is empty
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
