package view;

import java.util.List;
import model.CarState;
import model.CarStates;
import model.RaceResult;

public class OutputView {

    public void printRaceResult(RaceResult raceResult) {
        System.out.println();
        System.out.println("실행 결과");
        for (CarStates carStates : raceResult.getRaceResult()) {
            printCarStates(carStates);
            System.out.println();
        }
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void printCarStates(CarStates carStates) {
        for (CarState carState : carStates.getCarStates()) {
            printCarState(carState);
        }
    }

    private void printCarState(CarState carState) {
        System.out.println(carState.getCarName() + " : " + "-".repeat(carState.getPosition()));
    }
}