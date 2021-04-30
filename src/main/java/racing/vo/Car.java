package racing.vo;

import java.math.BigDecimal;

public class Car {
    private CarName carName;
    private int position = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getCarName(){
        return this.carName.getValue();
    }

}
