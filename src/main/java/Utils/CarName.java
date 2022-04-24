package Utils;

import java.util.Objects;
import org.junit.platform.commons.util.StringUtils;
import racingcar.view.ErrorMessageView;

public class CarName {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    private String carName;

    public CarName(String carName) {
        if(StringUtils.isBlank(carName)) {
            ErrorMessageView.throwErrorBlankCarName();
        }

        if(carName.length() > MAX_CAR_NAME_LENGTH) {
            ErrorMessageView.throwErrorMaxCarName();
        }
        this.carName = carName;
    }

    public String getCarName(){
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }
}
