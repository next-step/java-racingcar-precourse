import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CarGame {
    public static int getGameCount(Scanner sc) {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    public static int[] runRace(ArrayList<String> carList, int gameCount) {
        System.out.println("\n실행 결과");
        Random random = new Random();
        int[] forwardMovementCountArray = new int[carList.size()];

        for (int i = 0; i < gameCount; i++) {
            advanceCars(carList, forwardMovementCountArray, random);
        }

        return forwardMovementCountArray;
    }

    private static void advanceCars(ArrayList<String> carList, int[] forwardMovementCountArray, Random random) {
        for (int k = 0; k < carList.size(); k++) {
            if (random.nextInt(10) >= 4) {
                forwardMovementCountArray[k]++;
            }
        }
    }



}
