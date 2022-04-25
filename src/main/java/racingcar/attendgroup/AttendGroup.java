package racingcar.attendgroup;

import racingcar.car.Car;

import java.util.List;

public class AttendGroup {
    private List<Car> attendCarList;

    public AttendGroup(List<Car> attendCarList) {
        this.attendCarList = attendCarList;
        validateName(attendCarList);
    }

    public List<Car> getAttendCarList() {
        return attendCarList;
    }

    private void validateName(List<Car> attendCarList) {
        validateAttendCarNumber(attendCarList);
    }

    private void validateAttendCarNumber(List<Car> attendCarList) {
        if (attendCarList.size() == 0) {
            throw new IllegalStateException();
        }
    }
}
