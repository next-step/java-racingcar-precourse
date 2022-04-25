package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private Position position;
    private CarName name;

    public Car(String name) {
        this.position = new Position();
        this.name = new CarName(name);
    }

    public void tryToGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position.go();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }
    public String getName() {return name.getName();}


}
