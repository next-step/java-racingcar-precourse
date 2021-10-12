package racinggame.control;

import nextstep.utils.Console;
import racinggame.GamePrint;
import racinggame.Service;

import java.util.NoSuchElementException;

public class GameController {

    ControllerMapper map;
    CurrentGameInfo currentInfo;
    GamePrint out;

    public GameController() {
        out = new GamePrint();
        currentInfo = new CurrentGameInfo();
        map = new ControllerMapper();
        map.put(GameStatus.INIT, this::gameInit);
        map.put(GameStatus.INITCAR, this::gameInitCar);
        map.put(GameStatus.INITCOUNT, this::gameInitCount);
        map.put(GameStatus.INITPROGRESS, this::gameInitProcess);
        map.put(GameStatus.PROGRESS, this::gameProcess);
        map.put(GameStatus.END, this::gameEnd);
        map.put(GameStatus.EXIT, this::gameExit);
    }

    public CurrentGameInfo getCurrentInfo() {
        return currentInfo;
    }

    private void gameExit() {
        System.out.println("Exit Game");
    }

    private void gameInitProcess() {
        currentInfo.setStatus(GameStatus.INITPROCESS);
        out.printResult();
        currentInfo.setStatus(GameStatus.PROGRESS);
    }

    private void gameInitCount() throws Exception {
        currentInfo.setStatus(GameStatus.INITCOUNT);
        out.printTryCountInput();
        String count = Console.readLine();
        currentInfo.getCount().set(count);//throw exception
        currentInfo.setStatus(GameStatus.INITPROGRESS);
    }

    private void gameInitCar() throws Exception {
        currentInfo.setStatus(GameStatus.INITCAR);
        out.printCarNameInput();
        String carNames = Console.readLine();
        currentInfo.getList().setCarList(carNames);//throw exception
        currentInfo.setStatus(GameStatus.INITCOUNT);
    }

    private void gameEnd() throws Exception {
        out.printWinner(currentInfo.getList());
        currentInfo.setStatus(GameStatus.EXIT);

    }

    private void gameProcess() throws Exception {
        currentInfo.setStatus(GameStatus.PROGRESS);
        while (currentInfo.getCount().isNoneZero()) {
            currentInfo.getList().process();
            currentInfo.getCount().countDown();
            out.printProcessing(currentInfo.getList());
        }
        currentInfo.setStatus(GameStatus.END);
    }

    public void gameInit() throws Exception {
        currentInfo.setStatus(GameStatus.INITCAR);
    }

    public void run() {
        try {
            map.get(currentInfo.getStatus()).run();
        } catch (Exception e) {
            out.PrintError(e.getMessage());
            handleException(e);

        }
    }

    private void handleException(Exception e) {
        if (e.getMessage().contains("No line found")) {
            currentInfo.setStatus(GameStatus.EXIT);
            throw new NoSuchElementException();
        }
    }

}
