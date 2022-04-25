package racingcar.ui;

import racingcar.common.InfoMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class Output {
    public static void printMessage(String message){
        System.out.print(message);
    }

    public static void printMessageWithLineSpacing(String message){
        System.out.println(message);
    }

    public static void printLineSpacing(){
        System.out.println();
    }

    public static void printDoubleLineSpacing(){
        System.out.println();
        System.out.println();
    }

    public static void printInterimResult(Cars cars){
        StringBuilder interimResult = new StringBuilder();
        for (int i = 0; i < cars.getCarList().size(); i++) {
            Car car = cars.getCarList().get(i);
            interimResult.append(car.getName().getCarName())
                    .append(InfoMessage.OUTPUT_COLON)
                    .append(printPosition(car.getPosition().getCarPosition()));
            printMessageWithLineSpacing(interimResult.toString());
            interimResult.setLength(0);
        }
    }

    private static String printPosition(int position){
        StringBuilder positionIndicator = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionIndicator.append(InfoMessage.OUTPUT_MOVEMENT);
        }
        return positionIndicator.toString();
    }

    public static void printWinners(Winners winners){
        printMessage(winners.toString());
    }

}
