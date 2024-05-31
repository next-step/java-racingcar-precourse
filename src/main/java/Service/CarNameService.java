package Service;

import DTO.Car;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameService {

    // 입력된 이름을 검증한다.
    // 길이는 5이하
    // 중복불가
    // 공백금지
    public List<Car> checkNames(String[] names) {
        Set<String> set = new HashSet<>();
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            if (name.length() > 5 || !set.add(name) || name.contains(" ")) {
                throw new IllegalArgumentException();
            }
        }

        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

}
