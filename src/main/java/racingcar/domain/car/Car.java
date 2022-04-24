package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private static final int ZERO = 0;
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int MOVE_NUMBER = 4;
    private static final String DASH = "-";
    private final CarName carName;
    private int position = ZERO;

    /**
     * 생성자
     *
     * @param carName 이름
     */
    private Car(CarName carName) {
        this.carName = carName;
    }

    /**
     * Car 객체 생성 함수
     *
     * @param name 이름
     * @return car
     */
    static public Car of(CarName name) {
        return new Car(name);
    }

    /**
     * position 받기
     *
     * @return position
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * 차 이름 받기
     *
     * @return 이름
     */
    public String getCarName() {
        return this.carName.getCarName();
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - getPosition();
    }


    /**
     * 랜덤 숫자에 따라 차 움직임
     */
    public void move() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
        if (isMove(randomNumber)) {
            this.position++;
        }
    }

    /**
     * 4이상 일때 움직임 결정
     *
     * @param randomNumber 랜덤 숫자
     * @return 움직일지 여부
     */
    private boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_NUMBER;
    }

    /**
     * 대시로 position 표시
     *
     * @return position
     */
    public String dashPosition() {
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < position; i++) {
            dash.append(DASH);
        }
        return dash.toString();
    }
}
