package racinggame.domain;

public class Player {

    private RaceNumber raceNumber;
    private InputCarsName inputCarsName;

    public Player() {
    }

    public Player(RaceNumber raceNumber, InputCarsName inputCarsName) {
        this.raceNumber = raceNumber;
        this.inputCarsName = inputCarsName;
    }

    public void inputRaceNumber(RaceNumber raceNumber) {
        this.raceNumber = raceNumber;
    }

    public void inputCarsName(InputCarsName inputCarsName) {
        this.inputCarsName = inputCarsName;
    }

    public RaceNumber getRaceNumber() {
        return raceNumber;
    }

    public InputCarsName getInputCarsName() {
        return inputCarsName;
    }

    public static Player of(RaceNumber raceNumber, InputCarsName inputCarsName) {
        return new Player(raceNumber, inputCarsName);
    }
}
