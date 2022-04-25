package racingcar;

public class RaceController {

    private UserInput userInput;

    public String init() {
        userInput = new UserInput();
        return UserInput.USER_INPUT_CAR_NAMES;
    }

    public String inputCarNames(String inputCarNames) {
        try {
            userInput.setCarNames(inputCarNames);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return UserInput.USER_INPUT_TURN;
    }

    public String inputTurn(String turn) {
        try {
            userInput.setTurn(turn);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return UserInput.START_RACE;
    }

    public String play() {
        Race race = Race.create(userInput);
        race.playAllTurn();
        return race.getRecord().toString();
    }
}
