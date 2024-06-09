import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game g = new Game();
        List<String> carNames =  g.getCarNames();
        List<Car> cars = g.makeCars(carNames);

        int tryNum= g.getTryNum();
        System.out.println("실행 결과");
        for (int i=0; i<tryNum ; i++) {
            for(Car car: cars) {
                car.move();
                car.printState();
            }
            System.out.println();
        }

        List<Car> winners= g.findWinners(cars);
        g.printWinners(winners);

    }
}
