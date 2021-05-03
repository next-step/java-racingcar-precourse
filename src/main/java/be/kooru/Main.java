package be.kooru;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = Util.convertStringToCarList(input.nextLine());
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = input.nextInt();

        CarGame game = new CarGame(cars);

        while (tryCount >= 1) {
            game.start();
            tryCount--;
        }

        game.printCarWinner();
    }
}
