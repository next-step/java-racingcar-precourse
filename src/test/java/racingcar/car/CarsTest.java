package racingcar.car;

import org.junit.jupiter.api.*;
import racingcar.common.exception.ErrorMessage;
import racingcar.common.factory.RandomFactory;
import racingcar.race.Race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init(){
        cars = new Cars();
    }

    @Test
    @DisplayName("자동차 리스트 생성")
    void createCars(){
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차르 추가하면 내부 리스트에 저장")
    void addCars(){
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        cars.addCars(car1);
        cars.addCars(car2);
        cars.addCars(car3);

        assertThat(cars.carList()).contains(car1, car2, car3);
    }

    @Test
    @DisplayName("Cars 내부 자동차 상태 확인 메서드 테스트")
    void checkCarsStatus(){
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        cars.addCars(car1);
        cars.addCars(car2);
        cars.addCars(car3);

        assertThat(cars.getNames()).containsExactly("1", "2", "3");
        assertThat(cars.getPositions()).containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("동일한 객체가 리스트에 들어오면 에러발생")
    void canNotAddSameCar(){
        Car car1 = new Car("car1");

        cars.addCars(car1);

        assertThatThrownBy(() -> {
            cars.addCars(car1);
        }).hasMessageContaining(ErrorMessage.CAN_NOT_ADD_SAME_CAR.getMessage());
    }

    @Test
    @DisplayName("리스트 출력시 복사해서 가져온다.")
    void getListIsCopyObject(){
        Car car = new Car("car1");
        Car car2 = new Car("car2");
        cars.addCars(car);

        cars.carList().add(car2);

        assertThat(cars.carList().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤수 숫자 4 이상일때 자동차 전진")
    void moveCarIfRandomNumberOver4(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        RandomFactory factoryReturnOver4 = new RandomFactory() {
            @Override
            public int makeRandomNumber() {
                return 5;
            }
        };

        cars.addCars(car1);
        cars.addCars(car2);

        assertThat(cars.getPositions()).containsExactly(0, 0);
        cars.moveCars(factoryReturnOver4);
        assertThat(cars.getPositions()).containsExactly(1, 1);
    }

    @Test
    @DisplayName("랜덤수 숫자 4 미만일때 자동차 전진 안함.")
    void moveCarIfRandomNumberUnder4(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        RandomFactory factoryReturnUnder4 = new RandomFactory() {
            @Override
            public int makeRandomNumber() {
                return 3;
            }
        };

        cars.addCars(car1);
        cars.addCars(car2);

        assertThat(cars.getPositions()).containsExactly(0, 0);
        cars.moveCars(factoryReturnUnder4);
        assertThat(cars.getPositions()).containsExactly(0, 0);
    }

    @Test
    @DisplayName("winner 선정 (현재 포지션이 가장 큰사람 이름 출력)")
    void getWinner(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        moveCar(car2, 3);
        Car car3 = new Car("car3");

        cars.addCars(car1);
        cars.addCars(car2);
        cars.addCars(car3);

        assertThat(cars.winner()).isEqualTo("car2");
    }

    @Test
    @DisplayName("winner 선정 (여려명일때 여려명 출력)")
    void getWinners(){
        Car car1 = new Car("car1");
        moveCar(car1, 2);
        Car car2 = new Car("car2");
        moveCar(car2, 3);
        Car car3 = new Car("car3");
        moveCar(car3, 3);

        cars.addCars(car1);
        cars.addCars(car2);
        cars.addCars(car3);

        assertThat(cars.winner()).isEqualTo("car2,car3");
    }
    private void moveCar(Car car,int move){
        while(move-- > 0){
            car.move();
        }
    }
}