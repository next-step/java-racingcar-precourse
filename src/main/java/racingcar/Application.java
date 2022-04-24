package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarGameController;
import racingcar.dto.ResultRacingCarsDTO;
import racingcar.vo.RacingCars;

public class Application {
    public static void main(String[] args) {
        new Application().startRacingCarGame(new RacingCarGameController());
    }

    private void startRacingCarGame(RacingCarGameController racingCarGameController) {
        ResultRacingCarsDTO resultRacingCarsDTO = inputCarNamesToRacingCar(racingCarGameController);
        resultRacingCarsDTO = ployRacingCar(resultRacingCarsDTO.getRacingCars(), racingCarGameController);
    }

    private ResultRacingCarsDTO inputCarNamesToRacingCar(RacingCarGameController racingCarGameController) {
        ResultRacingCarsDTO resultRacingCarsDTO;
        boolean isInputError;
        do {
            String carNames = inputCarNames(racingCarGameController);
            resultRacingCarsDTO = racingCarGameController.registerRacingCars(carNames);
            isInputError = checkInputError(resultRacingCarsDTO);
        } while (isInputError);
        return resultRacingCarsDTO;
    }

    private boolean checkInputError(ResultRacingCarsDTO resultRacingCarsDTO) {
        boolean isInputError = resultRacingCarsDTO.isError();
        if (isInputError) {
            System.out.println(resultRacingCarsDTO.getErrMessage());
        }
        return isInputError;
    }

    private String inputCarNames(RacingCarGameController racingCarGameController) {
        String message = racingCarGameController.startGameInputCarNamesMessage();
        System.out.println(message);
        return Console.readLine();
    }

    private ResultRacingCarsDTO ployRacingCar(RacingCars racingCars, RacingCarGameController racingCarGameController) {
        ResultRacingCarsDTO resultRacingCarsDTO;
        boolean isInputError;
        do {
            String round = inputRacingCarGameRound(racingCarGameController);
            resultRacingCarsDTO = racingCarGameController.playRacingCarGame(racingCars, round);
            isInputError = checkInputError(resultRacingCarsDTO);
        } while (isInputError);
        return resultRacingCarsDTO;
    }

    private String inputRacingCarGameRound(RacingCarGameController racingCarGameController) {
        String message = racingCarGameController.inputRoundMessage();
        System.out.println(message);
        return Console.readLine();
    }
}
