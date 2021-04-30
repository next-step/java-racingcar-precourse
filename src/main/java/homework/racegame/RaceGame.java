package homework.racegame;

import homework.racegame.domain.Car;
import homework.racegame.domain.CarGroup;
import homework.racegame.util.ValidationChecker;
import java.util.List;
import java.util.Scanner;

public class RaceGame {

    String[] getCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] splitedCarNames;
        do {
            String carNames = scanner.next();
            splitedCarNames = carNames.split(",");
        } while (!ValidationChecker.isValidCarName(splitedCarNames));
        return splitedCarNames;
    }

    int getTryCount(Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        String strTryCount;
        do {
            strTryCount = scanner.next();
        } while (!ValidationChecker.isValidTryCount(strTryCount));
        return Integer.valueOf(strTryCount);
    }

    void printWinners(List<Car> winners) {
        if (winners == null || winners.isEmpty()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Car winner : winners) {
            stringBuffer.append(winner.getName()).append(", ");
        }
        stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        stringBuffer.append("가 최종 우승했습니다.");
        System.out.println(stringBuffer);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
        int tryCount = getTryCount(scanner);
        CarGroup carGroup = new CarGroup(carNames);
        for (int index = 0; index < tryCount; index++) {
            carGroup.moveOrStopCars();
            carGroup.printCarsProgress();
        }
        printWinners(carGroup.getWinners());
        scanner.close();
    }
}
