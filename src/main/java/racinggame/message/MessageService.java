package racinggame.message;

import racinggame.model.Car;

public interface MessageService {
    void start();

    void count();

    void resultDescription();

    void result(Car car);

    void winner(String winners);

    void error();

    void lineFeed();
}
