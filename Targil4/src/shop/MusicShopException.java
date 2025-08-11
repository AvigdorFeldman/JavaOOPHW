package shop;

public class MusicShopException extends Exception{
	// Exception of for the Shop class, extends from Exception

	private static final long serialVersionUID = -2705746133272713719L;
	public MusicShopException(String str) {
		// Constructor of the Exception
		super(str);
	}
}
