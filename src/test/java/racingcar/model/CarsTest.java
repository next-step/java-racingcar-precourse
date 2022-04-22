package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class CarsTest {

    static MockedStatic<Randoms> mock;

    @BeforeAll
    static void beforeAll() {
        mock = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        mock.close();
    }

    @DisplayName("우승 자동차 반환 (단독)")
    @Test
    void getHeadCars_함수_테스트_단독_우승() throws Exception {
        //given
        Car car1 = getMockCar("car1", 5);
        Car car2 = getMockCar("car2", 3);
        Car car3 = getMockCar("car3", 1);

        List<Car> mockCars = Arrays.asList(car1, car2, car3);

        Cars cars = getMockCars(mockCars);

        //when
        List<Car> headCars = cars.getHeadCars();

        //then
        assertThat(headCars.size()).isEqualTo(1);
        assertThat(headCars).contains(car1);
    }

    @DisplayName("우승 자동차 반환 (공동)")
    @Test
    void getHeadCars_함수_테스트_공동_우승() throws Exception {
        //given
        Car car1 = getMockCar("car1", 2);
        Car car2 = getMockCar("car2", 5);
        Car car3 = getMockCar("car3", 5);

        List<Car> mockCars = Arrays.asList(car1, car2, car3);

        Cars cars = getMockCars(mockCars);

        //when
        List<Car> headCars = cars.getHeadCars();

        //then
        assertThat(headCars.size()).isEqualTo(2);
        assertThat(headCars).contains(car2);
        assertThat(headCars).contains(car3);
    }

    private Car getMockCar(String name, int distance) throws Exception {
        Car car = new Car("car");

        Field nameField = car.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(car, new Name(name));

        Field distanceField = car.getClass().getDeclaredField("distance");
        distanceField.setAccessible(true);
        distanceField.set(car, new Distance(distance));

        return car;
    }

    private Cars getMockCars(List<Car> mockCars) throws Exception {
        Cars cars = new Cars("");

        Field carsField = cars.getClass().getDeclaredField("cars");
        carsField.setAccessible(true);
        carsField.set(cars, mockCars);

        return cars;
    }


}