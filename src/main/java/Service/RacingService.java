package Service;

import DTO.Car;

public class RacingService {

    //    4이상의 값이 들어오면 한 칸 나아간다
    public void updateNum(int num, Car car) {
        if (num >= 4) {
            car.plusNum();
        }
    }
}
