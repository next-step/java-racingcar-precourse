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

        return CarNamesParser.parse(input);
    }

    public int getNumberOfMoves() {
        while(true) {
            try {
                return readNumberOfMoves();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readNumberOfMoves() {
        try {
            int numberOfMoves = scanner.nextInt();
            scanner.nextLine();  // 버퍼 비우기
            return numberOfMoves;
        } catch (Exception e) {
            scanner.nextLine();  // 잘못된 버퍼 비우기
            throw new IllegalArgumentException("[ERROR] 정수만 입력할 수 있습니다.");
        }
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

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if(i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
