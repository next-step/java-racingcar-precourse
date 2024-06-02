import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> carList = CarInput.getCarList(sc);

        int gameCount = CarGame.getGameCount(sc);

        int[] forwardMovementCountArray = CarGame.runRace(carList, gameCount);

        ArrayList<String> winners = CarGame.determineWinners(carList, forwardMovementCountArray);

        CarGame.printWinners(winners);
    }
}
