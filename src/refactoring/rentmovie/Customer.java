package refactoring.rentmovie;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }


    public String statement() {

        /**
         * 常客积分
         */
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentalsEnums = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalsEnums.hasMoreElements()) {
            Rental each = rentalsEnums.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount(each)) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";


        return result;
    }

    private double thisAmount(Rental each) {
        return each.getThisAmount();
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        Enumeration<Rental> rentalsEnums = rentals.elements();
        while (rentalsEnums.hasMoreElements()) {
            Rental each = rentalsEnums.nextElement();
            totalAmount += thisAmount(each);
        }
        return totalAmount;
    }

}
