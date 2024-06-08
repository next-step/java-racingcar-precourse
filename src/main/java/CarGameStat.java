import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import model.Car;

public class CarGameStat {
    private List<Car> cars;
    private int repeatNum;
    private int fastest;

    public void oneSet() {
        SecureRandom ran = new SecureRandom();
        for(Car car : cars) {
            int randomNumber = ran.nextInt(10);
            if(randomNumber >= 4)
                car.moveCurPosition();
            if(fastest <= car.getCurPosition())
                fastest = car.getCurPosition();
        }
    }
    public CarGameStat() {
        cars = new ArrayList<>();
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setRepeatNum(int repeatNum) {
        this.repeatNum = repeatNum;
    }

    public int getRepeatNum() {
        return repeatNum;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getFastest() {
        return fastest;
    }
}
