package racingcar.controller;

import racingcar.domain.Circuit;
import racingcar.domain.LapCount;
import racingcar.domain.Name;
import racingcar.domain.RacingCar;
import racingcar.view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;

public class CircuitController {

    ConsoleView consoleView;
    Circuit circuit;

    public CircuitController() {
        this.consoleView = new ConsoleView();
        this.circuit = new Circuit();
    }

    public void prepareCircuit() {
        this.createRacingCars();
        this.createLapCount();
    }

    public void createRacingCars() {
        String[] names;

        do {
            names = consoleView.getNameStringFromReadLine().split(",");
        } while (!validateNames(names));

        ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(names));
        circuit.makeRacingCars(nameList);
    }

    boolean validateNames(String[] names) {
        try {
            this.destructuringNames(names);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void destructuringNames(String[] names) {
        for (String name : names) {
            new Name(name);
        }
    }

    private void createLapCount() {
        String lapCount;

        do {
            lapCount = consoleView.getLapCountFromReadLine();
        } while (!validateLapCount(Integer.valueOf(lapCount)));
        System.out.println();
        circuit.insertLapCount(Integer.valueOf(lapCount));
    }

    private boolean validateLapCount(int lapCount) {
        try {
            new LapCount(lapCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void runCircuit() {
        consoleView.printConsoleRunResult();
        for (int i = 0; i < this.circuit.getLapCount().getLapCount(); i++) {
            ArrayList<RacingCar> racingCars = circuit.runLap();
            consoleView.printConsoleRacingCarRaceProgress(racingCars);
            System.out.println();
        }
    }

    public void pickWinner() {
        ArrayList<String> winners = circuit.getWinners();
        consoleView.printWinner(winners);
    }

}
