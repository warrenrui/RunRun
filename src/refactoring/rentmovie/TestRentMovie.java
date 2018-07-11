package refactoring.rentmovie;

public class TestRentMovie {
    public static void main(String[] args) {
        final Customer tom = new Customer("Tom");
        tom.addRental(new Rental(new Movie("The Avengers", 0), 3));
        tom.addRental(new Rental(new Movie("Dying to Survive", 1), 4));
        tom.addRental(new Rental(new Movie("The Lion King", 2), 5));
        final String statement = tom.statement();
        System.out.println(statement);
    }
}
