package racingcar.model.strategy;

/**
 * 이동전략 인터페이스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public interface MoveStrategy {

    boolean isMovable();

    int actByStrategy();


}
