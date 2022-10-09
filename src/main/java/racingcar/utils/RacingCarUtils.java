package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarUtils {

    public static String[] consoleInputRacingDriverNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try{
            return CarNameParser.parseCarName(Console.readLine());
        }catch(IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
            return consoleInputRacingDriverNames();
        }
    }

    public static void printRacingResultByEachRound(List<Car> cars){
        cars.forEach(
                car -> System.out.println(car.printRacingState())
        );
        System.out.println(); // 한줄 띄기
    }

    public static void printWinner(String winners) {
        System.out.println("최종 우승자 : "+winners);
    }

    public static List<Car> createRacingCars(String[] drivers) {
        List<Car> cars = new ArrayList<>();
        Arrays.asList(drivers).forEach(
                driver -> cars.add(new Car(driver))
        );
        return cars;
    }

    public static int consoleInputRacingRound() {
        System.out.println("시도할 횟수는 몇회인가요? ");
        try{
            return MovementUtils.validateOnlyNumber(Console.readLine());
        }catch(IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
            return consoleInputRacingRound();
        }
    }
}
