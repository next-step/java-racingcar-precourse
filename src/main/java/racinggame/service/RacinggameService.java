package racinggame.service;

import java.util.ArrayList;
import java.util.List;

import racinggame.exception.RacinggameException;
import racinggame.model.Car;
import racinggame.model.CarList;
import racinggame.model.RacinggameResult;
import racinggame.util.StringUtils;
import racinggame.view.RacinggameInputView;
import racinggame.view.RacinggameOutputView;

public class RacinggameService {

    public static CarList inputCarList() {
        try {
            String carNameListString = RacinggameInputView.enterCarList();
            List<String> carNameList = StringUtils.parseString(carNameListString);
            return new CarList.Builder()
                    .carList(carNameList)
                    .build();
        } catch (RacinggameException racinggameException) {
            RacinggameOutputView.error(racinggameException);
            return inputCarList();
        }
    }

    public static Integer inputRound() {
        try {
            String round = RacinggameInputView.enterRound();
            StringUtils.validateStringOnlyNumber(round);
            return Integer.parseInt(round);
        } catch (RacinggameException racinggameException) {
            RacinggameOutputView.error(racinggameException);
            return inputRound();
        }
    }

    public static RacinggameResult racing(Integer round, CarList carList) {
        String firstPlace;

        for (int i = 0; i < round; i++) {
            carList.forward();
        }

        firstPlace = getFirstPlace(carList);

        RacinggameOutputView.executeResult();
        for (int i = 0; i < round; i++) {
            RacinggameOutputView.roundResult(carList);
        }

        return new RacinggameResult.Builder().firstPlace(firstPlace).build();
    }

    private static String getFirstPlace(CarList carList) {
        int longestDistance = getLongestDistance(carList);
        List<String> firstPlace = new ArrayList<>();

        for (Car car : carList.getCarList()) {
            extractFirstPlace(car, longestDistance, firstPlace);
        }

        return StringUtils.combinationString(firstPlace);
    }

    private static int getLongestDistance(CarList carList) {
        int longestDistance = 0;

        for (Car car : carList.getCarList()) {
            longestDistance = Math.max(longestDistance, car.getCarPositionInt());
        }

        return longestDistance;
    }

    private static void extractFirstPlace(Car car, int longestDistance, List<String> firstPlace) {
        if (car.getCarPositionInt() == longestDistance) {
            firstPlace.add(car.getCarNameStr());
        }
    }

    public static void gameResult(String firstPlace) {
        RacinggameOutputView.gameResult(firstPlace);
    }
}
