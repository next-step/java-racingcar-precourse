package Racing.view;

import Racing.domain.Car;
import Racing.domain.Cars;
import java.util.ArrayList;
import java.util.List;

//랜덤 숫자에 따라 전진유무를 보여주는 뷰.
public class ScoreView {

    public void printScore(Cars cars) {

        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + car.getDistanceBar());
        }
        System.out.println();
    }

}
