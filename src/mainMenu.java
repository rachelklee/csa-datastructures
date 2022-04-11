package src;

import src.TT0.IntByReference;
import src.TT0.Matrix;
import src.TT0.Main;
import src.TT0.Menu;

import src.TT1.LinkedList;
import src.TT1.Queue1;
import src.TT1.Queue2;
import src.TT1.Queue3;

import src.TT2.LinkedLists.LinkedList2;
import src.TT2.LinkedLists.Stack;
//import src.TT2.LinkedLists;
import src.TT2.Calculator;

import src.TT3.Sort.bubble;
import src.TT3.Sort.insertion;
import src.TT3.Sort.merge;
import src.TT3.Sort.selection;
//import src.TT3.Sort;
import src.TT3.Sorts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mainMenu {
  Map<Integer, MenuRow> menu = new HashMap<>();

  public mainMenu(MenuRow[] rows) {
    int i = 0;
    for (MenuRow row : rows) {
      // Build HashMap for lookup convenience
      menu.put(i++, new MenuRow(row.getTitle(), row.getAction()));
    }
  }

  public MenuRow get(int i) {
    return menu.get(i);
  }

  public void print() {
    for (Map.Entry<Integer, MenuRow> pair : menu.entrySet()) {
      System.out.println(pair.getKey() + " :  " + pair.getValue().getTitle());
    }
  }

  public static void main(String[] args) {
    Driver.main(args);
  }

}

// The MenuRow Class has title and action for individual line item in menu
class MenuRow {
  String title;
  Runnable action;

  public MenuRow(String title, Runnable action) {
    this.title = title;
    this.action = action;
  }

  public String getTitle() {
    return this.title;
  }

  public Runnable getAction() {
    return this.action;
  }

  public void run() {
    action.run();
  }

}

class Driver {
  public static void runMenu(mainMenu current) {
    while (true) {

      System.out.println("Choose:");
      // print rows
      current.print();

      // Scan for input
      try {
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        // menu action
        try {
          MenuRow row = current.get(selection);
          // stop menu condition
          if (row.getTitle().equals("Exit"))
            return;
          // run option
          System.out.print("\033[H\033[2J");
          System.out.flush();
          System.out.println(row.getTitle());
          row.run();
        } catch (Exception e) {
          System.out.printf("Invalid selection %d\n", selection);
        }
      } catch (Exception e) {
        System.out.println("Not a number");
      }
    }
  }

  public static void main(String[] args) {
    // Row initialize
    MenuRow[] rows = new MenuRow[] { new MenuRow("Exit", () -> main(null)),
        new MenuRow("Swap", () -> IntByReference.main(null)), new MenuRow("Matrix", () -> Matrix.main(null)) };

    MenuRow[] rows1 = new MenuRow[] { new MenuRow("Exit", () -> main(null)),
        new MenuRow("Queue Iterator", () -> Queue1.main()), new MenuRow("Merge Queues", () -> Queue2.main()),
        new MenuRow("Reverse Queues", () -> Queue3.main()) };

    MenuRow[] rows2 = new MenuRow[] { new MenuRow("Exit", () -> main(null)),
        new MenuRow("Calculator", () -> Calculator.main(null)) };

    MenuRow[] rows3 = new MenuRow[] { new MenuRow("Exit", () -> main(null)),
        new MenuRow("Sorts", () -> Sorts.main(null))};

    // Menu construction
    mainMenu menu0 = new mainMenu(rows);
    mainMenu menu1 = new mainMenu(rows1);
    mainMenu menu2 = new mainMenu(rows2);
    mainMenu menu3 = new mainMenu(rows3);

    MenuRow[] weeks = new MenuRow[] { new MenuRow("Week 0", () -> runMenu(menu0)),
        new MenuRow("Week 1", () -> runMenu(menu1)), new MenuRow("Week 2", () -> runMenu(menu2)),
        new MenuRow("Week 3", () -> runMenu(menu3)) };

    mainMenu weekmenu = new mainMenu(weeks);

    runMenu(weekmenu);
  }
}
