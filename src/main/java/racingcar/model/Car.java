package racingcar.model;

public class Car {
    private String name;
    private int movement;

    public Car(String name){
        validateNameLength(name);
        this.name = name;
        this.movement = 0;
    }

    public void validateNameLength(String name){
        if(name.length() >= 6) throw new IllegalArgumentException("[ERROR] name length cannot over the 6 length");
        if(name.length() <= 0) throw new IllegalArgumentException("[ERROR] name length must over 0 length");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (movement != car.movement) return false;
        return name != null ? name.equals(car.name) : car.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + movement;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", movement=" + movement +
                '}';
    }
}
