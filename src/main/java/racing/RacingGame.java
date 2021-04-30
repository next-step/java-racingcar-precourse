package racing;

import java.util.Scanner;

public class RacingGame {

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은쉼표(,)기준으로구분)");
        
        Scanner scanner = new Scanner(System.in);
        String carList = scanner.nextLine();
        carList = carList.replace(" ", "");
        
        Cars cars = new Cars(carList);
    }
}
