import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacing {

    public static List<Cars> getCars(String cars, String sep) {
        String[] carArr = cars.split(sep);
        List<Cars> carList = Arrays.stream(carArr).map(s -> s.trim()).map(Cars::new).collect(Collectors.toList());
        return carList;
    }

    public static List<Cars> racing(List<Cars> carList, int num) {
        Random random = new Random();
        while (num -- > 0) {
            for (Cars car : carList) {
                int randNum = random.nextInt(10);
                if (randNum >= 4) {
                    car.setPosition(car.getPosition() + "-");
                }
            }
        }
        return carList;
    }
}
