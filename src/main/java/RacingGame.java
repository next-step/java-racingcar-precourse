import java.util.*;
public class RacingGame {
    Scanner scanner = new Scanner(System.in);
    private List<Car> carList;
    private void makeCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }
    }

}
