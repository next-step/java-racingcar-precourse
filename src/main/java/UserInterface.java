import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Car> inputCars() {
        Printer.printInputCarNames();
        return inputValidCars();
    }

    private static List<Car> inputValidCars() {
        List<Car> cars = null;
        do {
            cars = inputCarName();
        } while (cars == null);
        return cars;
    }

    private static List<Car> generateValidCars(String carNames) throws InvalidCarNameException {
        List<Car> cars = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(carNames, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken().trim();
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public static List<Car> inputCarName() {
        List<Car> cars = null;
        try {
            String inputCarNames = scanner.nextLine();
            Validator.validCheckCarNames(inputCarNames);
            cars = generateValidCars(inputCarNames);
        } catch (InvalidCarNameException e) {
            Printer.printInputError(e.getLocalizedMessage());
        }
        return cars;
    }

}
