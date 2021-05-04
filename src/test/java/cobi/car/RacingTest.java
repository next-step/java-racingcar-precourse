package cobi.car;

import static org.mockito.ArgumentMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import cobi.number.NumberGenerator;
import cobi.view.ConsoleView;

class RacingTest {
  private ConsoleView view;
  private NumberGenerator numberGenerator;
  private Racing racing;

  @BeforeEach
  void init(){
    this.view = Mockito.mock(ConsoleView.class);
    this.numberGenerator = Mockito.mock(NumberGenerator.class);
    this.racing = new Racing(view, numberGenerator);
  }

  @Test
  @DisplayName("레이싱 시작 기본 테스트")
  void racingBasicTest(){
    // given
    List<String> carNameList = Arrays.asList("car1", "car2", "car3");
    int moveCount = 5;
    Mockito.when(view.inputCarName()).thenReturn(carNameList);
    Mockito.when(view.inputCount()).thenReturn(moveCount);

    // when
    racing.start();

    // then
    Mockito.verify(view, Mockito.times(1)).inputCarName(); // 자동차 이름 입력 실행
    Mockito.verify(view, Mockito.times(1)).inputCount();   // 이동 횟수 입력 실행

    // 랜덤 숫자 생성 로직이 n(게임 횟수 x 자동차수)번 실행됨
    // 랜덤 숫자 생성 실행을 자동차 이동 실행으로 간주
    Mockito.verify(
      numberGenerator,
      Mockito.times(moveCount * carNameList.size())
    ).getNumber();

    Mockito.verify(view, Mockito.times(1)).printWinners(anyList()); // 이동 횟수 입력 실행
  }
}
