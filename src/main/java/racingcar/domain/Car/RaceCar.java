package racingcar.domain.Car;

import java.util.Scanner;

public class RaceCar {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SEPARATOR = ",";

    public void generateRaceCars(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME);

        String[] participateCarName = getParticipateCarName(scanner);


    }


    public String[] getParticipateCarName(Scanner scanner) {
        String inputCar = scanner.nextLine();

        // validation 추가 후 stream
        String[] result = inputCar.split(SEPARATOR);

        return result;
    }

}
