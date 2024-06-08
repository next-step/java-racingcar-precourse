package controller;

import domain.RacingCarCommand;
import java.util.List;

public class RacingCarRequest {

    /**
     * CreateCarRequest는 레이싱 카 이름을 입력받아 이를 RacingCarCommand.Create 객체로 변환하는 역할을 합니다.
     */
    public record CreateCarRequest(String name) {

        public RacingCarCommand.Create toCommand() {

            List<String> names = parseNames(name);
            return RacingCarCommand.Create.from(names);
        }

        /**
         * 파싱하는 메서드
         */
        private List<String> parseNames(String names) {
            return List.of(names.split(","));
        }
    }

    /**
     * RacingRoundRequest는 레이싱 라운드를 입력받아 이를 RacingCarCommand.RacingRound 객체로 변환하는 역할을 합니다.
     */
    public record RacingRoundRequest(String round) {

        public RacingCarCommand.RacingRound toCommand() {
            return RacingCarCommand.RacingRound.from(round);
        }
    }
}
