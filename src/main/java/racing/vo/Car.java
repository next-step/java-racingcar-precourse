package racing.vo;

public class Car {
    private CarName carName;
    private int carPosition;
    private static final int maxCount = 9;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getCarName(){
        return this.carName.getValue();
    }

    public int randomSetPosition(){
        int randomNo =  (int)(Math.random()*maxCount);
        if(randomNo>=4){
            carPosition++;
        }
        return randomNo;
    }

    public int getPosition() {
        return carPosition;
    }
}
