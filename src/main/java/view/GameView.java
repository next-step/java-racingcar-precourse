package view;

import java.util.List;
import java.util.Scanner;
import model.Car;
import util.CarNamesParser;

/**
 * 입출력을 처리하는 view 클래스
 *
 * @author WooseokJang
 */
public class GameView {
    Scanner scanner = new Scanner(System.in);

    /**
     * 자동차 이름들을 입력받는 메서드
     *
     * @return carNames 입력된 문자열을 파싱한 자동차 이름 리스트
     */
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();

        return CarNamesParser.parse(input);
    }

    /**
     * 움직임 횟수를 입력받는 메서드
     *
     * @return numberOfMoves 입력받은 횟수
     * @throws IllegalArgumentException 정수 외 다른 입력을 받을시 예외 발생
     */
    public int getNumberOfMoves() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        while(true) {
            try {
                return readNumberOfMoves();
            } catch(IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    /**
     * getNumberOfMoves에서 실제 입력받는 로직
     *
     * @return numberOfMoves 입력받은 횟수
     * @throws IllegalArgumentException 예외 발생시 에러 메시지 출력
     */
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

    /**
     * 자동차의 현재 위치를 출력하는 메서드
     *
     * @param cars
     */
    public void printCarPosition(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(convertPosition(car));
        }
        System.out.println();
    }

    /**
     * 정수로 저장된 position을 출력을 위해 "-"로 변환하는 메서드
     *
     * @param car
     * @return 변환된 문자열
     */
    private String convertPosition(Car car) {
        String convertedPosition = "";
        for(int i = 0; i < car.getPosition(); i++) {
            convertedPosition = convertedPosition + "-";
        }
        return convertedPosition;
    }

    /**
     * 최종 우승자들의 이름을 출력하는 메서드
     *
     * @param winners 우승자들 리스트
     */
    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if(i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }
}
