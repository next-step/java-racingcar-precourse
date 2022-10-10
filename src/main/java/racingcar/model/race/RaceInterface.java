package racingcar.model.race;

import java.util.List;
import racingcar.model.car.Cars;

/**
 * 경기 인터페이스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public interface RaceInterface {

    void start();

    void announceFinalWinner();

    boolean isRaceOver();

    boolean isRaceReady();

    Record getRaceRecord();

    void setupCars(Cars cars);

    void setupTrial(Trial trial);
}
