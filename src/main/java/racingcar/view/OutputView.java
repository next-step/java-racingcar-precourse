package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static racingcar.domain.constants.OutputConst.EXECUTION_RESULT_INSTRUCTION;
import static racingcar.domain.constants.OutputConst.FINAL_WINNERS_INSTRUCTION;

public class OutputView {
    public static void printExecutionResultInstruction() {
        System.out.println(EXECUTION_RESULT_INSTRUCTION);
    }

    public static void printExecutionResult(Cars cars) {
        for(Car car: cars.getCars()) {
            String racedCar = "";
            racedCar += car.getName();
            racedCar += " : ";
            for(int i = 0; i < car.getPosition(); i++) {
                racedCar+="-";
            }
            System.out.println(racedCar);
        }
        System.out.println();
    }

    public static void printFinalWinners(List<Car> winners) {
        System.out.print(FINAL_WINNERS_INSTRUCTION);
        System.out.print(winners.get(0).getName());
        if(winners.size() >= 2) {
            for(int i = 1; i < winners.size(); i++) {
                System.out.print(", ");
                System.out.print(winners.get(i).getName());
            }
        }
    }
}
