package refactoring.rentmovie;

public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}

class ChildrenPrice extends Price {
    double getCharge(int daysRented) {
        double charge = 1.5;
        if (daysRented > 3) {
            charge += (daysRented - 3) * 1.5;
        }
        return charge;
    }

    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }
}

class NewReleasePrice extends Price {
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}

class RegularPrice extends Price {
    double getCharge(int daysRented) {
        double charge = 2;
        if (daysRented > 2) {
            charge += (daysRented - 2) * 1.5;
        }
        return charge;
    }

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
