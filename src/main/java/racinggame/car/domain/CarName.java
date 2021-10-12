package racinggame.car.domain;

import racinggame.car.utils.CarsUtil;

public class CarName {
    String name;

    public CarName(String inputName) {
        try{
            this.name = CarsUtil.CarName(inputName.trim());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }
}
