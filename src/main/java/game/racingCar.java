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
                String[] carNames = parseCarNames(input);

                for(String name : carNames) {
                    carPositions.put(name.trim(), 0);
                }

                System.out.println("시도할 횟수는 몇회인가요?");
                attempts = parseAttempts(scanner.nextLine());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        Random random = new Random();
        for(int i=0; i<attempts; i++) {
            for(String name : carPositions.keySet()) {
                if(random.nextInt(10) >= 4) carPositions.put(name, carPositions.get(name) + 1);
            }
            printCarPositions(carPositions);
        }
        printWinners(carPositions);
    }

    private static String[] parseCarNames(String input) {
        if(input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        String[] carNames = input.split(",");
        for(String name:carNames) {
            if(name.trim().isEmpty()) throw new IllegalArgumentException("자동차 이름이 비어있을 수 없습니다.");
        }
        return carNames;
    }
    private static int parseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if(attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
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
