import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            checkNameLength(name);
            checkNameEnglish(name);
            checkNameEmpty(name);
            checkDuplicateName(carNameSet, name);
        }
    }
    private static void checkNameLength(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private static void checkNameEnglish(String name) {
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영문자만 가능합니다.");
        }

    }

    private static void checkNameEmpty(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에는 공백이 포함될 수 없습니다.");
        }
    }

    private static void checkDuplicateName(Set<String> carNameSet, String name) {
        if (!carNameSet.add(name)) {
            throw new IllegalStateException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }
    private static int getTryCount(Scanner sc) {
        System.out.println("시도할 회수는 몇 회인가요?");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                sc.next(); // discard invalid input
            }
            int tryCount = sc.nextInt();
            if(tryCount >0){
                return tryCount;
            }
            else{
                System.out.println("[ERROR] 양수를 입력해 주세요.");
            }
        }
    }
}
