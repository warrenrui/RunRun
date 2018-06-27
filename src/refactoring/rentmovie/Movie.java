package refactoring.rentmovie;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    double getCharge(int daysRented) {
        double charge = 0;
        // determine amounts for each line
        switch (this.getPriceCode()) {
            case Movie.REGULAR:
                charge += 2;
                if (daysRented > 2) {
                    charge += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                charge += daysRented * 3;
                break;
            case Movie.CHILDREN:
                charge += 1.5;
                if (daysRented > 3) {
                    charge += (daysRented - 3) * 1.5;
                }
                break;
            default:
        }
        return charge;
    }

    int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        if ((this.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
