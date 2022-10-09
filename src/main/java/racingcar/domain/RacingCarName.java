package racingcar.domain;

import static racingcar.utils.StringUtils.convertStringToArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import racingcar.constant.ErrorCode;

public class RacingCarName {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_CAR_NAME = 1;

    private final String racingCarName;

    public RacingCarName(String racingCarName) {
        validateRacingCarNameLength(racingCarName);
        this.racingCarName = racingCarName;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    private void validateRacingCarNameLength(String racingCarName) {
        if(racingCarName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException(ErrorCode.자동차_이름은_5자_이하.getErrorMessage());
        }
        if(racingCarName.length() < MIN_CAR_NAME) {
            throw new IllegalArgumentException(ErrorCode.자동차_이름은_비어있을_수_없음.getErrorMessage());
        }
    }

    public static List<RacingCarName> convertRacingCarNames(String racingCarName) {
        String[] convertCarNames = convertStringToArray(racingCarName, CAR_NAME_DELIMITER);
        validateSplitCarName(convertStringToArray(racingCarName, CAR_NAME_DELIMITER));
        List<RacingCarName> racingCarNames = new ArrayList<>();
        for(String name: convertCarNames) {
            racingCarNames.add(new RacingCarName(name));
        }
        validateDuplicateCarName(racingCarNames);
        return racingCarNames;
    }

    private static void validateSplitCarName(String[] convertCarNames) {
        if(convertCarNames.length < 1) {
            throw new IllegalArgumentException(ErrorCode.유효한_자동차_이름_없음.getErrorMessage());
        }
    }

    private static void validateDuplicateCarName(List<RacingCarName> racingCarNameList) {
        Set<RacingCarName> racingCarNameSet = new HashSet<>(racingCarNameList);
        if(racingCarNameSet.size() != racingCarNameList.size()) {
            throw new IllegalArgumentException(ErrorCode.자동차_이름_중복.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCarName that = (RacingCarName) o;
        return Objects.equals(getRacingCarName(), that.getRacingCarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRacingCarName());
    }
}
