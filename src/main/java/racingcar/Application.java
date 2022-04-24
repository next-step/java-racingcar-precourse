package racingcar;

import racingcar.controller.Input;
import racingcar.model.Cars;
import racingcar.view.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차 이름 입력
        Console.printEnterCarName();
        Cars cars = getCars();

        // 시도할 횟수 입력
        int turns = getTurns();

        // for(i<시도 횟수)
        // 각 차수별 실행 결과 출력
        Console.printResult();
        for(int i=0; i<turns; i++){
            cars.moveForward();
            Console.printResult(cars);
        }

        // 최종 우슨자 출력
        Console.printWinner(cars);
    }

    private static int getTurns() {
        int turns = 0;
        try{
            turns = Input.inputTurns();
        }catch (IllegalArgumentException exception){
            System.out.println("[ERROR] " + exception.getMessage());
        }
        return turns;
    }

    private static Cars getCars() {
        Cars cars = null;
        try{
            String carNames = Input.inputCarNames();
            cars = new Cars(carNames);
        }catch (IllegalArgumentException exception){
            System.out.println("[ERROR] " + exception.getMessage());
        }
        return cars;
    }
}
