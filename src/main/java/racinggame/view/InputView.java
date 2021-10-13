package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.CarName;

public class InputView {

    public static String[] enterCars() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = null;
        try {
            String userInput = Console.readLine();
            carNameList = userInput.split(",");
            validateCarNameList(carNameList);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
            return enterCars();
        }
        return carNameList;
    }

    private static void validateCarNameList(String[] carNameList) {
        for (String carName : carNameList) {
            CarName.validate(carName);
        }
    }
}
