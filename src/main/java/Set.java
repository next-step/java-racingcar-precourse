import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Set {

    public static List<Car> setCar() {
        List<Car> cars = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = sc.nextLine();
            String[] names = input.split(",");

            try {
                validateCarName(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                cars.clear();
                continue;
            }
            for (String name : names) {
                cars.add(new Car(name.trim()));
            }
            break;
        }
        return cars;
    }

    private static void validateCarName(String[] names){
        for (String name : names) {
            validateCarName(name.trim());

        }
    }


    private static void validateCarName(String name) {

        if (name.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상만 가능합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        
    }


    public static int setAttempt(){
        int attempt;
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("시도할 회수는 몇회인가요?");
        attempt = sc.nextInt();
        return attempt;
    }

}
