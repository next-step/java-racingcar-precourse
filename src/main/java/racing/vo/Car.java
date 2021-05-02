package racing.vo;

public class Car implements Comparable<Car>{
    private CarName carName;
    private int carPosition;
    private StringBuilder positionText;
    private static final int maxCount = 9;

    public Car(String name) {
        this.carName = new CarName(name);
        this.positionText = new StringBuilder();
    }

    public String getCarName(){
        return this.carName.getValue();
    }

    public int randomSetPosition(){
        int randomNo =  (int)(Math.random()*maxCount);
        if(randomNo>=4){
            carPosition++;
            positionText.append("-");
        }
        return randomNo;
    }

    public int getPosition() {
        return carPosition;
    }
    public StringBuilder getPositionText() {
        return positionText;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition()-this.getPosition();
    }
}
