package domain;

import java.util.List;
import util.Validator;

/**
 * command에서 유효성 검사를 수행합니다.
 */
public class RacingCarCommand {

    public record Create(List<String> name) {

        public static RacingCarCommand.Create from(List<String> names) {
            // foreach로 유효한 이름인지 검사합니다.
            names.forEach(Validator::validateName);

            // 중복된 이름이 있는지 검사합니다.
            Validator.validateDuplicateName(names);
            return new RacingCarCommand.Create(names);
        }
    }

}
