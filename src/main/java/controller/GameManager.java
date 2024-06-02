package controller;

import java.util.Arrays;
import java.util.List;
import model.Game;
import model.Validator;
import view.GameView;

public class GameManager {
    private final GameInput gameInput = new GameInput();
    private final GameView gameView = new GameView();
    private final Validator validator = new Validator();
    private List<String> namesList;
    private int attemps;

    public void initializeGame(){

        initNames();
        initAttemps();

        Game game = new Game(namesList, attemps);
        game.start();
    }

    private void initNames(){
        boolean validname = false;
        while (!validname){
            try {
                String names = getCarNamesFromUser();
                namesList = splitNames(names);
                validname = validator.checkNames(namesList);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
    private void initAttemps(){
        boolean validTry = false;
        while (!validTry){
            try {
                String attemps = getAttempsFromUser();
                validTry = validator.checkAttemps(attemps);
                this.attemps = Integer.parseInt(attemps);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
    private String getCarNamesFromUser(){
        gameView.initialCarNames();
        String names = gameInput.initialCarNames();
        return names;
    }
    private String getAttempsFromUser(){
        gameView.raceAttemps();
        String attemps = gameInput.raceAttemps();
        return attemps;
    }
    private List<String> splitNames(String names){
        // 콤마 기준으로 문자열 자르기
        String[] splitArray = names.split(",");
        // 분할된 문자열 배열을 리스트로 변환
        List<String> resultList = Arrays.asList(splitArray);
//        System.out.println(resultList);
        return resultList;
    }
}
