package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Configuration;
import racingcar.constant.ViewMessage;
import racingcar.domain.Car;
import racingcar.domain.CarEntry;

import java.util.ArrayList;
import java.util.List;

public class CarEntryService {
    public CarEntry makeCarRaceEntity() {
        CarEntry carEntry = new CarEntry();
        try {
            carEntry = readCarEntryFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return carEntry;
    }

    public CarEntry readCarEntryFromUser() {
        String nameStr = getCarNames();
        while(!isValidCarNameLength(nameStr)){
            nameStr = getCarNames();
        }
        String[] nameList = nameStr.split(Configuration.SPLIT_CHAR);
        return addCarsToCarEntity(nameList);
    }

    private String getCarNames() {
        System.out.println(ViewMessage.ENTRY_CAR_NAME);
        return Console.readLine();
    }

    private boolean isValidCarNameLength(String nameStr) {
        String[] nameList = nameStr.split(Configuration.SPLIT_CHAR);
        try {
            addCarsToCarEntity(nameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private CarEntry addCarsToCarEntity(String[] nameList) {
        List<Car> carList = new ArrayList<>();
        for(String name : nameList) {
            carList.add(new Car(name, Configuration.MIN_DISTANCE));
        }
        return new CarEntry(carList);
    }
}
