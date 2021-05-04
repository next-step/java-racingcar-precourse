import java.util.Scanner;

public class RacingCar {
    /**
     * 게임 스타트
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = scanner.next();
        String[] carNames = parseCarNames(carNameInput);

        scanner.close();
    }

    /**
     * 자동차 이름 파싱
     * @param carNames
     * @return
     */
    public String[] parseCarNames(String carNames) {
        return carNames.split(",");
    }

}
