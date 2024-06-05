package model;

import util.IRandomNumberGenerator;
import util.DefaultRandomNumberGenerator;

/**
 * 자동차 객체 클래스
 *
 * @author Wooseok Jang
 */
public class Car {
    private String name;
    private int position;
    private IRandomNumberGenerator IRandomNumberGenerator;

    /**
     * 프로덕션용 생성자
     * 테스팅용 생성자에 랜덤값을 불러오는 RandomNumberGenerator 객체를 생성하여 input
     *
     * @param name 자동차 이름
     */
    public Car(String name) {
        this(name, new DefaultRandomNumberGenerator());
    }

    /**
     * 테스팅용 생성자
     *
     * @param name 자동차 이름이 5자 이하일 때만 적용
     * @param IRandomNumberGenerator 프로덕션용에서 호출될 때는 진짜 랜덤값을 적용하는 generator, 테스팅할 땐 fixed 값을 적용하는 generator
     *
     * @throws IllegalArgumentException 자동차 이름이 5자 이하가 아닌 경우 발생
     */
    public Car(String name, IRandomNumberGenerator IRandomNumberGenerator) {
        if(name == null || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
        this.IRandomNumberGenerator = IRandomNumberGenerator;
    }

    /**
     * 자동차를 움직이는 메서드
     * 랜덤값이 4 이상일 때만 전진
     */
    public void move() {
        if(IRandomNumberGenerator.generate() >= 4) {
            position++;
        }
    }

    /**
     * position을 초기화하는 메서드
     */
    public void resetPosition() {
        position = 0;
    }

    public String getName() { return name; }

    public int getPosition() { return position; }
}
