package racinggame;

import nextstep.utils.Randoms;

public class Car {

    private String name;
    private int place;

    public Car(String name) {
        if (name.length()>5) throw new IllegalArgumentException("[ERROR]");
        this.name = name;
        this.place= 0;
    }

    public Car(String name, int place) {
        if (name.length()>5) throw new IllegalArgumentException("[ERROR]");
        this.name = name;
        this.place= place;
    }

    public void moveCar() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if ( randomNumber >= 4)        place++;
    }

    public String getName() {
        return name;
    }
    public int getPlace() {
        return place;
    }
    public String getPlaceToString() {
        String placeString = "";
        placeString = this.name + " : ";
        for (int i = 0; i < place; i++) {
            placeString = placeString + "-";
        }
        return placeString;
    }

}
