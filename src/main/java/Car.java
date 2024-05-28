public class Car {
    private String name;
    private String route;

    public Car(String name) {
        this.name = name;
        this.route = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}