import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {

        //입력
//        자동차 이름 여러개 입력 setCar()
        List<Car> cars = new ArrayList<>();
        cars = Set.setCar();
//        이동 횟수 입력. setAttempt()
        int attempt;
        attempt = Set.setAttempt();

//        게임 시작

        for (int i = 0; i < attempt; i++) {
            System.out.println("실행결과");

            for (Car car : cars) {
                car.run();
                car.showLocation();
            }
            System.out.println();
        }

//        승자 보여주기 Winner
        Winner.getWinners(cars);
        Winner.printWinners();


    }
}


