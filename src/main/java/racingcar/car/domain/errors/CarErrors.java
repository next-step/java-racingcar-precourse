package racingcar.car.domain.errors;

public class CarErrors {

    // 자동차 이름(CarName) 오류
    public static final String CAR_NAME_EMPTY_ERROR = "[ERROR] 자동차 이름은 비어있을 수 없습니다.";
    public static final String CAR_NAME_GREATER_THAN_NAME_RULE_ERROR = "[ERROR] 자동차 이름 오류입니다. 최대 글자 수 : ";

    // 자동차 위치(CarPosition) 오류
    public static final String CAR_POSITION_LESS_THAN_ZERO_ERROR = "[ERROR] 자동차의 위치 오류입니다. 최소 자동차 위치 : ";
    public static final String CAR_POSITION_EMPTY_ERROR = "[ERROR] 위치정보 비교 중, 자동차의 위치정보가 존재하지 않습니다.";

    // 자동차 움직임(CarMovePolicyStrategy) 전략 오류
    public static final String CAR_MOVE_STRATEGY_ERROR = "[ERROR] 자동차를 움직이기 위한 전략이 존재하지 않습니다.";

    // 자동차들(Cars) 오류
    public static final String CARS_EMPTY_ERROR = "[ERROR] 자동차를 최소 한대는 입력해야합니다.";

    // 승리자들(Winners) 오류
    public static final String WINNERS_EMPTY_ERROR = "[ERROR] 최소 한명의 승리자가 존재해야합니다.";
    public static final String CARS_DUPLICATE_NAME_ERROR = "[ERROR] 자동차들은 같은 이름을 가질 수 없습니다.";

    private CarErrors() {
    }
}
