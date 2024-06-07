package domain;

import java.util.List;
import util.Validator;

/**
 * command에서 유효성 검사를 수행합니다.
 */
public class RacingCarCommand {

    public record Create(List<String> name) {

        public static RacingCarCommand.Create from(List<String> names) {
            // 유효한 이름인지 검사합니다.
            return new RacingCarCommand.Create(names);
        }
    }

    public record Racing(int round) {

        public static RacingCarCommand.Racing from(int round) {

            return new RacingCarCommand.Racing(round);
        }
    }


}
