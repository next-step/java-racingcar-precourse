package service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import model.RacingCarDTO;
import repository.CarRepository;
import repository.CarRepositoryImpl;
import utility.Fortuna;
import utility.StringSplitter;

public class RacingService {
    private final CarRepository carRepository = new CarRepositoryImpl();
    private final StringSplitter sp = new StringSplitter();

    public CarRepository getCarRepository(){
        return carRepository;
    }

    public void enrollCars(String carNames) {
        String[] nameArr = sp.splitter(carNames);
        for (String name : nameArr) {
            validateName(name);
            carRepository.add(name);
        }
    }
    public void round(){
        for(RacingCarDTO car : carRepository.getAllCars()){
            if(Fortuna.isForward()){
                car.setForward(car.getForward() + 1);
            }
        }
    }
    public ArrayList<String> getWinnerArrList(){
        ArrayList<String> winnerArrList;
        ArrayList<RacingCarDTO> carList = carRepository.getAllCars();
        int maxForward = getMaxForward(carList);
        winnerArrList = getCollect(carList, maxForward);

        return winnerArrList;
    }
    protected void validateName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5글자를 초과할 수 없습니다.");
        }
    }
    private ArrayList<String> getCollect(ArrayList<RacingCarDTO> carList, int maxForward) {
        return carList.stream()
            .filter(car -> car.getForward() == maxForward)
            .map(RacingCarDTO::getName)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private int getMaxForward(ArrayList<RacingCarDTO> carList) {
        return carList.stream()
            .mapToInt(RacingCarDTO::getForward)
            .max()
            .orElse(0);
    }
}
