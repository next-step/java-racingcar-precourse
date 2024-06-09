package domain;

import java.util.List;

public class RacingCarModel {

    /**
     * round 별 결과를 저장합니다.
     */
    public record GameResult(List<RacingCarRound> racingCarRounds) {

        public static GameResult from(List<RacingCarRound> racingCarRounds) {
            return new GameResult(racingCarRounds);
        }
    }
}
