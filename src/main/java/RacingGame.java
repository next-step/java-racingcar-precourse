import java.util.*;
public class RacingGame {
    Scanner scanner = new Scanner(System.in);
    private List<Car> carList;
    private List<String> winners = new ArrayList<>();
    private int tryCount;
    private void makeCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }
    }
    private void makeCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        tryCount = scanner.nextInt();
    }
    private void makeRace(){
        for (int i = 0; i < tryCount; i++) {
            for (Car car : carList){
                car.makeMove();
                System.out.println(car.getName() + ": " + car.makePosition());
            }
        }
    }
    private void getWinners() {
        int maxPosition = carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
