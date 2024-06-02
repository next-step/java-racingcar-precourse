package game;
import java.util.*;
import java.lang.*;

public class racingCar {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> carPositions = new HashMap<>();
        int attempts = 0;

        while(true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                String [] carNames; // carNames를 split해서 저장할 메서드 구현

                System.out.println("시도할 횟수는 몇회인가요?");
                // 시도 횟수가 1 이상이며, 자연수가 아닌 값이 들어오지 않게 하는 IllegalArgumentException을 넣은 메서드 구현.
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        
    }
}
