package  src.main.coding.coding.src.coding.danielcabero.movies;;
import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		String result = "Rental Record for " + getName() + "\n";
		for (Rental each : _rentals) {
			frequentRenterPoints += each.getFrequentRentalPoints();
			result = each.showFiguresForRental(result);
			totalAmount += each.getCharge();
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

}
