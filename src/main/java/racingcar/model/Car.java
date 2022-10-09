package racingcar.model;

public class Car {

    private static final String road = "-";
    private String name;
    private StringBuilder record;
    private Integer goCount;

    public Car(String carName) {
        name = carName;
        record = new StringBuilder();
        goCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setGoCount(Integer goCount) {
        this.goCount = goCount;
    }

    public Integer getGoCount() {
        return goCount;
    }

    public void goRoad() {
        record.append(road);
        goCount++;
    }

    public void printRecord() {
        System.out.println(name + " : " + record.toString());
    }
}
