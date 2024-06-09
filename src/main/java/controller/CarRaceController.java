package controller;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import model.Race;
import view.InputView;
import view.OutputView;

public class CarRaceController {
    public void startRace() {
        try {
            List<String> carNames = InputView.getCarNames();
            int raceCount = InputView.getRaceCount();

            Race race = new Race(carNames);
            race.run(raceCount);

            List<Car> winners = race.getWinners();
            printWinners(winners);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        OutputView.printMessage("최종 우승자 : " + winnerNames);
    }
}
