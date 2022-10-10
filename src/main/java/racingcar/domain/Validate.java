package racingcar.domain;

import java.util.List;

public class Validate {

    public static void carNameChk(String carName) {

        for(int i=0; i<carName.split(Code.DELIMITER).length; i++) {
            if(carName.split(Code.DELIMITER)[i].length() > 5) {
                throw new IllegalArgumentException(Code.NAME_LENGTH_ERROR);
            }
        }
    }
}
