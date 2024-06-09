package main.java.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Cars(List<Car> CarList) {

    public static final String CAR_NAME_DELIMITER = ",";

    public static Cars createByString(String carsString) {
        // TODO: 사용자 입력 받아 Cars 변환 로직 구현
        return new Cars(new ArrayList<>());
    }
}
