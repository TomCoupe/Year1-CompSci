public class Sweets {
	//declaring variables that will be used by the methods.
	private String sweetName;
	private double price;
	private int stock;
	private int startingStock = 4;
	//this method holds information about each sweet item on the buttons
	public Sweets(String sweetName, double price, int stock) {
		this.sweetName = sweetName;
		this.price = price;
		startingStock = stock;
		this.stock = stock;
	}
	//returns the name of the sweet when called
	public String getName() {
		return sweetName;
	}
	//returns the price of the sweet item
	public double getPrice() {
		return price;
	}
	//returns the stock value of the sweet
	public int getStock() {
		return stock;
	}
	//this method takes 1 away from the current stock value when it is called
	public int newStock() {
		stock = stock -1;
		return stock;
	}
	//this method sets the stock based upon the parameters given when called.
	public int setStock(int n) {
		stock = n;
		return stock;
	}
}