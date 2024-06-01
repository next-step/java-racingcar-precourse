import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RacingController {
    public static void createList(String[] carList) {
        for(String car: carList)
            RacingGame.racingCar.add(new Car(car));
    }
    public static void carVerify(String[] carList) {
        if (carList.length <= 1)
            throw new IllegalStateException();
        for (String c : carList) {
            if (c.length() > 5 || c.isEmpty())
                throw new IllegalArgumentException();
        }
        Set<String> set = new HashSet<>(Arrays.asList(carList));
        if(set.size() != carList.length)
            throw new IllegalArgumentException();
        createList(carList);
    }
    public static int tryNumVerify(String n) {
        if(n.isBlank())
            throw new IllegalStateException();
        int number = Integer.parseInt(n);
        if(number < 1) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
