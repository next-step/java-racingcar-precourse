package racingcar.common.util;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;

public class Input {
    public static String readLine() {
        try{
            return Console.readLine();
        }catch (Exception e){
            return "";
        }
    }

    public static int readLineNumber() {
        String num = readLine();
        if("".equals(num)){
            return 0;
        }
        try{
            return Integer.valueOf(num);
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
