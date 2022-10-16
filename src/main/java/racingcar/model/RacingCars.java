package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.message.ErrorMessage;
import racingcar.message.Out;

public class RacingCars {

    private final String CAR_NAME_SEPARATOR = ",";
    private final List<RacingCar> cars = new ArrayList<>();

    public RacingCars(String carNames) {
        validEmpty(carNames);
        validSplitEmpty(carNames);

        for (String name : carNames.split(CAR_NAME_SEPARATOR)){
            validLength(name);
            cars.add(new RacingCar(name));

        }
    }

    private void validSplitEmpty(String carNames) {
        String[] split = carNames.split(CAR_NAME_SEPARATOR);
        if (split.length == 0){
            throw new IllegalArgumentException(ErrorMessage.ERR_INPUT_THE_CAR_NAME);
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private void validEmpty(String name){
        if(name == null || name == ""){
            throw new IllegalArgumentException(ErrorMessage.getMessageValidNameOneToFive());
        }

    }

    private void validLength(String name){
        if(name.length() == 0 || name.length() > 5){
            throw new IllegalArgumentException(ErrorMessage.getMessageValidNameOneToFive());
        }
    }

    public void race(int count){
        Out.printResult();
        for (int i = 0; i < count; i++) {
            oneRace();
        }
    }

    private void oneRace() {
        for (RacingCar car : cars){
            car.goRace();
            Out.printOneRaceResult(car.getName(), car.getRaceStatus());
        }
        Out.printNextLine();
    }

    public void printResult() {
        Collections.sort(cars, Collections.reverseOrder());
        StringBuilder builder = new StringBuilder();
        String winnerStatus = cars.get(0).getRaceStatus();

        for (int i = 0; i < cars.size(); i++) {
            String compareStatus = cars.get(i).getRaceStatus();
            builder.append(getWinnerCarName(winnerStatus, i, compareStatus));
        }

        Out.printWinner(builder.toString());
    }

    private String getWinnerCarName(String winnerStatus, int i, String compareStatus) {
        StringBuilder builder = new StringBuilder();
        if(winnerStatus.equals(compareStatus)){
            builder.append(getCarNameText(cars.get(i), i));
        }
        return builder.toString();
    }

    private String getCarNameText(RacingCar car, int i) {
        if(i != 0){
            return ", " + car.getName();
        }
        return car.getName();
    }

    @Override
    public String toString() {
        return "RacingCars{" +
                "cars=" + cars.toString() +
                '}';
    }

}
