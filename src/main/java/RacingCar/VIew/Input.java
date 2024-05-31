package VIew;

import Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Controller.ValidateInput.validTryCount;
import static Controller.ValidateInput.validCar;

public class Input {
    public static List<Car> inputCars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();

        String[] carNames = input.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            validCar(carNames[i], carList);
            carList.add(new Car(carNames[i]));
        }

        return carList;
    }

    public static int inputTryCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");

        String input = scanner.nextLine();
        validTryCount(input);

        return Integer.parseInt(input);
    }
}
