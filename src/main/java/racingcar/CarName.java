package racingcar;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        int length = name.length();
        if(length < MIN_LENGTH || length > MAX_LENGTH){
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 1 ~ 5자로 작성해주세요");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
