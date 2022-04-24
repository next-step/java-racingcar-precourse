package racingcar.domain.car;

import racingcar.domain.Moving;
import racingcar.domain.MovingCommand;
import racingcar.domain.Track;

public class Car {
    private CarName carName;
    private Track track;
    private Moving moving;

    private Car(CarName carName, Moving moving) {
        this.carName = carName;
        this.track = Track.initialize();
        this.moving = moving;
    }

    public static Car of(CarName name, Moving engine) {
        return new Car(name, engine);
    }

    public String getCarName() {
        return this.carName.getValue();
    }

    public Integer getTrack() {
        return this.track.getValue();
    }

    public void move() {
        MovingCommand movingCommand = this.moving.move();
        this.track.move(movingCommand);
    }
}
