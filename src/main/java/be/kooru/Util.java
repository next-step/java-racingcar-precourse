package be.kooru;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static int[] generateRandomNumber(int extract, int start, int end) {

        int[] result = new int[extract];
        int range = end - start + 1;
        int[] perm = new int[range];

        // Initialize Range Number
        for (int i = start; i <= end; i++)
            perm[i - start] = i;

        // Shuffle Number
        for (int i = 0; i < extract; i++) {
            int rIndex = i + (int) (Math.random() * (range - i));
            int t = perm[rIndex];
            perm[rIndex] = perm[i];
            perm[i] = t;
        }

        // Extract Number
        for (int i = 0; i < extract; i++) {
            result[i] = perm[i];
        }
        return result;
    }

    public static List<Car> convertStringToCarList(String input) {
        String[] inputArray = input.split(",");
        List<Car> carList = new ArrayList<>();
        for (String carName : inputArray) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
