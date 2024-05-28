import java.util.ArrayList;

public class Game {
    private ArrayList<Car> Cars = new ArrayList<>();
    public void makeCars(String str){
        String[] strArr = str.split(",");
        for (String s : strArr) {
            Cars.add(new Car(s));
        }
    }
    public void racing(int count){
        for (int i = 0; i < count; i++){
            for (Car car : Cars) {
                car.makeDecision();
                System.out.println(car);
            }
            System.out.println();
        }
    }
}
