package shop;

import java.util.*;

public class Shop {
	// The shop class manages a shop of Instruments, it has a list of instruments,
	// and methods that manage the list such as add and get, sell and so on
	private List<Instrument> instrumentList = null;

	public void add(Instrument i) {
		// The method adds instrument i to instrumentList
		if (instrumentList == null)
			instrumentList = new ArrayList<>();
		instrumentList.add(i);
	}

	public Instrument get(int serial) {
		// The method gets a serial number, if the serial number fits to one of the
		// instruments in the list it returns it, otherwise it will return null
		if (instrumentList == null)
			return null;
		for (Instrument instrument : instrumentList) {
			if (instrument.getSerial() == serial)
				return instrument;
		}
		return null;
	}

	public List<Integer> allSerials() {
		// The method returns a list of all the instruments serial numbers
		List<Integer> serialList = new ArrayList<>();
		if (instrumentList == null) {
			return serialList; // Return empty list if no instruments exist
		}
		for (Instrument instrument : instrumentList)
			serialList.add(instrument.getSerial());
		return serialList;
	}

	public List<Integer> guitarsOfType(Type t) {
		// The method returns serial list of guitars with Type t
		List<Integer> serialList = new ArrayList<>();
		if (instrumentList == null) {
			return serialList; // Return empty list if no instruments exist
		}
		for (Instrument instrument : instrumentList) {
			if (instrument instanceof Guitar) { // Checks if instrument is a guitar
				Guitar guitar = (Guitar) instrument;
				if (guitar.getType() == t) // Checks if the guitar is of the Type t, and if it is it
											// adds its serial number to the returned list
					serialList.add(instrument.getSerial());
			}
		}
		return serialList;
	}

	public void sell(int serial) throws MusicShopException {
		// The method sells instrument with the serial number serial, which basically
		// removes the instrument from the list. If the serial number doesn't exist in
		// the list, or the instrument is the last guitar in the shop it throws a
		// MusicShopException
		int count = 0;
		for (Instrument instrument : instrumentList) { // Counts how many guitars in the shop
			if (instrument instanceof Guitar)
				count++;
		}
		Instrument instrumentToSell = get(serial);
		// Throws a MusicShopException if there is no instrument with their received
		// serial or the instrument is the last guitar in the shop
		if (instrumentToSell == null || (instrumentToSell instanceof Guitar && count == 1))
			throw new MusicShopException("No such instrument with that serial number, or last guitar on display");
		else {
			instrumentList.remove(instrumentToSell); // Removes the instrument from the list
		}
	}

	public int sellAll(int[] serials) {
		// The method sells all the instruments in the shop with serial numbers from
		// array serials using sell(), if the sell failed(NusicShopException was thrown)
		// so it will increase count. The method returns the number of instruments that
		// couldn't sell
		int count = 0;
		if (instrumentList == null) // If the list is empty, it will return 0 (count)
			return count;
		if (serials == null) // If serials is an empty array, it will return the size of the instrument list
			return instrumentList.size();
		for (int i = 0; i < serials.length; i++) {
			try {
				sell(serials[i]);
			} catch (MusicShopException e) {
				count++;
			}
		}
		return count;
	}
}
