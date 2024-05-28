import java.util.ArrayList;

public class Game {
    private ArrayList<Car> Cars = new ArrayList<>();
    public void makeCars(String str){
        String[] strArr = str.split(",");
        for (String s : strArr) {
            Cars.add(new Car(s));
        }
    }
}
