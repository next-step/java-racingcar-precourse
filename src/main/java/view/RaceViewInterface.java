package view;

import controller.RaceControllerInterface;

public interface RaceViewInterface {

    void userCarsInput();

    void userRoundsInput();

    void setRaceControllerInterface(RaceControllerInterface raceControllerInterface);

    void printProgress();

    void printProcess();

    void printResult();

    void printCarsErrorMessage();

    void printRoundsArgumentErrorMessage();

    void printRoundsFormatErrorMessage();
}
