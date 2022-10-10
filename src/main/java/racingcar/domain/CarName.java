package racingcar.domain;

public class CarName {
    String carName;

    public CarName(String carName) {
        validation(carName);
        this.carName = carName;
    }
    public void validation(String carName){
        if(carName.length() > 5)
            throw new IllegalArgumentException(carName+" 자동차 이름이 6자리 이상입니다. 5자리 이하로 입력해주세요.");
    }

    public String getCarName() {
        return carName;
    }
}
