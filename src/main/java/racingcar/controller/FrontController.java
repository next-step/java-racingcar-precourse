package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.Winner;
import racingcar.resolver.ArgumentResolver;
import racingcar.resolver.IntegerArgumentResolver;
import racingcar.resolver.StringArrayArgumentResolver;
import racingcar.view.View;

import java.util.Iterator;

public class FrontController {
    private PlayController playController;
    private ArgumentResolver<String[]> stringArrayArgumentResolver;
    private ArgumentResolver<Integer> integerArgumentResolver;
    private CarRepository carRepository;

    public FrontController() {
        playController = PlayController.getInstance();
        stringArrayArgumentResolver = StringArrayArgumentResolver.getInstance();
        integerArgumentResolver = IntegerArgumentResolver.getInstance();
        carRepository = CarRepository.getInstance();
    }

    public void start() {
        View.printInputCarNames();
        setNameInput();

        View.printInputCount();
        setRound();

        showWinner();
    }

    private void setNameInput() {
        try {
            String input = Console.readLine();
            String[] carNames = stringArrayArgumentResolver.convert(input);
            playController.insertCarInRepository(carNames, carRepository);
        } catch (IllegalArgumentException e) {
            View.printSubtitleln(e.getMessage());
            setNameInput();
        }
    }

    private void setRound() {
        try{
            String count = Console.readLine();
            iterateRound(integerArgumentResolver.convert(count));
        } catch (IllegalArgumentException e){
            View.printSubtitleln(e.getMessage());
            setRound();
        }
    }

    private void iterateRound(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            Iterator<Car> carIt = playController.progressRound(carRepository);
            showProgressInScreen(carIt);
        }
    }

    private void showProgressInScreen(Iterator<Car> carIt) {
        while (carIt.hasNext()) {
            Car nowCar = carIt.next();
            View.printSubtitleln(nowCar.getName() + " : " + nowCar.getDistanceByString());
        }
        View.printSubtitleln("");
    }

    private void showWinner() {
        Winner winner = playController.findWinner(carRepository);
        View.printWinners(winner.toString());
        carRepository.clear();
    }
}
