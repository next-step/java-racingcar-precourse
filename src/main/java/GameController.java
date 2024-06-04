import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    private Scanner scanner;

    public GameController() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarNames(){
        System.out.println("Enter the names of the cars to race (names should be separated by commas)");
        String names = scanner.nextLine();
        String[] carNames = names.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }

        return carNames;
    }

    public int inputTryCount() {
        System.out.println("Enter count for try");
        int tryCount = scanner.nextInt();
        System.out.println("tryCount = " + tryCount);

        return tryCount;
    }

    public ArrayList<String> getCarList() {
        return carNamesList;
    }

    public int getTryCount() {
        return tryCount;
    }

}
