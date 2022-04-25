package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class GameTest {
    InputView inputView = mock(InputView.class);
    OutputView outputView = mock(OutputView.class);
    Game game = new Game(inputView, outputView);

    @DisplayName("자동차 경주 게임 플레이")
    @Test
    void play() {
        //given
        given(inputView.inputCarsNames()).willReturn("pobi");
        given(inputView.inputMoveCount()).willReturn("3");
        InOrder inOrder = inOrder(inputView, outputView);

        //when
        game.play();

        //then
        inOrder.verify(inputView).inputCarsNames();
        inOrder.verify(inputView).inputMoveCount();
        inOrder.verify(outputView).printResult(any());
    }

    @DisplayName("잘못된 자동차 이름인 경우 다시 입력 받는다")
    @Test
    void inputAgainWhenInvalidCarNames() {
        //given
        given(inputView.inputCarsNames()).willReturn("sixTxt", " ", "valid");

        //when
        game.createRace();

        //then
        verify(inputView, times(3)).inputCarsNames();
    }

    @DisplayName("잘못된 시도 횟수인 경우 다시 입력 받는다")
    @Test
    void inputAgainWhenInvalidMoveCount() {
        //given
        given(inputView.inputMoveCount()).willReturn("-1", "0", "1");

        //when
        game.createMoveCount();

        //then
        verify(inputView, times(3)).inputMoveCount();
    }
}