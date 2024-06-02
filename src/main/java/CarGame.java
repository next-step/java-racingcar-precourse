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
            printRaceStatus(carList, forwardMovementCountArray);
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

    private static void printRaceStatus(ArrayList<String> carList, int[] forwardMovementCountArray) {
        for (int z = 0; z < carList.size(); z++) {
            printCarStatus(carList.get(z), forwardMovementCountArray[z]);
        }
        System.out.println();
    }

    private static void printCarStatus(String car, int count) {
        System.out.printf("%s : ", car);
        for (int j = 0; j < count; j++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    public static ArrayList<String> determineWinners(ArrayList<String> carList, int[] forwardMovementCountArray) {
        int max = getMaxForwardMovement(forwardMovementCountArray);
        return getWinners(carList, forwardMovementCountArray, max);
    }

    private static ArrayList<String> getWinners(ArrayList<String> carList, int[] forwardMovementCountArray, int max) {
        ArrayList<String> winners = new ArrayList<>();
        for (int k = 0; k < carList.size(); k++) {
            if (forwardMovementCountArray[k] == max) {
                winners.add(carList.get(k));
            }
        }
        return winners;
    }

    public static int getMaxForwardMovement(int[] forwardMovementCountArray) {
        int max = -1;
        for (int movementCount : forwardMovementCountArray) {
            if (movementCount > max) {
                max = movementCount;
            }
        }
        return max;
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int k = 0; k < winners.size(); k++) {
            System.out.print(winners.get(k));
            if (k != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
