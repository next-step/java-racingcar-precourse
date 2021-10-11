package racinggame.domain;

public class Car {
    private Name name;
    private Location location;

    public Car(String name, int location) {
        this(new Name(name), new Location(location));
    }

    public Car(Name name) {
        this.name = name;
        this.location = new Location(Location.START_LOCATION);
    }

    public Car(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void moveCar(CarMove carMove) {
        if (carMove == CarMove.MOVE) {
            location.moveLocation();
        }
    }

    public void printCurrentLocation() {
        System.out.print(name.getName() + " : ");
        for(int i = 0; i < location.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
