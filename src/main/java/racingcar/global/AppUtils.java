package racingcar.global;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.participant.Participant;
import racingcar.participant.PresentationalRacingCar;
import racingcar.participant.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {

    private AppUtils() {
    }

    public static int pickRandomSingleDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static String reportDashString(Integer location) {
        validateLocation(location);
        StringBuilder result = new StringBuilder();
        for (Integer i = 0; i < location; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static List<Participant> readParticipantList(final String enteredString) {
        List<Participant> participantList = new ArrayList<>();
        for (String participantName : enteredString.split(",")) {
            ValidateUtils.validateName(participantName);
            participantList.add(new RacingCar(participantName));
        }
        return participantList;
    }

    public static Integer readNumberOfAttempts(final String enteredString) {
        try {
            final Integer enteredInteger = Integer.valueOf(enteredString);
            ValidateUtils.validateNumberOfAttempts(enteredInteger);
            return enteredInteger;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[ERROR] 시도 횟수를 올바른 숫자로 입력해주세요.", ValidateUtils.ERROR_PREFIX));
        }
    }

    public static List<Participant> copyParticipantList(List<Participant> participantList) {
        List<Participant> presentationList = new ArrayList<>();
        for (Participant participant : participantList) {
            presentationList.add(new PresentationalRacingCar(participant.getName(), participant.report()));
        }
        return presentationList;
    }

    private static void validateLocation(Integer location) {
        if (location == null) {
            throw new IllegalArgumentException(String.format("%s 위치값은 null 일 수 없습니다.",
                    ValidateUtils.ERROR_PREFIX));
        }
    }

}
