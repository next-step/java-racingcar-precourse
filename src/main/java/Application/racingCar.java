package Application;
import java.util.*;
import java.lang.*;

public class racingCar {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> carPositions = new HashMap<>();
        int attempts = 0;

        while(true) { // depth: 1
            try { // depth: 2
                System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                String[] carNames = parseCarNames(input);

                for(String name : carNames) { // depth: 3
                    carPositions.put(name.trim(), 0); // depth: 4
                }

                System.out.println("시도할 횟수는 몇회인가요?");
                attempts = parseAttempts(scanner.nextLine());

                break;
            } catch (IllegalArgumentException e) { // depth: 2
                System.out.println("[ERROR] " + e.getMessage()); // depth: 3
            }
        }

        Random random = new Random();
        for(int i=0; i<attempts; i++) { // depth: 1
            for(String name : carPositions.keySet()) { // depth: 2
                if(random.nextInt(10) >= 4) carPositions.put(name, carPositions.get(name) + 1); // depth: 3
            }
            printCarPositions(carPositions);
        }
        printWinners(carPositions);
    }

    private static String[] parseCarNames(String input) { // depth: 1
        if(input == null || input.trim().isEmpty()) { // depth: 2
            throw new IllegalArgumentException("자동차 이름을 입력하세요."); // depth: 2
        }

        String[] carNames = input.split(",");
        for(String name:carNames) { // depth: 2
            if(name.trim().isEmpty()) throw new IllegalArgumentException("자동차 이름이 비어있을 수 없습니다."); // depth: 3
        }
        return carNames;
    }
    private static int parseAttempts(String input) { // depth: 1
        try { // depth: 2
            int attempts = Integer.parseInt(input);
            if(attempts <= 0) { // depth: 3
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다."); // depth: 4
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }

    private static void printCarPositions(Map<String, Integer> carPositions) {
        for(Map.Entry<String, Integer> entry:carPositions.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for(int i=0; i<entry.getValue(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printWinners(Map<String, Integer> carPositions) {
        int maxPosition = carPositions.values().stream().max(Integer::compare).orElse(0);
        StringBuilder winners = new StringBuilder();

        for(Map.Entry<String, Integer> entry: carPositions.entrySet()) {
            if(entry.getValue() == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(entry.getKey());
            }
        }
        System.out.println("최종 우승자: " + winners.toString());
    }

}
