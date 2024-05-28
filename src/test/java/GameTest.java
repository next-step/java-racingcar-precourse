import static org.assertj.core.api.Assertions.assertThatThrownBy;

import controller.GameController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
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
    void randomTest() {

        for (int i=0; i<50;i++) {
            Car A = cars.getCar(0);
            A.setCount(0);
            int beforeCount = A.getCount();
            int randomNumber = RandomGenerator.createRandomNumber();

            gameService.checkMoveOrStay(randomNumber, A);

            if(randomNumber < 4) {
                Assertions.assertThat(A.getCount()).isEqualTo(beforeCount);
            } else {
                Assertions.assertThat(A.getCount()).isEqualTo(beforeCount+1);
            }
        }
    }

    @Test
    void printCars() {
        int trial  = 5;
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

        A.setCount(4); B.setCount(3); C.setCount(2);
        OutputView.printWinners(cars.getCars(), 4);

        A.setCount(4); B.setCount(4); C.setCount(3);
        OutputView.printWinners(cars.getCars(), 4);

        A.setCount(4); B.setCount(4); C.setCount(4);
        OutputView.printWinners(cars.getCars(), 4);
    }

}
