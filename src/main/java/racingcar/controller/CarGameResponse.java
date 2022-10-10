package racingcar.controller;

public class CarGameResponse {

    private final String raceResult;
    private final String winners;

    public CarGameResponse(String raceResult, String winners) {
        this.raceResult = raceResult;
        this.winners = winners;
    }

    public String getRaceResult() {
        return raceResult;
    }

    public String getWinners() {
        return winners;
    }
}
