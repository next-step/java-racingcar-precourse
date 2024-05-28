package racingCar.view;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import racingCar.customException.CustomException;
import racingCar.customException.TooLowAttemptException;
import racingCar.customException.TooMuchAttemptException;

public class UI {

    private Scanner scanner;
    private final int MAX_ATTEMPTS = 1000;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public String userInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public int userInputAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int userInputInt = scanner.nextInt();
            if(userInputInt < 1)
                throw new TooLowAttemptException("[Error] 시도 횟수가 너무 적습니다. 1 ~ 1000 만 입력 가능합니다.");
            if(userInputInt > MAX_ATTEMPTS)
                throw new TooMuchAttemptException("[Error] 시도 횟수가 너무 많습니다. 1 ~ 1000 만 입력 가능합니다.");
            return userInputInt;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException();
        } finally {
            scanner.nextLine();
        }
    }

    public void printIllegalArgumentException(IllegalArgumentException e) {
        if(e instanceof CustomException) {
            System.out.println(e.getMessage());
            return;
        }
        this.printIllegalArgumentException();
    }

    public void printIllegalArgumentException() { System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");}

    public void printCriticalException(Exception e) {
        e.printStackTrace();
        System.out.println("[ERROR] 확인되지 않은 예외입니다. 관리자에게 문의 주세요.");
    }

    public void notifyThisIsResult() {
        System.out.println("\n실행결과");
    }

    public void printCarStatus(Map<String, Integer> carStatus) {
        carStatus.forEach((key, value) -> {
            System.out.print(key + " : ");
            for (int i = 0; i < value; i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }

    public void printWinner(String string) {
        System.out.println("최종 우승자 : " + string);
    }

    public void notifyExit(){
        System.out.println("예상치 못한 에러로 인해 프로그램을 종료합니다.");
    }

    public void close() {
        scanner.close();
    }


}
