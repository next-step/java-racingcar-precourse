package racingcar.domain;

//함수형 인터페이스임을 명시 (메소드 오직 1개)
@FunctionalInterface
public interface GameMovingStrategy {
    boolean movable();
}
