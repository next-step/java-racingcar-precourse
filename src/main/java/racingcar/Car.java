package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int MOVING_FORWARD = 4;

    private CarName name;
    private int position;

    Car(String name){
        this.name = new CarName(name);
        this.position = 0;
    }

    void moveOrStop(){
        if(createRandomNumber() >= MOVING_FORWARD){
            move();
        }
    }

    void printCarNameAndPosition(){
        String carName = this.name.getName();
        int position = this.position;

        System.out.print(carName + " : ");
        for(int idx = 0; idx < position; idx++){
            System.out.print("-");
        }
        System.out.println();
    }

    void move(){
        this.position += 1;
    }

    int createRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        return randomNumber;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.getName();
    }
}
