package racingcar;

public class UserInput {

    public static final String USER_INPUT_CAR_NAMES = "경주할 자동차의 이름을 입력해주세요.(이름은 쉼표(,)를 기준으로 구분)";
    public static final String USER_INPUT_TURN = "몇턴을 진행하겠습니까? (숫자 입력)";
    public static final String START_RACE = "경주를 시작합니다.";

    private CarNames carNames;
    private RaceTurn turn;

    public void setCarNames(String inputCarNames) throws IllegalArgumentException {
        carNames = CarNames.create(inputCarNames);
    }

    public void setTurn(String inputTurn) throws IllegalArgumentException {
        turn = new RaceTurn(inputTurn);
    }

    public CarNames getCarNames() {
        return carNames;
    }

    public RaceTurn getTurn() {
        return turn;
    }
}
