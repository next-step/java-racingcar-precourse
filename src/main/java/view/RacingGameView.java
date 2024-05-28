package view;

import domain.Car;

import java.util.Scanner;

public class RacingGameView {
    private Scanner scanner;

    public RacingGameView() {
        scanner = new Scanner(System.in);
    }

    public String[] getCarNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                isValidateCarNameInput(input);
                return input.split(",");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getAttemptCount() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = scanner.nextLine();
                isValidateAttemptCountInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void displayRaceResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void displayUpdatedCars(Car[] cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            String name = car.getName();
            int raceDistance = car.getRaceDistance();
            sb.append(name + " : " + "-".repeat(raceDistance) + "\n");
        }
        System.out.print(sb.toString());
        System.out.println();
    }

    public void displayWinner(Car[] cars) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < cars.length; i++) {
            sb.append(cars[i].getName());
            if (i < cars.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

    public void isValidateCarNameInput(String input) {

        String[] splitInput = input.split(",");
        for (String carName : splitInput) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void isValidateAttemptCountInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!('0' <= input.charAt(i) && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }
}
