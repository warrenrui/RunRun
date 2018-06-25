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
        Enumeration<Rental> rentalsEnums = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalsEnums.hasMoreElements()) {
            Rental each = rentalsEnums.nextElement();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getThisAmount()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        Enumeration<Rental> rentalsEnums = rentals.elements();
        while (rentalsEnums.hasMoreElements()) {
            Rental each = rentalsEnums.nextElement();
            totalAmount += each.getThisAmount();
        }
        return totalAmount;
    }

    private double getFrequentRenterPoints() {
        /**
         * 常客积分
         */
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentalsEnums = rentals.elements();
        while (rentalsEnums.hasMoreElements()) {
            Rental each = rentalsEnums.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}
