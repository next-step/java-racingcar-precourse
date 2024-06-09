package model;

import java.util.ArrayList;
import java.util.List;
import view.GameView;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private int attemps;
    private final GameView gameView = new GameView();

    public Game(List<String> nameList, int attemps) {
        for (String carName: nameList){
            this.cars.add(new Car(carName));
        }
        this.attemps = attemps;
    }

    public void start(){

        int tries = 0;
        // 입력한 시도 횟수만큼 반복
        gameView.showCarsPositionInit();
        while(tries < attemps){
            // 자동차 이동
            goCars();
            // 자동차 위치 출력
            showCarsPosition();
            gameView.printBlank();
            // 횟수 증가
            tries++;
        }
        showWinner();
    }
    private void goCars(){
        for (Car car : cars){
            car.go();
        }
    }

    private void showCarsPosition(){
        for (Car car : cars){
            gameView.showCarsPosition(car.getName(), car.getPosition());
        }
    }

    private void showWinner(){
        // 최대 position 값을 찾는다
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 최대 position 값을 가진 Car 객체의 이름을 출력한다
        List<String> maxPositionCarNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                maxPositionCarNames.add(car.getName());
            }
        }

        // 이름을 콤마로 구분하여 출력합니다.
        String winnerNames = String.join(", ", maxPositionCarNames);
        gameView.showWinner(winnerNames);
    }
}
