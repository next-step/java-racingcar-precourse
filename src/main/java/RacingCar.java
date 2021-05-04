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
        
        System.out.println("시도할 회수는 몇회인가요?");
        String roundInput = scanner.next();
        int rounds = Integer.parseInt(roundInput);

        System.out.println("실행 결과");
        String[] progresses = new String[carNames.length];
        for(int i = 0; i < rounds; i++) {
            for(int ii = 0; ii < carNames.length; ii++) {
                int random = generateRandomNumber();
                if(progresses[ii] == null) {
                    progresses[ii] = "";
                }
                if(random >= 4) {
                    progresses[ii] += "-";
                }
                System.out.println(carNames[ii] + " : " + progresses[ii]);
            }
            System.out.println();
        }

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

    /**
     * 한자릿수 난수 생성
     * @return
     */
    public int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
