import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public List<String> getCarNames() {
        List<String> carNames;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = List.of(sc.nextLine().split(","));
            if (CheckInput.checkCarNames(carNames)) {
                sc.close();
                break;
            }
        }
        return carNames;
    }

    public int getTryNum() {
        int tryNum;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                tryNum = sc.nextInt();
                break;
            } catch (IllegalArgumentException e) {
                CheckInput.isWrongValue();
            }
        }
        return tryNum;
    }

    public List<Car> makeCars(List<String> carNames) {
        List<Car> Cars = new ArrayList<>();
        for (String carName : carNames) {
            Cars.add(new Car(carName));
        }
        return Cars;
    }

    public List<Car> findWinners(List<Car> cars) {

        int winnerState= cars.get(0).getState();

        for (Car car : cars) {
            int carState = car.getState();
            if (carState > winnerState) {
                winnerState = carState;
            }
        }

        List<Car> winnerList= new ArrayList<>();

        for (Car car : cars) {
            int carState = car.getState();
            if (carState == winnerState) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    public void printWinners(List<Car> cars) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < (cars.size() - 1); i++) {
            System.out.print(cars.get(i).getName() + ", ");
        }
        System.out.println(cars.get(cars.size() - 1).getName());
    }
}
