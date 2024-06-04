import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    private Scanner scanner;
    private ArrayList<String> carList = new ArrayList<>();
    private int tryCount;

    public GameController() {
        this.scanner = new Scanner(System.in);
    }

    public void inputCarNames(){
        System.out.println("Enter the names of the cars to race (names should be separated by commas)");
        String names = scanner.nextLine();
        String[] carNames = names.split(",");
        for (String carName : carNames) {
            carList.add(carName.trim());
        }

        System.out.println("Enter count for try");
        this.tryCount = scanner.nextInt();
        System.out.println("tryCount = " + tryCount);
    }

    public ArrayList<String> getCarList() {
        return carList;
    }

    public int getTryCount() {
        return tryCount;
    }

}
