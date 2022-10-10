package racingcar.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import racingcar.score.Score;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Car implements Comparable<Car> {

    @Setter
    private Speed speed;
    private CarName carName;
    private Score score;

    public Car(CarName carName, Score score) {
        this.carName = carName;
        this.score = score;
    }

    @Override
    public int compareTo(Car car) {
        if (car.getScore().getScore() > this.getScore().getScore()) {
            return 1;
        }
        if (car.getScore().getScore() < this.getScore().getScore()) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object carObj) {

        Car other = (Car) carObj;

        if (this.getCarName().getCarName().equals(other.getCarName().getCarName())) {
            return true;
        }
        return false;
    }
}
