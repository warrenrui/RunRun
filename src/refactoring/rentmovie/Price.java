package refactoring.rentmovie;

public abstract class Price {
    abstract int getPriceCode();

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
}

class ChildrenPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }
}

class NewReleasePrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}

class RegularPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
