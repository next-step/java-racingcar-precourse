package dto;

public class RacingRequest {

    String[] carNameStringArray;
    int trialNumber;

    protected RacingRequest(String[] carNameStringArray, int trialNumber) {
        this.carNameStringArray = carNameStringArray;
        this.trialNumber = trialNumber;
    }

    public static RacingRequest of(String[] carNameStringArray, int trialNumber) {
        return new RacingRequest(carNameStringArray, trialNumber);
    }
}
