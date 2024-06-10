import java.util.ArrayList;
import java.util.List;

public class Winner {
    static List<Car> winners = new ArrayList<>();

    public static List<Car> getWinners(List<Car> cars){
        int maxlocate=0;

        for (Car car : cars){
            if(car.getCurLocation()>maxlocate){
                maxlocate = car.getCurLocation();
            }
        }
        for (Car car : cars){
            if(car.getCurLocation()==maxlocate){
                winners.add(car);
            }
        }
        return winners;
    }

    public static void printWinners(){
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        System.out.println("최종 우승자는 : "+String.join(", ", winnerNames));
    }


}
