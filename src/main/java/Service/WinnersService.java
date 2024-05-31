package Service;

import DTO.Car;
import java.util.ArrayList;
import java.util.List;

public class WinnersService {

    // 최대로 이동한 자동차이름들 반환
    public String[] getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int max = cars.get(0).getNum();
        for (Car car : cars) {
            if (max == car.getNum()) {
                winner.add(car.getName());
                continue;
            }
            if (max < car.getNum()) {
                winner.clear();
                winner.add(car.getName());
                max = car.getNum();
            }
        }
        return winner.toArray(new String[0]);
    }

}
