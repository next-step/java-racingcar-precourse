package view;

import exception.ExceptionHandler;
import model.RacingCar;
import util.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ";
    private static final String GET_ATTEMPT_NUM_MSG = "시도할 횟수는 몇회인가요?";
    private static final String DELIMITER = ",";


    public ArrayList<RacingCar> getRacingCars() {
        System.out.println(GET_CAR_NAME_MSG);
        String carNameInput = scanner.nextLine();

        String[] carNames  = carNameInput.split(DELIMITER);

        try {
            if(InputValidator.validateCarName(carNames))
                return returnRacingCars(carNames);
        }catch(IllegalArgumentException | IllegalStateException e){
            ExceptionHandler.showErrorMsg(e);
            return getRacingCars();
        }
        return null;
    }

    private ArrayList<RacingCar> returnRacingCars(String[] carNames) {
        ArrayList<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName.trim()));
        }
        return racingCars;
    }

    public int getAttemptNumber() {
        System.out.println(GET_ATTEMPT_NUM_MSG);
        int attemptNum = Integer.parseInt(scanner.nextLine());

        try{
            if(InputValidator.validateAttemptNum(attemptNum))
                return attemptNum;
        } catch (IllegalArgumentException e){
            ExceptionHandler.showErrorMsg(e);
            return getAttemptNumber();
        }

        return 0;
    }

}
