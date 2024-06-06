package controller;

import model.CarDTO;
import model.GameDTO;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameDTO gameDTO;

    public GameController() {
        this.gameDTO = new GameDTO(generateCarDTOList(InputView.inputCarName()), InputView.inputGameIteration());
    }


    private List<CarDTO> generateCarDTOList(List<String> carNames) {
        List<CarDTO> carDTOArrayList = new ArrayList<>();
        for (String carName : carNames) {
            carDTOArrayList.add(new CarDTO(carName));
        }
        return carDTOArrayList;
    }

    public List<Boolean> getCarsMoveResults() {
        return this.gameDTO.getCarsMovements();
    }

    public List<String> displayCarsMovements() {
        List<Boolean> carsMovements = this.gameDTO.getCarsMovements();
        List<String> carNames = this.gameDTO.getCarNames();
        if (carNames.size() == carsMovements.size()) {
            List<String> results = new ArrayList<>(carNames.size());
            for (int i = 0; i < carNames.size(); i++) {
                // results[i] = carNames.get(i) + " : ";
                results.add(carNames.get(i) + " : ");
                addDash(carsMovements, i, results);
            }
            return results;
        }
        return null;
    }

    private void addDash(List<Boolean> movements, int i, List<String> results) {
        if (movements.get(i)) {
            results.set(i, results.get(i) + "-");
        }
    }


    public void play() {
    }

}
