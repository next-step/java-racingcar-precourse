import java.util.ArrayList;
import java.util.Scanner;

public class CarInput {

    public static ArrayList<String> getCarList(Scanner sc) {
        while (true) {
            try {
                return createCarList(sc);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<String> createCarList(Scanner sc) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carListArray = carListSplit(sc.nextLine());
        ArrayList<String> carList = new ArrayList<>();
        for (String s : carListArray) {
            validateCarName(s);
            carList.add(s);
        }
        return carList;
    }

    public static void validateCarName(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static String[] carListSplit(String carListInput) {
        return carListInput.split(",");
    }
}
