package model;

public class Car {
    private final String name;
    private int position;
    private Integer fixedRandomNumber = null;

    /**
     * 자동차 이름을 받아 생성하는 생성자
     * @param name 자동차 이름
     */
    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    /**
     * 테스트용으로 랜덤 숫자를 고정하는 메서드
     * @param number 고정할 랜덤 숫자
     * @see CarTest#move(int)
     */
    public void setFixedRandomNumber(int number) {
        this.fixedRandomNumber = number;
    }

    /**
     * 랜덤 숫자를 생성하여 이동하는 메서드
     * 랜덤 숫자가 4 이상일 때 이동
     */
    public void move() {
        if (getRandomNumber() >= 4) {
            this.position++;
        }
    }

    /**
     * 랜덤 숫자를 생성하는 메서드
     * 테스트용으로 랜덤 숫자를 고정했을 경우 고정된 숫자를 반환
     * @return 생성된 랜덤 숫자
     * @see Car#move()
     * @see CarTest#move(int)
     */
    protected int getRandomNumber() {
        if (fixedRandomNumber != null) {
            return fixedRandomNumber;
        }
        return (int) (Math.random() * 10);
    }

    /**
     * 현재 자동차의 이름을 반환하는 메서드
     * @return 자동차 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 현재 자동차의 위치를 반환하는 메서드
     * @return 자동차 위치
     */
    public int getPosition() {
        return position;
    }
}
