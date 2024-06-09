import model.Car;
import model.Race;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class RaceTest {
    @Test
    @DisplayName("Race 생성자가 정상적으로 이름에 맞는 Car 객체를 생성하는가?")
    void initialize_Car() {
        //given
        List<String> carNames = new ArrayList<>();
        carNames.add("abc");
        carNames.add("def");
        carNames.add("ghi");
        //when
        Race race = new Race(carNames, 5);
        //then
        assertThat(race.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("우승자를 정확하게 출력하는가?")
    void return_winner_list() {
        //given
        List<String> carNames = new ArrayList<>();
        carNames.add("abc");
        carNames.add("def");
        carNames.add("ghi");
        Race race = new Race(carNames, 5);
        //when
        for (int i = 0; i < 5; i++) {
            race.round();
        }
        List<String> winner;
        winner = race.checkWinner();
        String maxName = "";
        int max = 0;
        for (Car car : race.getCars()){
            if(car.getPosition() >= max){
                max = car.getPosition();
                maxName= car.getName();
            }
        }
        // then
        assertThat(winner).contains(maxName);
    }
}
