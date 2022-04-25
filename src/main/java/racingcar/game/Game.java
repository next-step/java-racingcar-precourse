package racingcar.game;

public interface Game {

    void start();

    void play();

    boolean end();

    boolean restart(String enteredString);

}
