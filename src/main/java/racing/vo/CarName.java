package racing.vo;

public class CarName {

    private final int MAX_CAR_NAME_LENGTH = 5;
    private final int MIN_CAR_NAME_LENGTH = 0;
    private String carName;

    public CarName(String carName){
        if(carName.length()>MAX_CAR_NAME_LENGTH
                ||carName.length()<=MIN_CAR_NAME_LENGTH){
            throw new IllegalArgumentException("각 이름의 길이는 5자이하 입력 해주시길 바랍니다.");
        }


        this.carName = carName;
    }

    public String getValue(){
        return this.carName;
    }

}
