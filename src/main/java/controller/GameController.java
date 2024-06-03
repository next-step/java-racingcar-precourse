package controller;

import model.CarDTO;
import model.GameDTO;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GameController {
    private GameDTO gameDTO;

    public GameController() {
        this.gameDTO = new GameDTO(InputView.inputGameIteration(), generateCarDTOS(InputView.inputCarName()));
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
    }

}
