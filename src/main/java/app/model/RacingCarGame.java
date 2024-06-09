package app.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private int attemptCnt; // 시도할 회수
    private int curCnt;     // 현재까지 시도한 회수
    private List<RacingCar> carList;

    public RacingCarGame() {
        this.curCnt = 0;
    }

    public int getAttemptCnt() {
        return attemptCnt;
    }

    public void setAttemptCnt(int attemptCnt) {
        this.attemptCnt = attemptCnt;
    }

    public int getCurCnt() {
        return curCnt;
    }

    public void setCurCnt(int curCnt) {
        this.curCnt = curCnt;
    }

    public List<RacingCar> getCarList() {
        return carList;
    }

    public void setCarList(String carNames) {
        String[] carNameList = carNames.split(",");
        checkCarNameValidation(carNameList);

        this.carList = Arrays.stream(carNameList).map(RacingCar::new).collect(Collectors.toList());
    }

    public void checkCarNameValidation(String[] carNameList) {
        Arrays.stream(carNameList).filter(name -> name.length() > 5 || name.length() < 1).findAny().ifPresent(name -> {
            throw new IllegalArgumentException("자동차 이름은 1자리 이상 5자리 이하만 가능합니다.");
        });
    }
}
