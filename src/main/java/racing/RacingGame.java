package racing;

import java.util.Scanner;

import static racing.RandomNumber.MOVABLE_MINIMUM_NUMBER;

public class RacingGame {

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은쉼표(,)기준으로구분)");
        
        Scanner scanner = new Scanner(System.in);
        String carList = scanner.nextLine().replace(" ", "");
        
        Cars cars = new Cars(carList);

        System.out.println("시도할 회수는 몇회인가요?");
        
        Scanner scan = new Scanner(System.in);
        int playCount = scan.nextInt();
        
        while(playCount == 0) {
            int testIndex = 0;
            System.out.println("cnt : " + testIndex);
            
            
            
            testIndex++;
        }
    }
    
}
