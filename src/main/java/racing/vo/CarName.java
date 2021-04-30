package racing.vo;

public class CarName {

    private final int CAR_NAME_LENGTH = 5;
    private String carName;

    public CarName(String carName){
        if(carName.length()>CAR_NAME_LENGTH){
            throw new IllegalArgumentException("");
        }
        this.carName = carName;
    }

    public String getValue(){
        return this.carName;
    }

}
