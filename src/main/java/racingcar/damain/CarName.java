package racingcar.damain;

import racingcar.error.ErrorMessage;
import racingcar.utils.ScannerUtil;

public class CarName {

    private String name;

    public CarName(String name) {
        boolean isValidFail = false;
        while (!isValidFail) {
            try {
                isValidFail = validation(name);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                name = ScannerUtil.inputChangeCarName(name);
                isValidFail = false;
            }
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean validation(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException(ErrorMessage.CarNameBussinessError.getErrorMsg());
        return true;
    }
}
