/**
 * the items in the menu
 *
 *
 */
public class MenuItem {
	
	private String name;
	private String description;
	private double price;
	private int calories;


	/**
	 * constructor
	 * @param name the name of the item
	 * @param description the description of the item (if necessary)
	 * @param price the price of the item
	 * @param calories the calories of the item
	 */
	public MenuItem(String name, String description, double price, int calories) {
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
		this.setCalories(calories);
	}
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	/**
	 * print the info of the item
	 */
	public void print() {		
		System.out.println(name + "		$" + price);
		System.out.println(description);
		System.out.println("Calories: " + calories);
		
	}
	
	

}
