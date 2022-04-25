package racingcar.global;

import racingcar.participant.Participant;

import java.util.List;

import static java.lang.String.format;

public class ValidateUtils {

    public static final String ERROR_PREFIX = "[ERROR]";


    private ValidateUtils() {
    }

    public static void validateNumberOfAttempts(Integer numberOfAttempts) {
        if (numberOfAttempts == null) {
            throw new IllegalArgumentException(format("%s 자동차 게임 시도 횟수값은 null 일 수 없습니다.", ERROR_PREFIX));
        }
        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException(format("%s 자동차 게임 시도 횟수값은 0 보다 작을 수 없습니다.", ERROR_PREFIX));
        }
    }

    public static void validateParticipants(List<Participant> participantList) {
        if (participantList == null) {
            throw new IllegalArgumentException(format("%s 자동차 게임 참가자 목록은 null 일 수 없습니다.", ERROR_PREFIX));
        }
    }

    public static void validateName(String name) {
        final int nameLength = name.length();
        if (0 == nameLength) {
            throw new IllegalArgumentException(format("%s 자동차 이름은 한 글자 이상으로 입력해주세요.", ERROR_PREFIX));
        }
        if (nameLength > 5) {
            throw new IllegalArgumentException(format("%s 자동차 이름은 다섯 글자 이하로 입력해주세요. 입력된 자동차 이름: %s",
                    ERROR_PREFIX, name));
        }
    }

}
