package racinggame.utils;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    public static String getInputString() {
        return Console.readLine();
    }

    public static boolean getCharacterCheck(String str) {
        if(Pattern.matches("^[0-9]*$", str)){
            return true;
        }
        return false;
    }

    public static int getStringToInt(String str) {
        return Integer.parseInt(str);
    }

    public static List<Integer> getRandomList(int size) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultList.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return resultList;
    }

    private Utils(){}
}
