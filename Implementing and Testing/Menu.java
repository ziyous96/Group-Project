import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private ArrayList<MenuItem> menuItems;
	private ArrayList<MenuItem> suggested;
	private Scanner scanner;

	public Menu() {
		menuItems = new ArrayList<MenuItem>();
		suggested = new ArrayList<MenuItem>();
	}

	public void view() {
		if (!menuItems.isEmpty()) {
			System.out.println("Menu Dishes: ");
			for (int i = 0; i < menuItems.size(); i++) {
				System.out.println("------------------");
				System.out.print((i + 1) + "- ");
				menuItems.get(i).print();
				System.out.println("------------------");
			}
		} else {
				System.out.println("There are no menu items to view!\n");
		}
	}

	public void addItem() {
		scanner = new Scanner(System.in);
		String name;
		String description;
		double price;
		int calories;
		try {
			System.out.println("Enter the Menu Item's name: ");
			name = scanner.nextLine();
			for (int i = 0; i < menuItems.size(); i++) {
				if (menuItems.get(i).getName().equals(name)) {
					System.out.println("Item with the same name already exists");
					return;
				}
			}
			System.out.println("Enter the Menu Item's description: ");
			description = scanner.nextLine();
			System.out.println("Enter the Menu Item's price: (two decimal, i.e. 22.99) ");
			price = scanner.nextDouble();
			System.out.println("Enter the Menu Item's calories: ");
			calories = scanner.nextInt();
			MenuItem newItem = new MenuItem(name, description, price, calories);
			menuItems.add(newItem);
			System.out.println("Item has been added!");
		} catch (Exception e) {
			System.out.println("Invalid entry, item has NOT been added! Try again.");
		}
	}

	public void editItem() {
		if (menuItems.size() < 1) {
			System.out.println("There are no items on the menu");
			return;
		}
		scanner = new Scanner(System.in);
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.print((i + 1) + " - ");
			System.out.println(menuItems.get(i).getName());
		}
		try {
			System.out.println("Enter the number of item to edit: ");
			int num = scanner.nextInt();
			if (num <= 0 || num > menuItems.size()) {
				System.out.println("Invalid item number!");
				return;
			}
			System.out.println("Edit Options");
			System.out.println("Please select one of the following by entering the number: ");
			System.out.println("1- Edit Name");
			System.out.println("2- Edit Description");
			System.out.println("3- Edit Price");
			System.out.println("4- Edit Calories");
			System.out.println("5- Back");
			boolean on = true;
			while (on) {
				int i;
				i = scanner.nextInt();
				if (i > 0 && i < 6) {
					on = false;
					scanner.nextLine();
					if (i == 1) {
						System.out.println("Enter the new name: ");
						String name = scanner.nextLine();
						menuItems.get(num - 1).setName(name);
					} else if (i == 2) {
						System.out.println("Enter the new description: ");
						String desc = scanner.nextLine();
						menuItems.get(num - 1).setDescription(desc);

					} else if (i == 3) {
						System.out.println("Enter the new price: ");
						double price = scanner.nextDouble();
						menuItems.get(num - 1).setPrice(price);
					} else if (i == 4) {
						System.out.println("Enter the new calories: ");
						int calories = scanner.nextInt();
						menuItems.get(num - 1).setCalories(calories);
					} else {
						// exits edit menu
					}

				} else {
					System.out.println("Invalid, please enter a number 1 - 5");
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid entry, no changes were made! Try again.");
		}

	}

	public void suggestDish() {
		scanner = new Scanner(System.in);
		String name;
		String description;
		double price;
		int calories;
		try {
			System.out.println("Enter the Suggested Item's name: ");
			name = scanner.nextLine();
			for (int i = 0; i < suggested.size(); i++) {
				if (suggested.get(i).getName().equals(name)) {
					System.out.println("Item with the same name already exists");
					return;
				}
			}
			System.out.println("Enter the Suggested Item's description: ");
			description = scanner.nextLine();
			System.out.println("Enter the Suggested Item's price: (two decimal, i.e. 22.99) ");
			price = scanner.nextDouble();
			System.out.println("Enter the Suggested Item's calories: ");
			calories = scanner.nextInt();
			MenuItem newItem = new MenuItem(name, description, price, calories);
			suggested.add(newItem);
			System.out.println("Item has been suggested!");
		} catch (Exception e) {
			System.out.println("Invalid entry, item has NOT been suggested! Try again.");
		}
	}

	public void viewSuggested() {
		if (!suggested.isEmpty()) {
			System.out.println("Suggested Dishes: ");
			for (int i = 0; i < suggested.size(); i++) {
				System.out.println("------------------");
				System.out.print((i + 1) + "- ");
				suggested.get(i).print();
				System.out.println("------------------");
			}
		} else {
			System.out.println("There are no suggested dishes!\n");
		}

	}

	public void deleteItem() {
		if (menuItems.size() < 1) {
			System.out.println("There are no items on the menu");
			return;
		}
		scanner = new Scanner(System.in);
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.print((i + 1) + " - ");
			System.out.println(menuItems.get(i).getName());
		}
		try {
			System.out.println("Enter the number of item to delete: ");
			int num = scanner.nextInt();
			if (num <= 0 || num > menuItems.size()) {
				System.out.println("Invalid item number!");
				return;
			} else {
				menuItems.remove(num - 1);
				System.out.println("Item was deleted!");
			}

		} catch (Exception e) {
			System.out.println("Invalid entry, item has NOT been deleted! Try again.");
		}

	}

}
