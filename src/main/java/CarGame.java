import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CarGame {
    public static int getGameCount(Scanner sc) {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
}
