import java.util.List;

public class Output {
    public void carNameOutput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void tryCntOutput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void resultOutput(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
    }

    public void winnerOutput(List<Car> cars) {
        System.out.println();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < cars.size() - 1; i++) {
            System.out.print(cars.get(i).getName() + ", ");
        }
        System.out.println(cars.get(cars.size() - 1).getName());
    }

    public void errorOutput(String error) {
        System.out.println(error);
    }
}
