import java.util.Scanner;

public class RacingCar {
    /**
     * 게임 스타트
     * @throws Exception
     */
    public void start() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = scanner.next();
        String[] carNames = parseCarNames(carNameInput);
        
        System.out.println("시도할 횟수");

        scanner.close();
    }

    /**
     * 자동차 이름 파싱
     * @param carNames
     * @return
     * @throws Exception
     */
    public String[] parseCarNames(String carNames) throws Exception {
        String[] carNamesArr = carNames.split(",");

        for(String carName : carNamesArr) {
            if(carName.length() > 5) {
                throw new Exception("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        return carNamesArr;
    }

}
