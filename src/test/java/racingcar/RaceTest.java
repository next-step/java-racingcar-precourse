package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void 경기_생성() {
        String carNames = "pobi,brown";
        String turn = "1";
        UserInput userInput = new UserInput();
        userInput.setCarNames(carNames);
        userInput.setTurn(turn);

        assertThatNoException().isThrownBy(() -> Race.create(userInput));
    }

    @Test
    void 경기_생성_실패() {
        String carNames = "";
        String turn = "1";
        UserInput userInput = new UserInput();
        userInput.setCarNames(carNames);
        userInput.setTurn(turn);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Race.create(userInput));
    }

    @Test
    void 우승자_판별() {
        String carNames = "pobi,brown";
        String turn = "1";
        UserInput userInput = new UserInput();
        userInput.setCarNames(carNames);
        userInput.setTurn(turn);
        Race race = Race.create(userInput);

        race.getCars().getCollection().get("pobi").moveForward();
        race.getCars().getCollection().get("pobi").moveForward();
        race.getCars().getCollection().get("pobi").moveForward();

        race.playAllTurn();

        assertThat(race.isWhoWinner().getWinnerList()).contains("pobi").doesNotContain("brown");

    }

    @Test
    void 경기_1턴_진행() {
        String carNames = "pobi";
        String turn = "5";
        UserInput userInput = new UserInput();
        userInput.setCarNames(carNames);
        userInput.setTurn(turn);
        
        Race race = Race.create(userInput);
        race.nextRaceTurn();
        
        assertThat(race.getRecord().getList().size()).isEqualTo(3);
    }
    
    @Test
    void 경기_모든턴_진행() {
        String carNames = "pobi";
        String turn = "3";
        UserInput userInput = new UserInput();
        userInput.setCarNames(carNames);
        userInput.setTurn(turn);

        Race race = Race.create(userInput);
        race.playAllTurn();

        assertThat(race.getRecord().getList().size()).isEqualTo(7);
    }


}