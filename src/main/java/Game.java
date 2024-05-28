import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

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
    public String[] chooseWinner(){
        ArrayList<String> winner = new ArrayList<>();
        int[] length = new int[Cars.size()];
        for(int i = 0; i < Cars.size(); i++){
            length[i] = Cars.get(i).getName().length();
        }
        int max = Arrays.stream(length).max().getAsInt();
        for (Car car : Cars) {
            if(car.getName().length() == max)
                winner.add(car.getName());
        }
        return winner.toArray(new String[0]);
    }
}
