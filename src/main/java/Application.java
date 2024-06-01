import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {

    public void start(){
        String[] carNames = InputView.getCarNames();
        Car.CarDup(Arrays.asList(carNames));
        int attempts = InputView.getAttempts();
        Race race = new Race(Arrays.asList(carNames), attempts);
        List<Car> cars = race.getCars();
        System.out.println("\n실행 결과");
        Random random = new Random();
        for(int i=0; i<attempts; i++){
            for(Car car : cars){
                car.move(random.nextInt(10));
            }
            ResultView.printRaceResult(cars);
        }
        ResultView.printWinners(race.getWinners());
    }
    public static void main(String[] args) {
        try {
            Application application = new Application();
            application.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
