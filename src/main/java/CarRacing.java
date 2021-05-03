import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    public static List<Cars> getCars(String cars, String sep) {
        String[] carArr = cars.split(sep);
        List<Cars> carList = Arrays.stream(carArr).map(s -> s.trim()).map(Cars::new).collect(Collectors.toList());
        return carList;
    }

}
