package racingcar;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public String getName() {
        return name;
    }

    public Car (String name){
        validNameLength(name);
        this.name = name;
    }

    private void validNameLength(String name){

        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("[ERROR] 이름은 5자리를 넘을 수 없습니다.");
        }

    }

}
