package controller;

import view.Input;
import view.Output;
import model.Cars;
import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private Input input = new Input();
    private Output output = new Output();
    private Cars cars = new Cars();
    private int number;

    public void start() {
        carNamesProcess();

        numberProcess();

        // 시도 횟수만큼 자동차를 전진하며 결과 출력
        output.printResultProgress();
        for (int i = 0; i < number; i++) {
            addCarsDistance();
            output.printResult(cars.getCars());
        }

        output.printWinners(getWinners());
    }

    /**
     * 자동차 이름 입력 과정을 수행하는 함수
     * 입력이 유효하지 않으면 IllegalArgumentException이 발생하고 에러 메시지 출력
     */
    public void carNamesProcess() {
        output.printCarNamesProgress();
        while (true) {
            String[] carNames = input.scanCarNames();
            try {
                Validation.checkCarNames(carNames);
                cars.setCars(carNames);
                break;
            } catch (IllegalArgumentException e) {
                output.printException();
            }
        }
    }

    /**
     * 시도 횟수 입력 과정을 수행하는 함수
     * 입력이 유효하지 않으면 IllegalArgumentException이 발생하고 에러 메시지 출력
     */
    public void numberProcess() {
        output.printNumberProgress();
        while (true) {
            String strNumber = input.scanNumber();
            try {
                Validation.checkNumber(strNumber);
                number = Integer.parseInt(strNumber);
                break;
            } catch (IllegalArgumentException e) {
                output.printException();
            }
        }
    }

    /**
     * 한 회차에서 자동차들을 전진시키는 함수
     */
    public void addCarsDistance() {
        for (String carName : cars.getCars().keySet()) {
            int randNum = (int) (Math.random() * 10);
            if (randNum >= 4) {
                cars.addDistance(carName);
            }
        }
    }

    /**
     * 우승자들을 뽑아내는 함수
     *
     * @return 우승자 이름들
     */
    public String[] getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        String maxDistance = Collections.max(cars.getCars().values());
        for (String carName : cars.getCars().keySet()) {
            if (cars.getCars().get(carName).equals(maxDistance)) {
                winners.add(carName);
            }
        }
        return winners.stream().toArray(String[]::new);
    }
}
