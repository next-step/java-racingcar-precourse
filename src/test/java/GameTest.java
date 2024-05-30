import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import controller.GameController;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Cars;
import model.MaxMoved;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.GameService;
import util.RandomGenerator;
import view.OutputView;

public class GameTest {

    GameController gameController;
    GameService gameService;
    Cars cars;
    int trial  = 5;

    public GameTest() {
        this.gameController = new GameController();
        this.gameService = new GameService();
    }

    @BeforeEach
    void before() {
        Car A = new Car("aaa");
        Car B = new Car("bbb");
        Car C = new Car("ccc");

        List<Car> list = new ArrayList<>();
        list.add(A); list.add(B); list.add(C);

        cars = new Cars(list);
    }

    @Test
    void move() {
        //난수가 4 이상 9 이하일때 자동차는 전진한다.
        Car A = cars.getCar(0);
        int beforeCount1 = A.getCount();
        gameService.checkMoveOrStay(4, A);
        Assertions.assertThat(A.getCount()).isEqualTo(beforeCount1+1);

        Car B = cars.getCar(1);
        int beforeCount2 = B.getCount();
        gameService.checkMoveOrStay(9, B);
        Assertions.assertThat(B.getCount()).isEqualTo(beforeCount2+1);

    }

    @Test
    void stay() {
        //난수가 0 이상 3 이하일때 자동차는 전진하지 않는다.
        Car A = cars.getCar(0);
        int beforeCount1 = A.getCount();
        gameService.checkMoveOrStay(0, A);
        Assertions.assertThat(A.getCount()).isEqualTo(beforeCount1);

        Car B = cars.getCar(1);
        int beforeCount2 = B.getCount();
        gameService.checkMoveOrStay(3, B);
        Assertions.assertThat(B.getCount()).isEqualTo(beforeCount2);
    }

    @Test
    void randomGenerate() {
        for (int i=0; i<1000;i++) {
            assertThat(RandomGenerator.createRandomNumber()).isBetween(0,10);
        }
    }

    @Test
    void moveOrStay() {

        for (int i=0; i<100;i++) {
            Car A = cars.getCar(0);
            A.setCount(0);
            int beforeCount = A.getCount();
            int randomNumber = RandomGenerator.createRandomNumber();

            gameService.checkMoveOrStay(randomNumber, A);

            if(randomNumber < 4) { //난수 0~3: 전진 x
                Assertions.assertThat(A.getCount()).isEqualTo(beforeCount);
            } else { //난수 4~9: 전진 o
                Assertions.assertThat(A.getCount()).isEqualTo(beforeCount+1);
            }
        }
    }

    @Test
    void printCars() {

        for (int i = 0; i<trial;i++) {
            gameService.playOneTurn(cars.getCars());
        }
        for (Car car: cars.getCars()) {
            System.out.println(car.getName() +"은 " + car.getCount() + "칸 이동하였다.");
        }
        OutputView.printResult(cars.getCars());
    }

    @Test
    void printWinners() {
        Car A = cars.getCar(0);
        Car B = cars.getCar(1);
        Car C = cars.getCar(2);
        MaxMoved maxMoved = new MaxMoved(0);

        A.setCount(4); B.setCount(3); C.setCount(2);
        maxMoved.updateMaxNumber(cars.getCars());
        OutputView.printWinners(cars.getCars(), maxMoved.getMaxNumber());

        A.setCount(4); B.setCount(4); C.setCount(3);
        maxMoved.updateMaxNumber(cars.getCars());
        OutputView.printWinners(cars.getCars(), maxMoved.getMaxNumber());

        A.setCount(4); B.setCount(4); C.setCount(4);
        maxMoved.updateMaxNumber(cars.getCars());
        OutputView.printWinners(cars.getCars(), maxMoved.getMaxNumber());
    }

}
