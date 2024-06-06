package domain;

/**
 * command에서 유효성 검사를 수행합니다.
 */
public class RacingCarCommand {

    public record Create(String name) {

        public static RacingCarCommand.Create from(String name) {
            // 유효한 이름인지 검사합니다.
            RacingCarValidator.validateName(name);

            return new RacingCarCommand.Create(name);
        }
    }


}
