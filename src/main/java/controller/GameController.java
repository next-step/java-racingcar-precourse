package controller;

import model.CarDTO;
import model.GameDTO;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private GameDTO gameDTO;

    private String[] carNames;
    private int iterations;
    public GameController() {
    }

    public GameController(int iterations, String[] carNames) {
        this.iterations = iterations;
        this.carNames = carNames;
    }

    private List<CarDTO> generateCarDTOS(String[] carNames) {
        List<CarDTO> carDTOArrayList = new ArrayList<>();
        for (String carName : carNames) {
            carDTOArrayList.add(new CarDTO(carName));
        }
        return carDTOArrayList;
    }

    public List<Boolean> getCarsMoveResults() {
        return this.gameDTO.getCarsMovements();
    }

    public void play() {
        InputView.printCarInputQuestion();
        this.carNames = InputView.inputCarName();
        InputView.printIterationInputQuestion();
        System.out.println(InputView.inputGameIteration());
        InputView.closeScanner();
    }

}
