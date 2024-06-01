public class Car {
    private String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position="";
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return this.position;
    }

    public void forward() {
        this.position += "-";
    }
}
