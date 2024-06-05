package model;

import util.ITestRandomNumberGenerator;
import util.RandomNumberGenerator;

public class Car {
    private String name;
    private int position;
    private ITestRandomNumberGenerator randomNumberGenerator;

    // 프로덕션용 생성자
    public Car(String name) {
        this(name, new RandomNumberGenerator());
    }

    // 테스트용 생성자
    public Car(String name, ITestRandomNumberGenerator randomNumberGenerator) {
        if(name == null || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getName() { return name; }

    public int getPosition() { return position; }
}
