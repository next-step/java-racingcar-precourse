package utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.NumberConst;

public class CommonUtils {
    public static String[] getNamesArray(String names){
        return removeEmptyString(names).split(",");
    }

    public static String removeEmptyString(String str){
        return str.replace(" ", "");
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int getRandomValue(){
        return Randoms.pickNumberInRange(NumberConst.MIN_NUMBER, NumberConst.MAX_NUMBER); // 1~9까지
    }

}
