package app.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private int attemptCnt; // 시도할 회수
    private int curCnt;     // 현재까지 시도한 회수
    private List<RacingCar> carList;

    public RacingCarGame() {
        this.curCnt = 0;
        this.attemptCnt = 0;
    }

    public int getAttemptCnt() {
        return attemptCnt;
    }

    public void setAttemptCnt(String attemptCnt) {
        int num = Integer.parseInt(attemptCnt);
        if (num < 1) throw new IllegalArgumentException("시도 회수는 1 이상이어야 합니다.");
        this.attemptCnt = num;
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

    public void proceed() {
        carList.forEach(RacingCar::moveForward);
        this.curCnt++;
    }

    public List<RacingCar> getWinnerList() {
        int maxLocation = carList.stream().mapToInt(RacingCar::getLocation).max().orElse(0);
        return carList.stream().filter(car -> car.getLocation() == maxLocation).collect(Collectors.toList());
    }

    public boolean isFinished() {
        return this.attemptCnt == this.curCnt;
    }
}
