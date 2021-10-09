package racinggame.utils;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    public static String getInputString() {
        return Console.readLine();
    }

    public static int getStringToInt(String str) {
        return Integer.valueOf(str);
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
