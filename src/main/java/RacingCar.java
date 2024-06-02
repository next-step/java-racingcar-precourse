public class RacingCar implements Comparable{
    Integer now = 0;
    String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move(){
        now += 1;
    }

    public Integer getNow() {
        return now;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        RacingCar r = (RacingCar) o;
        return r.getNow().compareTo(this.getNow());
    }
}
