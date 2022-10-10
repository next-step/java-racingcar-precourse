package racingcar.service;

import racingcar.model.racingCar;

import java.util.List;

public interface racingcarService {
    void inputracingCars();
    void inputracingCount();
    List<racingCar> inputracingPosition();
    int getMoveCount();
    String racingWinner();
    void racingAddWinner(int idx,int position);

}
