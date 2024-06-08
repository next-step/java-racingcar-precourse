package util;

import model.Car;
import service.RacingGame;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RacingGameFactory {

    private List<String> vaildCarNames;
    private int validRoundNum;

    public int prepareRacingCar(String carNameInput) throws IllegalArgumentException {
        String[] carnames = carNameInput.trim().split(",");
        List<String> vaildCarNames = new ArrayList<>();

        int i = 1;
        for (String carname : carnames) {
            vaildCarNames.add(isValid(carname,i));
            i ++;
        }
        this.vaildCarNames = vaildCarNames;

        return 0;

    }

    public String isValid(String carname,int i) throws IllegalArgumentException {

        if (carname == null || carname.isEmpty()) {
            throw new IllegalArgumentException(i + "번째로 입력한 자동차의 이름이 비어있음");
        }
        if (carname.contains(" ")) {
            throw new IllegalArgumentException(i + "번째로 입력한 자동차 이름에 공백이 포함됌");
        }
        if (carname.length() > 5) {
            throw new IllegalArgumentException(i + "번째로 입력한 자동차 이름이 5자를 넘어감");
        }

        return carname;
    }


    public int prepareRound(String inputValue) throws IllegalArgumentException {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException("라운드 횟수가 빈 값이다.");
        }
        if (!inputValue.matches("\\d+")) {
            throw new IllegalArgumentException("라운드 횟수는 정수여야합니다.");
        }
        int rounds = Integer.parseInt(inputValue);
        if (rounds < 1 || rounds > 12) {
            throw new IllegalArgumentException("라운드 횟수는 1~12 사이의 값이어야합니다.");
        }
        this.validRoundNum = rounds;
        return 0;
    }

    public RacingGame getRacingGame() {
        if (vaildCarNames == null || vaildCarNames.isEmpty()) {
            throw new NullPointerException("유효한 자동차 이름 목록이 비어있습니다.");
        }
        if (validRoundNum == 0) {
            throw new NullPointerException("유효한 라운드 숫자가 설정되지 않았습니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (String carname : vaildCarNames) {
            cars.add(CarFactory.getBasicCar(carname));
        }
        return new RacingGame(cars, this.validRoundNum);
    }


}
