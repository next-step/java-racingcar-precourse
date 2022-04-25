package racingcar.participant;

public interface Participant {

    String getName();

    boolean process(Integer randomNumber);

    String report();

}
