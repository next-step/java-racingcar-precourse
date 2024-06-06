package view;

import java.util.List;
import java.util.Scanner;
import model.Car;
import util.CarNamesParser;

public class GameView {
    Scanner scanner = new Scanner(System.in);
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();

        List<String> carNames = CarNamesParser.parse(input);
        return carNames;
    }

    public int getNumberOfMoves() {
        int numberOfMoves = scanner.nextInt();
        scanner.nextLine();  // 버퍼 비우기
        return numberOfMoves;
    }

    public void printCarPosition(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(convertPosition(car));
        }
        System.out.println();
    }

    private String convertPosition(Car car) {
        String convertedPosition = "";
        for(int i = 0; i < car.getPosition(); i++) {
            convertedPosition = convertedPosition + "-";
        }
        return convertedPosition;
    }

}
