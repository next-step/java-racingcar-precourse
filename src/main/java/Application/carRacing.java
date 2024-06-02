package Application;
import java.util.*;
import java.lang.*;

public class carRacing {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController();
        controller.runGame();
    }
}

class RacingGameController {
    private RacingGameModel model;
    private Scanner scanner;

    public RacingGameController() {
        model = new RacingGameModel();
        scanner = new Scanner(System.in);
    }

    public void runGame() {
        try {
            String input = getCarNamesFromUser();
            String[] carNames = parseCarNames(input);
            model.initializeGame(carNames);

            int attempts = getAttemptsFromUser();
            Random random = new Random();
            playGame(attempts, random);
        } catch (IllegalArgumentException e) {
            handleException(e);
        }
    }

    private String getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        return scanner.nextLine();
    }

    private String[] parseCarNames(String input) {
        if(input==null || input.trim().isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        String[] carNames=input.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(String[] carNames) {
        for(String name : carNames){
            if(name.trim().isEmpty()) throw new IllegalArgumentException("자동차 이름이 비어있을 수 없습니다.");
        }
    }

    private int getAttemptsFromUser() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = scanner.nextLine();
        return parseAttempts(input);
    }

    private int parseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if(attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }

    private void playGame(int attempts, Random random) {
        for(int i=0; i<attempts; i++) {
            model.moveCars(random);
            printCarPositions(model.getCarPositions());
        }
        printWinners(model.getWinners());
    }

    private void printCarPositions(Map<String, Integer> carPositions) {
        for(Map.Entry<String, Integer> entry:carPositions.entrySet()) {
            System.out.print(entry.getKey()+" : ");
            printDashes(entry.getValue());
            System.out.println();
        }
        System.out.println();
    }

    private void printDashes(int count) {
        for(int i=0; i<count; i++) {
            System.out.print("-");
        }
    }

    private void printWinners(List<String> winners) {
        System.out.print("최종 우승자: ");
        for(int i=0; i<winners.size(); i++) {
            if(i>0) System.out.print(", ");
            System.out.print(winners.get(i));
        }
        System.out.println();
    }

    private void handleException(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }


}

class RacingGameModel {
    private Map<String, Integer> carPositions;

    public RacingGameModel() {
        carPositions = new HashMap<>();
    }

    public void initializeGame(String[] carNames) {
        for(String name:carNames) carPositions.put(name.trim(), 0);
    }

    public void moveCars(Random random) {
        for(String name: carPositions.keySet()) {
            if(random.nextInt(10) >= 4) carPositions.put(name, carPositions.get(name)+1);
        }
    }

    public Map<String, Integer> getCarPositions() {
        return carPositions;
    }

    public List<String> getWinners() {
        int maxPosition = carPositions.values().stream().max(Integer::compare).orElse(0);
        List<String> winners = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:carPositions.entrySet()) {
            if(entry.getValue() == maxPosition) winners.add(entry.getKey());
        }
        return winners;
    }
}


