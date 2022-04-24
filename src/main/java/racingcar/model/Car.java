package racingcar.model;

import racingcar.util.Utils;

public class Car {
    private String name;
    private String lapInfo;

    public Car(String name) {
        this.lapInfo = "";
        this.name = name;
    }

    public static Car withName(String name) {

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 길이는 5 이하");
        }

        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public String getLapInfo() {
        return lapInfo;
    }

    public void update(){

        if(Utils.getRandom(0, 9)>3){
            lapInfo += "-";
        }
    }

    public String getLaps(){
        return getName() + " : " + getLapInfo();
    }
}