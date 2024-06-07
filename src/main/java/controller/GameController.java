package controller;

import model.CarDTO;
import model.GameDTO;
import view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class GameController {
    private GameDTO gameDTO;

    public GameController() {
        this.gameDTO = new GameDTO(generateCarDTOList(InputView.inputCarName()), InputView.inputGameIteration());
        InputView.closeScanner();
    }


    private List<CarDTO> generateCarDTOList(List<String> carNames) {
        List<CarDTO> carDTOArrayList = new ArrayList<>();
        for (String carName : carNames) {
            carDTOArrayList.add(new CarDTO(carName));
        }
        return carDTOArrayList;
    }

    // public List<Boolean> getCarsMoveResults() {
    //     return this.gameDTO.getCarsMovements();
    // }

    public Map<String, Integer> recordsCarMovements() {
        List<Boolean> carsMovements = this.gameDTO.getCarsMovements();
        List<String> carNames = this.gameDTO.getCarNames();
        // gameDTO에서 Map을 가져와서 해당 결과를 불러와야 한다.
        if (carsMovements.size() == carNames.size()) {
            for (int i = 0; i < carNames.size(); i++) {
                checkMovements(carsMovements, i, carNames);
            }
        }
        return this.gameDTO.getRecords();
    }

    private void checkMovements(List<Boolean> carsMovements, int i, List<String> carNames) {
        if (carsMovements.get(i)) { // if car moved
            this.gameDTO.addMovements(carNames.get(i));
        }
    }

    public int getGameIteration() {
        return this.gameDTO.getIteration();
    }

    public List<String> getWinner() {
        Map<String, Integer> records = this.gameDTO.getRecords();
        OptionalInt maxOpt = records.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max();
        if (maxOpt.isPresent()) {
            return filterWinner(maxOpt, records);
        }
        return null;
    }

    private List<String> filterWinner(OptionalInt maxOpt, Map<String, Integer> records) {
        int maxValue = maxOpt.getAsInt();
        return records.entrySet()
                .stream()
                .filter(x -> x.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .toList();
    }

}
