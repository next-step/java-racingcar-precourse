package service;

import domain.Car;

import java.util.List;

public interface RacingGameService {
    void race(List<Car> player, int trialNumber);

    List<Car> decideWinner(List<Car> player);
}
