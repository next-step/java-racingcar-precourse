package com.game.racingcar;

import com.game.racingcar.car.Car;
import com.game.racingcar.car.Cars;
import com.game.racingcar.car.impl.RacingCar;
import com.game.racingcar.car.impl.RacingCars;
import com.game.racingcar.car.input.CarName;
import com.game.racingcar.car.input.exception.CarNameNotValidException;
import com.game.racingcar.client.Client;
import com.game.racingcar.client.RacingClient;
import com.game.runner.Game;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements Game {
    private static final String INPUT_SEPARATOR = ",";
    private static final String WINNER_CAR_OUTPUT_TAIL_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_CAR_OUTPUT_SEPARATOR = ", ";
    private static final String GAME_START_MESSAGE = ">> 자동차 경주 게임을 시작하겠습니다.";
    private static final String GAME_END_MESSAGE = ">> 자동차 경주 게임을 종료하겠습니다.";

    private final Client client;
    private final Cars cars;
    private boolean playingYn = true;
    private int tryCount = 0;

    public RacingCarGame() {
        this.client = new RacingClient();
        this.cars = new RacingCars();
    }

    @Override
    public void start() {
        System.out.println(GAME_START_MESSAGE);
        initGameSetting();
    }

    private void initGameSetting() {
        this.initCars();
        this.initTryCount();
    }

    private void initTryCount() {
        this.tryCount = Integer.valueOf(client.inputTryCount());
    }

    private void initCars() {
        boolean isValidInput = false;
        List<CarName> carNameList = new ArrayList<>();

        while (!isValidInput) {
            try {
                carNameList = inputCarNames();
                isValidInput = true;
            } catch (CarNameNotValidException ex) {
                System.out.println(ex.getMessage());
            }
        }

        addCars(carNameList);
    }

    private void addCars(List<CarName> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            CarName carName = carNameList.get(i);
            addCar(RacingCar.of(carName));
        }
    }

    private void addCar(Car car) {
        cars.addCar(car);
    }

    private List<CarName> inputCarNames() {
        String carNamesString = client.inputCarNames();
        String[] carNameArray = carNamesString.split(INPUT_SEPARATOR);

        return transferToCarName(carNameArray);
    }

    private List<CarName> transferToCarName(String[] carNameArray) {
        List<CarName> carNameList = new ArrayList<>();

        for (String carName : carNameArray) {
            String trimedCarName = carName.trim();
            CarName.isValidCarName(trimedCarName);
            carNameList.add(CarName.of(trimedCarName));
        }
        return carNameList;
    }

    @Override
    public boolean isPlaying() {
        return playingYn;
    }

    @Override
    public void run() {
        System.out.println("실행결과");

        // 입력한 시도 횟수만큼 경주 수행
        int runningCount = 0;
        while (runningCount++ < this.tryCount) {
            cars.moveAllCars();
            cars.printWholeCarsPosition();
        }

        this.printWinners(cars.getWinnerCars());

        this.exit();
    }

    private void printWinners(List<Car> winners) {
        String winnerMessage = "";

        for (Car winner : winners) {
            winnerMessage += winner.getCarName() + WINNER_CAR_OUTPUT_SEPARATOR;
        }

        if (winners.size() > 0) {
            winnerMessage = removeLastSeparator(winnerMessage);
            winnerMessage += WINNER_CAR_OUTPUT_TAIL_MESSAGE;
            System.out.println(winnerMessage);
        }
    }

    private String removeLastSeparator(String winnerMessage) {
        winnerMessage = winnerMessage.substring(0, winnerMessage.length() - WINNER_CAR_OUTPUT_SEPARATOR.length());
        return winnerMessage;
    }

    @Override
    public void exit() {
        playingYn = false;
    }

    @Override
    public void end() {
        System.out.println(GAME_END_MESSAGE);
    }
}
