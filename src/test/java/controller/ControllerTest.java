package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import model.Car;
import org.junit.jupiter.api.Test;

class ControllerTest {

    @Test
    void areCarNamesValid() {
        String[][] carNames = {
            {"a"},                              // 1번 케이스
            {"a", "b", "c"},                    // 2번 케이스
            {"a", "b", "c", "d", "e", "f"},     // 3번 케이스
            {"a", "a", "b", "b", "c", "c"},     // 4번 케이스
            {"123456"},                         // 5번 케이스
            {"123456", "123456"},               // 6번 케이스
            {"123", ""},                        // 7번 케이스
            {"", ""},                           // 8번 케이스
            {},                                 // 9번 케이스
            {""}                                // 10번 케이스
        };
        boolean[] results = {
            true,                               // 1번 케이스
            true,                               // 2번 케이스
            true,                               // 3번 케이스
            false,                              // 4번 케이스
            false,                              // 5번 케이스
            false,                              // 6번 케이스
            false,                              // 7번 케이스
            false,                              // 8번 케이스
            false,                              // 9번 케이스
            false                               // 10번 케이스
        };
        Controller controller = Controller.getInstance();
        for (int i = 0; i < carNames.length; ++i) {
            assertEquals(controller.areCarNamesValid(carNames[i]), results[i]);
        }
    }

    @Test
    void isRepeatCountValid() {
        String[] repeatCounts = {
            "1",                                // 1번 케이스
            "100",                              // 2번 케이스
            "0",                                // 3번 케이스
            "-1",                               // 4번 케이스
            "-100",                             // 5번 케이스
            "abc",                              // 6번 케이스
            "",                                 // 7번 케이스
            "abc 123",                          // 8번 케이스
            "123 ",                             // 9번 케이스
            "123 123"                           // 10번 케이스
        };
        boolean[] results = {
            true,                               // 1번 케이스
            true,                               // 2번 케이스
            true,                               // 3번 케이스
            false,                              // 4번 케이스
            false,                              // 5번 케이스
            false,                              // 6번 케이스
            false,                              // 7번 케이스
            false,                              // 8번 케이스
            false,                              // 9번 케이스
            false                               // 10번 케이스
        };
        Controller controller = Controller.getInstance();
        for (int i = 0; i < repeatCounts.length; ++i) {
            assertEquals(controller.isRepeatCountValid(repeatCounts[i]), results[i]);
        }
    }

    @Test
    void createCars() {
        String[][] carNames = {
            {"a"},                              // 1번 케이스
            {"a", "b"},                         // 2번 케이스
            {"a", "b", "c"},                    // 3번 케이스
            {"a", "b", "c", "d"},               // 4번 케이스
            {"a", "b", "c", "d", "e"},          // 5번 케이스
        };
        Controller controller = Controller.getInstance();
        for (String[] carName : carNames) {
            controller.createCars(carName);
            ArrayList<Car> cars = controller.getGameModel().getCars();
            for (int i = 0; i < cars.size(); ++i) {
                assertEquals(cars.get(i).getName(), carName[i]);
            }
            controller.clear();
        }
    }

    @Test
    void setRepeatCount() {
        int[] repeatCounts = {
            0,                                  // 1번 케이스
            1,                                  // 2번 케이스
            2,                                  // 3번 케이스
            3,                                  // 4번 케이스
            4                                   // 5번 케이스
        };
        Controller controller = Controller.getInstance();
        for (int repeatCount : repeatCounts) {
            controller.setRepeatCount(repeatCount);
            assertEquals(controller.getGameModel().getRepeatCount(), repeatCount);
            controller.clear();
        }
    }


    @Test
    void getWinners() {
        Car[][] cars = {
            {new Car("a", 1)},
            // 1번 케이스
            {new Car("a", 1), new Car("b", 1)},                                  // 2번 케이스
            {new Car("a", 2), new Car("b", 1)},                                  // 3번 케이스
            {new Car("a", 1), new Car("b", 2)},                                  // 4번 케이스
            {new Car("a", 1), new Car("b", 2), new Car("c", 3)},     // 5번 케이스
            {new Car("a", 3), new Car("b", 2), new Car("c", 1)},     // 6번 케이스
            {new Car("a", 3), new Car("b", 1), new Car("c", 2)},     // 7번 케이스
            {new Car("a", 3), new Car("b", 1), new Car("c", 1)},     // 8번 케이스
            {new Car("a", 1), new Car("b", 3), new Car("c", 3)},     // 9번 케이스
            {new Car("a", 3), new Car("b", 3), new Car("c", 3)},     // 10번 케이스
        };
        String[][] result = {
            {"a"},                  // 1번 케이스
            {"a", "b"},             // 2번 케이스
            {"a"},                  // 3번 케이스
            {"b"},                  // 4번 케이스
            {"c"},                  // 5번 케이스
            {"a"},                  // 6번 케이스
            {"a"},                  // 7번 케이스
            {"a"},                  // 8번 케이스
            {"b", "c"},             // 9번 케이스
            {"a", "b", "c"}         // 10번 케이스
        };
        Controller controller = Controller.getInstance();
        for (int i = 0; i < cars.length; ++i) {
            for (Car car : cars[i]) {
                controller.getGameModel().addCar(car);
            }
            String[] winners = controller.getWinners().toArray(new String[0]);
            assertEquals(winners.length, result[i].length);
            for (int j = 0; j < winners.length; ++j) {
                assertEquals(winners[j], result[i][j]);
            }
            controller.clear();
        }
    }
}