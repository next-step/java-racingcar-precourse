package racingcar.domain;

import static racingcar.common.CommonVariable.ERROR_MESSAGE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NULLE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_SAME_RACING_CAR_NAME;
import static racingcar.common.CommonVariable.LAST_WINNER_REMARK_PREFIX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.platform.commons.util.StringUtils;

public class CarManager implements GameInput{
    private Map<String, RacingCar> racingJoinCars;
    private String[] racingJoinCarNames;
    public CarManager(){
        racingJoinCars = new HashMap<>();
    }

    public String[] getRacingJoinCarNames() {
        return racingJoinCarNames;
    }

    public void startRacingGame(String input){
        racingGamePlayerNameInputValidation(input);
        joinRacingCars(racingJoinCarNames(input));
    }

    private String[] racingJoinCarNames(String input){
        this.racingJoinCarNames = input.split(",");
        return racingJoinCarNames;
    }

    private RacingCar joinRacingCar(String name){
        RacingCar racingCar = null;
        try{
            racingCar = RacingCar.getInstance(name);
        } catch(IllegalArgumentException e){
            racingJoinCars.clear();
            throw new IllegalArgumentException(e.getMessage());
        }
        return racingCar;
    }

    private void joinRacingCars(String[] racingJoinCarNames){
        Arrays.asList(racingJoinCarNames).forEach(racingJoinCarName -> {
            isSameNameRacingCarValidation(racingJoinCarName);
            racingJoinCars.put(racingJoinCarName, joinRacingCar(racingJoinCarName));
        });
    }

    private void isSameNameRacingCarValidation(String racingJoinCarName){
        if (racingJoinCars.containsKey(racingJoinCarName)){
            racingJoinCars.clear();
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MESSAGE_SAME_RACING_CAR_NAME);
        }
    }

    private void racingGamePlayerNameInputValidation(String input){
        if (StringUtils.isBlank(input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NULLE);
        }
    }

    public Map<String, RacingCar> getJoinRacingCarsMap(){
        return racingJoinCars;
    }

    public void racingGameWinnerPrint(){
        List<RacingCar> racingCars =  sortToRacingCars();
        int winnerTravel = racingCars.get(0).getTravel();
        System.out.println(LAST_WINNER_REMARK_PREFIX + makeWinnerRemarks(racingCars, winnerTravel));
    }

    private List<RacingCar> sortToRacingCars(){
        List<RacingCar> racingCars =  new ArrayList<>();
        Arrays.asList(racingJoinCarNames).forEach(racingCarName -> {
            racingCars.add(racingJoinCars.get(racingCarName));
        });
        Collections.sort(racingCars);
        return racingCars;
    }

    private String makeWinnerRemarks(List<RacingCar> racingCars, int winnerTravel){
        StringBuilder winnerNames = new StringBuilder();
        racingCars.forEach(racingCar -> {
            if (winnerTravel == racingCar.getTravel()) {
                if (winnerNames.length() != 0){
                    winnerNames.append(", " +racingCar.getName()) ;
                }
                if (winnerNames.length() == 0){
                    winnerNames.append(racingCar.getName());
                }
            }
        });
        return winnerNames.toString();
    }

    @Override
    public void gameStartInput(String input) {
        racingGamePlayerNameInputValidation(input);
        joinRacingCars(racingJoinCarNames(input));
    }
}
