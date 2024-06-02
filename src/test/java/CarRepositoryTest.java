import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import model.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRepositoryTest {
    CarRepository carRepository;
    @BeforeEach
    void init(){
        carRepository =new CarRepository();
    }
    @Test
    @DisplayName("차가 잘 들어가는지 Test")
    void addCarTest(){
        Car car=new Car("Test");
        carRepository.addCar(car);
        assertThat(carRepository.getCars()).contains(car);
    }
    @Test
    @DisplayName("모든 차 잘 반환하는지 Test")
    void getCarsTest(){
        Car car1=new Car("Test1");
        Car car2=new Car("Test2");
        carRepository.addCar(car1);
        carRepository.addCar(car2);

        assertThat(carRepository.getCars()).containsExactly(car1,car2);
    }
}
