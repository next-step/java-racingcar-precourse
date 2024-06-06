import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    private Scanner scanner;

    public GameController() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarNames(){
        String[] carNames;
        while(true){
            System.out.println("Enter the names of the cars to race (names should be separated by commas)");
            String names = scanner.nextLine();
            carNames = names.split(",");

            for (int i = 0; i < carNames.length; i++) { carNames[i] = carNames[i].trim(); }
            try {
                checkNameLength(carNames);// if wrong: throws IllegalArgumentException
                return carNames; // correct
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] The name of the car must be within 5 characters. please type again");
            }
        }
    }

    public void checkNameLength(String[] carNames) {
        for (String carName : carNames) {
            if(carName.length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputTryCount() {
        int tryCount = 0;
        while (true) {
            try {
                System.out.println("Enter count for try");
                tryCount = scanner.nextInt();
                checkTryCountValue(tryCount);
                return tryCount;
            } catch (InputMismatchException e) {
                System.out.println("wrong value type, please type again");
                scanner.nextLine();  // make input buffer empty
            } catch (IllegalArgumentException e) {
                System.out.println("wrong value, value should be more than 0, please type again");
            }
        }
    }

    public void checkTryCountValue(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
