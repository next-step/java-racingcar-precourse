import java.util.List;

public class ResultView {
    public static void printRaceResult(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners){
        String result = String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new));
        System.out.println("최종 우승자 : "+ result);
    }
}
