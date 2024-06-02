import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] carNames = getCarNames(sc);
    }

    private static String[] getCarNames(Scanner sc) {
        while (true) {
            try {
                return readAndValidateCarNames(sc);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] readAndValidateCarNames(Scanner sc) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String carNamesInput = sc.nextLine();
        String[] carNames = carNamesInput.split(",");
        checkCarNames(carNames);
        return carNames;
    }

    private static void checkCarNames(String[] carNames) {
        // 유효성 검사 부분은 이후 커밋에서 추가
    }
}
