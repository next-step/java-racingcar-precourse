package Controller;

import Model.Car;
import View.Output;
import View.Validation;

import java.util.ArrayList;

public class CarRaceController {
    Validation validation = new Validation();
    Output output = new Output();
    ArrayList<Car> carList; // 자동차 이름
    int cnt;                // 횟수

    public void run() {
        // 입력한 값 검증 (자동차 이름, 횟수)
        carList = validation.carNameException();
        cnt = validation.countException();

        // 자동차 경주수행
        runRace();

        // 결과 출력
        output.printFinalWinner(carList);
    }

    public void runRace() {
        System.out.println("\n실행결과");

        int i=0;
        while (i < cnt) {
            for (Car car : carList) {
                car.move();
            }
            i++;
            output.printRslt(carList);
        }
    }
}
