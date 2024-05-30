package com.mini.caracing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameModelTest {

    private GameModel gameModel;

    @BeforeEach
    public void setUp() {
        gameModel = new GameModel();
    }

    @ParameterizedTest
    @DisplayName("게임 초기 세팅 테스트")
    @CsvSource({
        "'pobi,woni,jun', 5",
        "'car1,car2,car3', 3"
    })
    public void testInitGameModel(String carNameInput, int totalMove) {
        List<String> carNames = Arrays.asList(carNameInput.split(","));
        gameModel.initGameModel(carNames, totalMove);

        assertThat(gameModel.getCarDistances()).hasSize(carNames.size());
        assertThat(gameModel.getCarDistances().keySet()).containsExactlyElementsOf(carNames);
        assertThat(gameModel.getCarDistances().values()).containsOnly(0);
    }

    @ParameterizedTest
    @DisplayName("차량 주행 거리 갱신 테스트")
    @CsvSource({
        "'car1,car2,car3', 3",
        "'car1', 1"
    })
    public void testUpdateOneCarDistance(String carNameInput, int moveDistance) {
        List<String> carNames = Arrays.asList(carNameInput.split(","));
        gameModel.initGameModel(carNames, 3);

        for (Map.Entry<String, Integer> entry : gameModel.getCarDistances().entrySet()) {
            gameModel.updateOneCarDistance(entry, moveDistance);
        }

        for (int distance : gameModel.getCarDistances().values()) {
            assertThat(distance).isEqualTo(moveDistance);
        }
    }

    @ParameterizedTest
    @DisplayName("우승 차량 테스트")
    @CsvSource({
        "'car1,car2,car3', '5,3,5', 'car1,car3'",
        "'carA,carB,carC', '2,4,4', 'carB,carC'",
        "'Pobi,Woni,Jun', '6,6,6', 'Pobi,Woni,Jun'"
    })
    public void testGetWinnerList(String carNameInput, String moveDistance,
        String winnerListInput) {
        gameModel.initGameModel(Arrays.asList(carNameInput.split(",")), 3);
        List<Integer> moveDistanceList = Arrays.stream(moveDistance.split(","))
            .map(Integer::parseInt).collect(Collectors.toList());
        List<String> winnerList = Arrays.asList(winnerListInput.split(","));

        int idx = 0;
        for (Map.Entry<String, Integer> entry : gameModel.getCarDistances().entrySet()) {
            gameModel.updateOneCarDistance(entry,
                moveDistanceList.get(idx++ % moveDistanceList.size()));
        }

        assertThat(winnerList).isEqualTo(gameModel.getWinnerList());
    }
}