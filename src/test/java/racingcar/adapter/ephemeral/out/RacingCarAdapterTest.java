package racingcar.adapter.ephemeral.out;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;

class RacingCarAdapterTest {

    @ParameterizedTest
    @ValueSource(strings = {"ab,abc", "a,b"})
    void 생성한_자동차_반환_테스트(String input) {

        List<RacingCar> carList = Arrays.stream(input.split(","))
                .map(name -> new RacingCar(new RacingCarName(name)))
                .collect(Collectors.toList());

        RacingCars expectedData = new RacingCars(carList);

        RacingCarAdapter adapter = new RacingCarAdapter();
        adapter.save(expectedData);

        assertEquals(2, adapter.getRacingCars().getSortedRacingCars().size());
    }

}