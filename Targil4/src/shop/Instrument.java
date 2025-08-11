package shop;

public abstract class Instrument {
	// Abstract class Instrument, it is a basic instrument, and has fields
	// company,price,serialNum, it also has a static variable to count the serial
	// number of instruments. It has function func which will be implemented by the
	// sub classes
	private String company;
	private int price;
	private static int totalSerialNum = -1;
	private int serialNum;

	public Instrument(String company, int price) {
		// Constructor of the class
		this.company = company;
		this.price = price;
		serialNum = ++totalSerialNum; // The serialNum starts with 0
	}

	public String getCompany() {
		// Getter for the company field
		return company;
	}

	public int getPrice() {
		// Getter for the price field
		return price;
	}

	public int getSerial() {
		// Getter for the serialNum field
		return serialNum;
	}

	@Override
	public String toString() {
		// toString of the class, since there is a difference in the subclasses in the
		// middle of the returned string, it will get right string from func() on each
		// sub class
		return String.format("%s(%s) %s(%d), price = %d", getClass().getSimpleName(), func(), company, serialNum,
				price);
	}

	protected abstract String func(); // Abstract method, will be implemented by the sub-classes
}
