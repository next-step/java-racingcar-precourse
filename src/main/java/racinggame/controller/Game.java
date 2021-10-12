package racinggame.controller;

import nextstep.utils.Console;
import racinggame.*;

import java.util.NoSuchElementException;

public class Game {
    private Cars cars;
    private RaceManager raceManager;

    public void startGame() {
        try {
            getIntroInput();
            processRace();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(ErrorMessage.printNoSuchElementMessage());
        } catch (IllegalArgumentException | NullPointerException e) {
            startGame();
        } finally {
            RaceManager.deleteInstance();
        }
    }

    private void getIntroInput() {
        Message.printIntroCarsNameInput();
        String carsName = Console.readLine();
        Message.printIntroGameCount();
        String gameEndCountString = Console.readLine();
        cars = new Cars(carsName);
        raceManager = RaceManager.createInstance(gameEndCountString);
    }

    private void processRace() {
        for (int i = 0; i < raceManager.getGameEndCount(); i++) {
            raceManager.process();
            RaceResult raceResult = cars.play();
            System.out.println(raceResult.toString());
        }
    }
}
