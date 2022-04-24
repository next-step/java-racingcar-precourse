package racingcar.dto;

import racingcar.vo.RacingCars;

public class ResultRacingCarsDTO {
    private final RacingCars racingCars;
    private final boolean isError;
    private final String errMessage;

    public ResultRacingCarsDTO(RacingCars racingCars, boolean isError) {
        this.racingCars = racingCars;
        this.isError = isError;
        this.errMessage = null;
    }

    public ResultRacingCarsDTO(boolean isError, String errMessage) {
        this.racingCars = null;
        this.isError = isError;
        this.errMessage = errMessage;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
