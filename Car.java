public class Car {
    private Name name = new Name();
    private Position position = new Position();

    public Car(String name) {
        this.name.setValue(name);
    }

    public String getName(){
        return name.value();
    }

    public int getPosition(){
        return position.value();
    }

}
