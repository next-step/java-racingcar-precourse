package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Game game = new Game();
    @Test
    @DisplayName("경주 자동차 등록 Test")
    void 경주_자동차_등록_TEST(){
        //given
        String[] carsName = {"자동차1", "자동차2"};

        //when
        game.setRaceCars(carsName);

        //then
        assertThat(game.getRaceCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("시도 횟수 설정 Test")
    void 시도_횟수_설정_TEST(){
        //given
        int trial = 4;

        //when
        game.setTrial(trial);

        //then
        assertThat(game.getTrial()).isEqualTo(4);
    }

    @Test
    @DisplayName("수행 횟수 증가 Test")
    void 수행_횟수_증가_TEST(){
        //given

        //when
        for(int i=0; i<5; i++){
            game.increaseTrialNumber();
        }

        //then
        assertThat(game.getTrialNumber()).isEqualTo(5);
    }

    @Test
    @DisplayName("경주 게임 종료 여부 True Test")
    void 경주_게임_종료_여부_TRUE_TEST(){
        // given
        game.setTrial(4);
        for(int i=0; i<4; i++){
            game.increaseTrialNumber();
        }

        // when
        Boolean result = game.isGameEnd();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("경주 게임 종료 여부 False Test")
    void 경주_게임_종료_여부_FALSE_TEST(){
        // given
        game.setTrial(4);
        for(int i=0; i<2; i++){
            game.increaseTrialNumber();
        }

        // when
        Boolean result = game.isGameEnd();

        // then
        assertThat(result).isFalse();
    }


    @Test
    @DisplayName("자동차 최대 위치 GET Test")
    void 자동차_최대_위치_GET_TEST(){
        //given
        String[] carsName = {"자동차1", "자동차2"};
        game.setRaceCars(carsName);

        //when
        for(int i=0; i<5; i++){
            game.getRaceCars().get(0).move(i);
        }

        for(int i=0; i<5; i++){
            game.getRaceCars().get(1).move(i+3);
        }

        //then
        assertThat(game.getMaxPosition(game.getRaceCars())).isEqualTo(4);
    }

    @Test
    @DisplayName("경주 우승자 정보 GET Test")
    void 경주_우승자_정보_GET_TEST(){
        //given
        String[] carsName = {"자동차1", "자동차2", "자동차3"};
        game.setRaceCars(carsName);

        //when
        for(int i=0; i<5; i++){
            game.getRaceCars().get(0).move(i);
        }

        for(int i=0; i<5; i++){
            game.getRaceCars().get(1).move(i+3);
            game.getRaceCars().get(2).move(i+3);
        }

        //then
        assertThat(game.getWinners().size()).isEqualTo(2);
        assertThat(game.getWinners().get(0).getName()).isEqualTo("자동차2");
        assertThat(game.getWinners().get(1).getName()).isEqualTo("자동차3");
    }
}
