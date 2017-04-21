import java.util.Scanner;

/**
 * The main functions of our system
 * @author Abdulaziz, Sayan, Ziyou
 * @version 2017.04.21
 *
 */
public class Main {

    static Scanner scanner;
    private static Menu menu;

    public static void main(String[] args) {
        menu = new Menu();
        scanner = new Scanner(System.in);
        int i = 1;
        while (i == 1) {
            i = mainMenu();
        }
        
    }

    /**
     * the main menu
     * @return int to control the loop
     */
    public static int mainMenu() {

        //scanner = new Scanner(System.in);
        System.out.println("Restaurant Managing System");
        System.out.println("Please select one of the following by entering the number: ");
        System.out.println("1- The Menu");
        System.out.println("2- Employee Records");
        System.out.println("3- Table Manager");
        System.out.println("4- The Inventory");
        System.out.println("5- Exit");
        boolean on = true;
        int i;
        while (on) {
            try {
                i = scanner.nextInt();
            } catch (Exception e) {
                i = -1;
                scanner.next();
            }
            if (i > 0 && i < 6) {
                on = false;
                if (i == 1) {
                    subMenu();
                } else if (i == 2) {
                    System.out.println("Currently under development\n");
                } else if (i == 3) {
                    System.out.println("Currently under development\n");
                } else if (i == 4) {
                    System.out.println("Currently under development\n");
                } else {
                    System.out.println("Thank you for using the Restaurant Manager System");
                    return 0;
                }

            } else {
                System.out.println("Invalid, please enter a number 1 - 5");
            }
        }
        return 1;
    }

    /**
     * the sub menu of our system (menu part)
     */
    public static void subMenu() {
        boolean finished = false;
        while (!finished) {
            //scanner = new Scanner(System.in);
            System.out.println("Menu Options");
            System.out.println("Please select one of the following by entering the number: ");
            System.out.println("1- View Menu");
            System.out.println("2- Add a Menu Item");
            System.out.println("3- Delete a Menu Item");
            System.out.println("4- Edit a Menu Item");
            System.out.println("5- Suggest a Dish");
            System.out.println("6- View Suggested Dishes");
            System.out.println("7- Back to Main Menu");
            boolean on = true;
            int i;
            while (on) {
                try {
                    i = scanner.nextInt();
                } catch (Exception e) {
                    i = -1;
                    scanner.nextLine();
                }
                if (i > 0 && i < 8) {
                    on = false;
                    if (i == 1) {
                        menu.view();
                    } else if (i == 2) {
                        menu.addItem(scanner);

                    }

                    else if (i == 3) {
                        menu.deleteItem(scanner);

                    } else if (i == 4) {
                        menu.editItem(scanner);

                    } else if (i == 5) {
                        menu.suggestDish(scanner);

                    } else if (i == 6) {
                        menu.viewSuggested();
                    } else {
                        // Goes back to mainMenu
                        finished = true;
                    }

                } else {
                    System.out.println("Invalid, please enter a number 1 - 7");
                }
            }
        }
    }

}
