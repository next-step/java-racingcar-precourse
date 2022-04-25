package racingcar.participant;

import racingcar.global.AppUtils;
import racingcar.global.ValidateUtils;

import java.util.Objects;

import static java.lang.String.format;

public class RacingCar implements Participant {

    private final String name;
    private Integer location;


    public RacingCar(String name) {
        ValidateUtils.validateName(name);

        this.name = name.trim();
        this.location = 0;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean process(Integer randomNumber) {
        validateRandomNumber(randomNumber);
        if (4 <= randomNumber) {
            location++;
            return true;
        }
        return false;
    }

    @Override
    public String report() {
        return AppUtils.reportDashString(location);
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateRandomNumber(Integer randomNumber) {
        if (randomNumber == null) {
            throw new IllegalArgumentException(format("%s 자동차 게임 진행을 위한 입력값은 null 일 수 없습니다.",
                    ValidateUtils.ERROR_PREFIX));
        }
        if (0 <= randomNumber && randomNumber <= 9) {
            return;
        }
        throw new IllegalArgumentException(format("%s 자동차 게임 진행을 위한 입력값은 0 에서 9 사이의 정수값만 입력할 수 있습니다.",
                ValidateUtils.ERROR_PREFIX));
    }

}
