package racinggame.service;

import racinggame.domain.InputCarsName;

import java.util.List;

public class RaceService {

    public String[] splitNameWithComma(InputCarsName inputCarsName) {
        return inputCarsName.getName().split(",");
    }
}
