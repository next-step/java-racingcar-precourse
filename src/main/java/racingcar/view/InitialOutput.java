package racingcar.view;

import java.util.function.Consumer;

public enum InitialOutput {

      RACING_INPUT_MESSAGE("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)", System.out::println)
    , TOTAL_ROUND_INPUT_MESSAGE("시도할 회수", System.out::println)
    ;

    private final String value;
    private final Consumer<String> consumer;

    InitialOutput(String value, Consumer<String> consumer) {
        this.value = value;
        this.consumer = consumer;
    }

    public void print() {
        this.consumer.accept(this.value);
    }
}
