package Service;

import DTO.Car;
import Util.Util;
import View.Print;
import java.util.List;

public class RacingService {
    //    4이상의 값이 들어오면 한 칸 나아간다
    public void updateNum(int num, Car car) {
        if (num >= 4) {
            car.plusNum();
        }
    }
}
