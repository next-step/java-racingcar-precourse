import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> carNames=getCarNames(scanner);
        int moveCount=getMoveCount(scanner);

        Race race=new Race(carNames);
        for (int i=0;i<moveCount;i++){
            race.moveCars();
            race.printProgress();
        }
    }

    private static List<String> getCarNames(Scanner scanner) {
        while(true){
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input=scanner.nextLine();
            List<String> carNames = Arrays.asList(input.split(","));
            errorCarNames(carNames);
            return carNames;
        }
    }

    private static void errorCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static int getMoveCount(Scanner scanner){
        while(true){
            System.out.println("시도할 회수는 몇회인가요?");
            int moveCount=Integer.parseInt(scanner.nextLine());
            return moveCount;
        }
    }


}
