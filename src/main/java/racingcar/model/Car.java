package racingcar.model;


public class Car {
    private static final int MOVE_BOUNDARY = 4;
    private static final String DISTANCE_EXPRESSION = "-";

    private int distance = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot(int number) {
        if (number >= Car.MOVE_BOUNDARY)
            distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getDistanceByString() {
        StringBuffer distanceResult = new StringBuffer();
        for (int i = 0; i < distance; i++)
            distanceResult.append(DISTANCE_EXPRESSION);
        return distanceResult.toString();
    }

    public String getName() {
        return name;
    }
}
