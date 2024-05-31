import static org.junit.jupiter.api.Assertions.*;

import DTO.Car;
import Service.WinnersService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersServiceTest {

    WinnersService winner = new WinnersService();

    @Test
    @DisplayName("가장 멀리간 자동차 이름 array로 반환")
    void printWinner() {
//        given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));

//        when
//        test1,test2가 3칸씩 나가고, test3은 0칸 나아감
        cars.get(0).plusNum();
        cars.get(0).plusNum();
        cars.get(0).plusNum();

        cars.get(1).plusNum();
        cars.get(1).plusNum();
        cars.get(1).plusNum();

//        then
        String[] answer = {"test1", "test2"};
        assertArrayEquals(winner.getWinner(cars), answer);
    }
}