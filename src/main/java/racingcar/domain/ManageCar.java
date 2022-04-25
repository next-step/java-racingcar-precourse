package racingcar.domain;

import racingcar.utils.ValidCommonConditionEnum;
import racingcar.utils.ValidNumberConditionEnum;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class ManageCar {
    private List<CarInfo> carInfoList;
    private int playRepeatCnt;
    private int highScore;
    private List<String> winnerList;


    public ManageCar(String userInputCarNames, String repeatCnt) {
        clearGameInfo();
        createCar(userInputCarNames);
        this.playRepeatCnt = Integer.parseInt(repeatCnt);
    }

    private void clearGameInfo() {
        carInfoList = new ArrayList<>();
        winnerList = new ArrayList<>();
        highScore = ValidNumberConditionEnum.MIN_VALUE.getValue();
    }

    private void createCar(String userInputCarNames) {
        //1. 자동차 입력받는 기능 구현 완료
        //Validation 완료 후 실제 자동차 객체 생성
        for (String name : userInputCarNames.split(ValidCommonConditionEnum.DELIMITER.getValue())) {
            this.carInfoList.add(new CarInfo(name));
        }
    }

    public List<CarInfo> getCarInfoList(){
        return this.carInfoList;
    }

    public void setCarInfoList(List<CarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }

    public CarInfo getCarInfo(int i) {
        return this.carInfoList.get(i);
    }

    public List<String> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(List<String> winnerList) {
        this.winnerList = winnerList;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void playGame() {
        for(int i=0; i<playRepeatCnt; i++) {
            playGameResult(i);
        }

        for (CarInfo carInfo : carInfoList) {
            getWinnerInfo(winnerList, carInfo);
        }

        //8. 우승자 출력하는 로직
        OutputView.printWinnerMsg(winnerList);
    }

    public void getWinnerInfo(List<String> winnerList, CarInfo carInfo) {
        //6. 가장 많이 전진한 자동차의 스코어 구하는 로직
        //7. 우승자 List 구하는 로직
        if (carInfo.getForwardCount() >= highScore) {
            resetWinnerInfo(winnerList, carInfo.getForwardCount());
            winnerList.add(carInfo.getName());
        }
    }

    private void resetWinnerInfo(List<String> winnerList, int score) {
        if(score > this.highScore){
            winnerList.clear();
        }
        this.highScore = score;
    }

    public void carMoveForward() {
        //0~9사이의 랜덤 숫자 생성하는 로직
        //4이상일 시 전진대상으로 판단하는 로직
        //콜렉션 개체의 전진카운트 증가시키는 로직
        for (CarInfo carInfo : carInfoList) {
            carInfo.moveForward();
        }
    }

    private void printCurrentResultMsg() {
        OutputView.printCurrentResultMsg();
    }

    public void printCurrentPoint() {
        //5. 현재 누적된 경주 결과 출력하는 로직
        for (CarInfo carInfo : carInfoList) {
            OutputView.printCurrentPoint(carInfo);
        }
    }

    private void playGameResult(int i) {
        //3. 전진/멈춤 조건 판별하는 기능
        //4. 전진 횟수 누적하는 기능
        carMoveForward();

        //5. 현재 누적된 경주 결과 출력하는 로직
        printCurrentResultMsg();
        printCurrentPoint();
    }
}
