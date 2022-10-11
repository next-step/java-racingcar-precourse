package racingcar.common.util;

import racingcar.car.value.Position;

public class StringFormat {
    public static String positionToDash(int length){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
