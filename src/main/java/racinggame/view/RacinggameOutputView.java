package racinggame.view;

import racinggame.code.InGameText;
import racinggame.exception.RacinggameException;
import racinggame.model.Car;
import racinggame.model.CarList;

public class RacinggameOutputView {
    public static void executeResult() {
        System.out.println(InGameText.EMPTY_LINE.getValue() + InGameText.EXECUTE_RESULT.getValue());
    }

    public static void roundResult(CarList carList) {
        for (Car car : carList.getCarList()) {
            System.out.println(car.getCarNameStr() + InGameText.COLON.getValue() + printDash(car.getCarPositionInt()));
        }
        System.out.print(InGameText.EMPTY_LINE.getValue());
    }

    private static String printDash(int position) {
        StringBuilder dashes = new StringBuilder();

        for (int i = 0; i < position; i++) {
            dashes.append(InGameText.DASH.getValue());
        }

        return dashes.toString();
    }

    public static void gameResult(String firstPlace) {
        System.out.println(
                InGameText.FIRST_PLACE_START.getValue() + firstPlace + InGameText.FIRST_PLACE_END.getValue()
        );
    }

    public static void error(RacinggameException racinggameException) {
        System.out.println(racinggameException.getMessage());
    }
}
