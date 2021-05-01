package com.bistros.racing.game;

import com.bistros.racing.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingGame {
    private final List<PlayingCar> playingCars;
    private final int playerCount;
    private final int round;

    public PlayingGame(List<Car> cars, int round) {
        playingCars = new ArrayList<>();
        for (int number = 0; number < cars.size(); number++) {
            playingCars.add(new PlayingCar(cars.get(number)));
        }
        this.round = round;
        playerCount = playingCars.size();
    }

    public void start() {
        System.out.println("실행 결과");
        for (int turn = 0; turn < round; turn++) {
            playTurn();
            System.out.println("");
        }
        printWinner();
    }

    public void playTurn() {
        for (int number = 0; number < playerCount; number++) {
            PlayingCar car = playingCars.get(number);
            car.play();
        }
    }

    public void printWinner() {
        PlayingCar maxPositionCar = Collections.max(playingCars);

        List<String> winners = new ArrayList<>();
        for (PlayingCar playingCar : playingCars) {
            if (playingCar.status(maxPositionCar) == PositionLead.TIE) {
                winners.add(playingCar.getCar().getName());
            }
        }

        System.out.println(String.join("," , winners) + " 가 최종 우승했습니다");
    }
}
