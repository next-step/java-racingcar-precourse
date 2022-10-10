package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class RacingSystemTest {

    private RacingSystem racingSystem;

    @BeforeEach
    public void setUp() {
        racingSystem = new RacingSystem();
    }

    @Test
    public void 쉼표로_이름_분리() {
        //given
        String name = "pobi,crong,honux";
        //when
        List<Car> cars = racingSystem.addCarsName(name);
        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("crong");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("honux");

    }

    @Test
    public void 랜덤_숫자_생성_검증() {
        //when
        int randomNo = racingSystem.getRandomNo();
        //then
        Assertions.assertThat(randomNo).isNotNull();
    }

    @Test
    @DisplayName("1~9사이의 숫자가 생성되는지 유효성 검증")
    public void 랜덤_숫자_유효성_검증() {
        //given
        int randomNo = racingSystem.getRandomNo();
        //when
        boolean result = randomNo >= 0 && randomNo <= 9 ? true : false;
        //then
        Assertions.assertThat(result).isTrue();

    }

    @Test
    public void 종료지점_도착_검증(){
        //given
        String finalPosition = "3";
        String carsName = "choi,pobi";
        racingSystem = new RacingSystem(carsName, finalPosition);

        racingSystem.getCars().get(0).move(4);
        racingSystem.getCars().get(0).move(5);
        racingSystem.getCars().get(0).move(3);
        racingSystem.getCars().get(0).move(4);

        racingSystem.getCars().get(1).move(4);
        racingSystem.getCars().get(1).move(1);
        racingSystem.getCars().get(1).move(2);
        racingSystem.getCars().get(1).move(4);

        //when, then
        Assertions.assertThat(racingSystem.isVictoryCar(3,racingSystem.getCars().get(0).getPosition())).isTrue();
        Assertions.assertThat(racingSystem.isVictoryCar(3,racingSystem.getCars().get(1).getPosition())).isFalse();
    }

    @Test
    public void 단독우승자_결과_검증(){
        //given
        String finalPosition = "3";
        String carsName = "choi,pobi";

        racingSystem = new RacingSystem(carsName, finalPosition);

        racingSystem.getCars().get(0).move(4);
        racingSystem.getCars().get(0).move(5);
        racingSystem.getCars().get(0).move(3);

        racingSystem.getCars().get(1).move(4);
        racingSystem.getCars().get(1).move(1);
        racingSystem.getCars().get(1).move(2);

        //when
        String result = racingSystem.getVictoryCars(racingSystem.getCars());

        //then
        Assertions.assertThat(result).isEqualTo("choi");

    }

    @Test
    public void 공동우승자_결과_검증(){
        //given
        String finalPosition = "2";
        String carsName = "choi,pobi";
        racingSystem = new RacingSystem(carsName, finalPosition);

        racingSystem.getCars().get(0).move(4);
        racingSystem.getCars().get(0).move(3);
        racingSystem.getCars().get(1).move(4);
        racingSystem.getCars().get(1).move(3);

        List<Car> cars = racingSystem.getCars();
        //when
        String result = racingSystem.getVictoryCars(cars);

        //then
        Assertions.assertThat(result).isEqualTo("choi, pobi");
    }

    @Test
    public void 레이싱_결과값_검증(){
        //given
        String cars = "choi,crong,honux";
        //when
        racingSystem = new RacingSystem(cars,"3");
        racingSystem.racingCar(racingSystem.getCars().get(0), "4");
        racingSystem.racingCar(racingSystem.getCars().get(1), "3");
        racingSystem.racingCar(racingSystem.getCars().get(2), "4");
        //then
        Assertions.assertThat(racingSystem.getCars().get(0).getPosition()).isEqualTo(1);
        Assertions.assertThat(racingSystem.getCars().get(1).getPosition()).isEqualTo(0);
        Assertions.assertThat(racingSystem.getCars().get(2).getPosition()).isEqualTo(1);
    }


}