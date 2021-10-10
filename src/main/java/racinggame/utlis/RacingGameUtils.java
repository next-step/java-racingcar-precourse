package racinggame.utlis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class RacingGameUtils {

    /**
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        boolean result = Pattern.matches("^[0-9]*$", str);
        if (!result){
            System.out.println("[ERROR]");
            return false;
        }
        return true;
    }

    /**
     *
     * @param carName
     * @return
     */
    public static int isValidCarNameLength(String carName){
        if (carName.length() <= 5)
            return 0;
        return -1;
    }

    public static boolean isValidCarNameLength(List<String> carNameList){
        int inValidCount = 0;
        for (String carName : carNameList){
            inValidCount += isValidCarNameLength(carName);
        }
        return inValidCount >= 0;
    }
    /**
     *
     * @param carsInput
     * @return
     */
    public static boolean isValidCarsInput(String carsInput){
        boolean result = Pattern.matches("^[a-zA-Z0-9,-]*$", carsInput);

        if (!result){
            System.out.println("[ERROR]");
            return false;
        }

        ArrayList<String> carList = new ArrayList<>();
        Collections.addAll(carList, carsInput.split(","));

        result = isValidCarNameLength(carList);

        if (!result){
            System.out.println("[ERROR]");
            return false;
        }

        return true;
    }
}
