import java.util.Random;

public class Car {
    private String name;
    private String route;
    private int rand_number;

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
    public void makeDecision(){
        Random rand = new Random();
        rand_number = rand.nextInt(0, 10);
        if(rand_number >= 4)
            route += "-";
    }

    @Override
    public String toString() {
        return name + " : " + route;
    }
}