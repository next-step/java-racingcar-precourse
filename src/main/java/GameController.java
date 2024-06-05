import java.util.ArrayList;
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

            for (int i = 0; i < carNames.length; i++) {
                carNames[i] = carNames[i].trim();
            }
            try {
                checkNameLength(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] The name of the car must be within 5 characters. please type again");
            }

        }
        return carNames;
    }

    private void checkNameLength(String[] carNames) { // if wrong length of car name: throws IllegalArgumentException
        for (String carName : carNames) {
            if(carName.length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputTryCount() {
        System.out.println("Enter count for try");
        int tryCount = scanner.nextInt();
        System.out.println("tryCount = " + tryCount);

        return tryCount;
    }


}
