import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void validateCarNames(String carNames) {
        String[] names = carNames.split(",");
        if(names.length == 0) {
            throw new IllegalStateException(Messages.CAR_NAME_EMPTY_ERR);
        }
        Set<String> nameSet = new HashSet<>();
        for(int i = 0; i < names.length; ++i) {
            if(names[i].length() == 0) {
                throw new IllegalArgumentException(Messages.CAR_NAME_EMPTY_ERR);
            }
            if(names[i].length() > 5) {
                throw new IllegalArgumentException(Messages.CAR_NAME_ERR);
            }
            if(!nameSet.add(names[i])) {
                throw new IllegalStateException(Messages.CAR_NAME_DUPLICATE_ERR);
            }
        }
    }

    public static void validateRepeatNumber(int repeatNumber) {
        if(repeatNumber <= 0) {
            throw new IllegalArgumentException(Messages.REPEAT_NUMBER_VALUE_ERR);
        }
    }
}
