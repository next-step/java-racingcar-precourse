package racingcar.utils;

import java.util.regex.Pattern;

import static racingcar.utils.Contant.*;

public class Validate {
    public boolean isValidInputNames(String[] names){
        try {
            validateName(names);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void validateName(String[] names){
        for(String name : names){
            if(name.length() > 5 || name.length() < 1){
                throw new IllegalArgumentException(ERROR_INPUT_NAME_LENGTH);
            }
            if(!isDuplicate(name, names)){
                throw new IllegalArgumentException(ERROR_INPUT_DUPLICATED);
            }
        }
    }

    private boolean isDuplicate(String name, String[] names){
        int count = 0;
        for(String nameInArr : names){
            if(nameInArr.equals(name)){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }

    public boolean isValidCount(String count){
        try {
            validateCount(count);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void validateCount(String count){
        if(!Pattern.matches("^[0-9]*$", count)){
            throw new IllegalArgumentException(ERROR_INPUT_NOT_NUMBER);
        }
    }
}
