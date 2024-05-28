import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class Game {
    private ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void makeCars(String str){
        String[] strArr = str.split(",");
        for (String s : strArr) {
            cars.add(new Car(s));
        }
    }
    public void racing(int count){
        for (int i = 0; i < count; i++){
            for (Car car : cars) {
                car.makeDecision();
                System.out.println(car);
            }
            System.out.println();
        }
    }
    public String[] chooseWinner(){
        ArrayList<String> winner = new ArrayList<>();
        int[] length = new int[cars.size()];
        for(int i = 0; i < cars.size(); i++){
            length[i] = cars.get(i).getName().length();
        }
        int max = Arrays.stream(length).max().getAsInt();
        for (Car car : cars) {
            if(car.getRoute().length() == max)
                winner.add(car.getName());
        }
        return winner.toArray(new String[winner.size()]);
    }
}
