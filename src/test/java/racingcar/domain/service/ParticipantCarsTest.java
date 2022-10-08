package racingcar.domain.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.ParticipantCars;
import racingcar.utils.RandomNumberGenerator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static racingcar.utils.RacingCarConstants.MAX_RANDOM_NUM;
import static racingcar.utils.RacingCarConstants.MIN_RANDOM_NUM;

public class ParticipantCarsTest {
    private static MockedStatic<RandomNumberGenerator> randoms;
    private static MockedStatic.Verification verification = () -> RandomNumberGenerator.generateNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    private static OutputStream captor;
    private static PrintStream standardOut;

    @BeforeAll
    static void before() {
        randoms = mockStatic(RandomNumberGenerator.class);
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterAll
    public static void after() {
        randoms.close();
        System.setOut(standardOut);
        System.out.println(output());
    }

    private static String output() {
        return captor.toString().trim();
    }

    @DisplayName("입력받은 시도횟수만큼 수행하는지")
    @Test
    public void 입력받은_시도횟수만큼_수행_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("tico")));
        cars.add(new Car(new CarName("venue")));
        ParticipantCars participantCars = new ParticipantCars(cars);

        // when
        randoms.when(verification).thenReturn(1, 4);
        participantCars.moveParticipantCarsByInputCount(1);

        //then
        assertThat(output()).contains("tico : ", "venue : -");
    }

    @DisplayName("단독 우승자 출력 테스트")
    @Test
    public void 단독_우승자_출력_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("tico")));
        cars.add(new Car(new CarName("venue")));
        ParticipantCars participantCars = new ParticipantCars(cars);
        randoms.when(verification).thenReturn(1, 4);
        participantCars.moveParticipantCarsByInputCount(1);

        // when
        participantCars.printWinner();

        //then
        assertThat(output()).contains("최종 우승자 : venue");
    }

    @DisplayName("공동 우승자 출력 테스트")
    @Test
    public void 공동_우승자_출력_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("tico")));
        cars.add(new Car(new CarName("venue")));
        cars.add(new Car(new CarName("tobi")));
        ParticipantCars participantCars = new ParticipantCars(cars);
        randoms.when(verification).thenReturn(1, 4, 4);
        participantCars.moveParticipantCarsByInputCount(1);

        // when
        participantCars.printWinner();

        //then
        assertThat(output()).contains("최종 우승자 : venue, tobi");
    }
}
