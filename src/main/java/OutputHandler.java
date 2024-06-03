import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Vector;

public class OutputHandler {

    public static void fowardOutput(Vector<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.elementAt(i).getName() + " : ");
            for (int j = 0; j < cars.elementAt(i).getNumber(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void winnerOutput(Vector<Car> cars) {
        StringBuilder sb = new StringBuilder();
        System.out.print("최종 우승자 : ");
        Optional<Integer> maxNumberOptional = cars.stream().map(Car::getNumber)
            .max(Comparator.naturalOrder());
        int maxNumber = maxNumberOptional.orElseThrow(
            () -> new NoSuchElementException("No value present"));
        for (int i = 0; i < cars.size(); i++) {
            if (maxNumber == cars.elementAt(i).getNumber()) {
                sb.append(cars.elementAt(i).getName() + ", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }

}
