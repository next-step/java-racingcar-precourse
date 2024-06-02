package controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import model.CarDTO;
import model.GameStatusDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamePlayTest {

  @Test
  @DisplayName("우승자 가져오기")
  public void playGame_Get_Winner_Test() {
    //given
    GameStatusDTO.cars = new ArrayList<>();
    GamePlay gamePlay = new GamePlay();
    String[] carsNames = {"abc", "def", "ghi"};
    for (String carName : carsNames) {
      GameStatusDTO.cars.add(new CarDTO(carName));
    }
    GameStatusDTO.playCount = 3;
    gamePlay.init();
    //when
    GameStatusDTO.cars.get(0).move(true);
    GameStatusDTO.cars.get(0).move(true);
    GameStatusDTO.cars.get(0).move(true);
    gamePlay.setWinners();
    //then
    Assertions.assertThat(GameStatusDTO.winners.get(0))
        .isEqualTo(GameStatusDTO.cars.get(0).getName());
  }

  @Test
  @DisplayName("우승자 1명일 때")
  public void playGame_Single_Winner_Test() {
    //given
    GameStatusDTO.cars = new ArrayList<>();
    GamePlay gamePlay = new GamePlay();
    String[] carsNames = {"abc", "def", "ghi"};
    for (String carName : carsNames) {
      GameStatusDTO.cars.add(new CarDTO(carName));
    }
    GameStatusDTO.playCount = 2;
    gamePlay.init();
    //when
    GameStatusDTO.cars.get(0).move(true);
    GameStatusDTO.cars.get(0).move(true);
    gamePlay.setWinners();
    //then
    Assertions.assertThat(GameStatusDTO.winners.size())
        .isEqualTo(1);
  }

  @Test
  @DisplayName("우승자 여러명일 때")
  public void playGame_Multiple_Winner_Test() {
    //given
    GameStatusDTO.cars = new ArrayList<>();
    GamePlay gamePlay = new GamePlay();
    String[] carsNames = {"abc", "def", "ghi"};
    for (String carName : carsNames) {
      GameStatusDTO.cars.add(new CarDTO(carName));
    }
    GameStatusDTO.playCount = 1;
    gamePlay.init();
    //when
    GameStatusDTO.cars.get(0).move(true);
    GameStatusDTO.cars.get(1).move(true);
    gamePlay.setWinners();
    //then
    Assertions.assertThat(GameStatusDTO.winners.size())
        .isEqualTo(2);
  }
}
