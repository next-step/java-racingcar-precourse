package controller;

import domain.RacingCar;
import domain.RacingCarModel;
import java.util.List;

public class RacingCarResponse {

    public record ResultGameResponse(RacingCarModel.GameResult gameResult) {

        public static ResultGameResponse from(RacingCarModel.GameResult result) {
            return new ResultGameResponse(result);
        }
    }

}
