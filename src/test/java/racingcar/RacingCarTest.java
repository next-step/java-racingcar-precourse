package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class RacingCarTest {

  @Test
  @DisplayName("전진 후진 테스트")
  void 자동차전진후진테스트() {
    assertThat(RacingCarUtil.isGoOrStop(9)).isEqualTo(true);
    assertThat(RacingCarUtil.isGoOrStop(0)).isEqualTo(false);
  }

  @Test
  @DisplayName("자동차 전진일 경우 전진 값 add")
  void 자동차전진() {
    //given
    RacingCar racingCar = new RacingCar("pobi");
    //when
    int count = 9;
    //then
    assertThat(RacingCarUtil.isGoOrStop(count)).isEqualTo(RacingCar.addGoCount(racingCar, count));
  }

  @Test
  @DisplayName("자동차우승자 확인")
  void 자동차경주우승자확인및출력() {
    //given
    List<RacingCar> racingCarList = new ArrayList<>();
    racingCarList.add(new RacingCar("aa"));
    racingCarList.add(new RacingCar("cc"));
    racingCarList.add(new RacingCar("dd"));
    racingCarList.add(new RacingCar("bb"));
    //when
    int[] goCnt = {3, 4, 0, 0};
    for (int idx = 0; idx < goCnt.length; idx++) {
      if (RacingCarUtil.isGoOrStop(goCnt[idx])) {
        racingCarList.get(idx).addGoCount(racingCarList.get(idx), goCnt[idx]);
      }
    }
    //then
    assertThat(StringUtils.isNotBlank(RacingCarUtil.getCarName(racingCarList))).isEqualTo(
        finishCarName(RacingCarUtil.getCarName(racingCarList)));

  }

  boolean finishCarName(String carNames) {
    System.out.println("최종 우승자 : " + carNames);
    return true;
  }

  //자동차 경주 값 입력 및 오류 처리
  @Test
  @DisplayName("자동차이름입력테스트")
  void 입력테스트() {
    String carName = "asdddddddde";
    RacingCarUtil.validationCarNameNull(carName);
    RacingCarUtil.validationCarNameLength(carName);
  }

}
