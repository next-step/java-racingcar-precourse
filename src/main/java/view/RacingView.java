package view;

import model.Car;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingView {

    private static Scanner sc = new Scanner(System.in);

    public static String printInputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return sc.nextLine();
    }
    public static int printInputTryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
    public static void moveStatus(List<Car> carlist){
        System.out.println("실행 결과");
        carlist.forEach(car -> System.out.println(car.getCarname() + ":" + "-".repeat(car.getMove())));

    }
    public static void printResult(List<Car> winners){
        System.out.print("최종 우승자 : ");
        String winner = winners.stream()
                .map(Car::getCarname)
                .collect(Collectors.joining(","));
        System.out.print(winner);


    }


}
