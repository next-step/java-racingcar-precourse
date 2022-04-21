package racingcar.domain;

public class CarName {
    private final int MAX_NAME_SIZE = 5;
    private String name ;

    public CarName(String name){
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_SIZE)
            throw new IllegalArgumentException();
    }

    public String getName(){
        return this.name;
    }
}
