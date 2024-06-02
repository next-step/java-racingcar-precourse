package View;
import Model.Car;
import java.util.List;

public class Output {
    public static void printCarStatus(List<Car> cars){
        for(int i =0; i<cars.size(); i++){
            System.out.println(cars.get(i).getName() + " : "+ cars.get(i).getPosition());
        }
        System.out.println();
    }

    public static void printRacingWinner(List<String> winner){
        System.out.println("최종 우승자 : "+String.join(",", winner));
    }
}
