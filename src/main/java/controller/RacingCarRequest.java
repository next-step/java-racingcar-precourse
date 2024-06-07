package controller;

import domain.RacingCarCommand;
import java.util.List;

public class RacingCarRequest {

    public record CreateCarRequest(String name) {

        public RacingCarCommand.Create toCommand() {

            List<String> names = parseNames(name);
            return RacingCarCommand.Create.from(names);
        }

        private List<String> parseNames(String names) {
            return List.of(names.split(","));
        }
    }

    public record RacingRoundRequest(int round) {

        public static RacingCarCommand.Racing from() {

            return null;
        }
    }
}
