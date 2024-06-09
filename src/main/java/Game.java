import java.util.*;

public class Game {
    Scanner sc;

    public Game(){
        sc = new Scanner(System.in);
    }
    public List<String> getCarNames() {
        List<String> carNames;


        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = List.of(sc.next().split(","));
            if (CheckInput.checkCarNames(carNames)) {
                break;
            }
        }
        return carNames;
    }

    public int getTryNum() {
        int tryNum;
        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            try {
                tryNum = sc.nextInt();
                break;
            } catch (InputMismatchException e){
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
