package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int gameSize;
        String names;
        List<Car> list = new ArrayList<>();
        Cars cars = new Cars(list);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = Console.readLine();
        try{
            cars.validInput1(names);
        } catch (Exception e) {
            System.out.println("[ERROR]");
            return;
        }
        String arr[] = names.split(",");
        for (String s : arr) {
            Car car = new Car(s,0);
            list.add(car);
        }
            cars = new Cars(list);

        System.out.println("시도할 회수는 몇회인가요?");
        gameSize = Integer.parseInt(Console.readLine());
        System.out.println("실행 결과");

        for (int i=0; i<gameSize; i++){
            cars.move();
            cars.print();
        }
        System.out.print("최종 우승자: " + cars.gerWinner());
        return;
    }
}
