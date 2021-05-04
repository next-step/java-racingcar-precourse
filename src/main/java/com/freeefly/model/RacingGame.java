package com.freeefly.model;

import com.freeefly.executor.RacingExecutor;
import com.freeefly.util.InputProcessor;
import com.freeefly.util.RNG;
import com.freeefly.util.StringUtils;
import com.freeefly.validator.CarNameValidator;
import com.freeefly.validator.ProceedCountValidator;

import java.util.List;

import static com.freeefly.config.RacingConfig.PROCEED_NUMBER_BOUND;
import static com.freeefly.message.RacingMessage.*;

public class RacingGame {
    private RacingCarList cars;
    private Integer proceedCount;
    private List<String> winners;
    private RacingExecutor racingExecutor;
    private CarNameValidator carNameValidator;
    private ProceedCountValidator proceedCountValidator;

    public RacingGame(RacingExecutor racingExecutor, CarNameValidator carNameValidator, ProceedCountValidator proceedCountValidator) {
        assert racingExecutor != null;
        assert carNameValidator != null;
        assert proceedCountValidator != null;
        this.racingExecutor = racingExecutor;
        this.carNameValidator = carNameValidator;
        this.proceedCountValidator = proceedCountValidator;
    }

    /**
     * 입력을 받아 차의 이름을 세팅
     */
    public void inputCarNames() {
        String input = InputProcessor.putNumbers(CAR_NAME_INPUT_GUIDE);
        String message = WRONG_INPUT;
        while (!carNameValidator.isNameValid(input)) {
            input = InputProcessor.putNumbers(message);
        }
        setCars(input);
    }

    /**
     * 차 이름을 입력 받아 RacingCar 객체 생성
     *
     * @param carNames
     */
    private void setCars(String carNames) {
        String[] names = carNames.split(",");
        cars = new RacingCarList();
        for (int i = 0; i < names.length; i++) {
            cars.addCar(names[i]);
        }
    }


    /**
     * 시도 횟수를 입력받아서 처리
     */
    public void inputProceedCount() {
        String input = InputProcessor.putNumbers(PROCEED_COUNT_INPUT_GUIDE);
        String message = WRONG_INPUT;
        while (!proceedCountValidator.isProceedCountValid(input)) {
            input = InputProcessor.putNumbers(message);
        }
        this.proceedCount = Integer.parseInt(input);
    }

    /**
     * 시도 횟수 만큼 게임을 진행한다
     */
    public void playGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.proceedCount; i++) {
            process();
        }
    }

    private void process() {
        this.cars.getCars().forEach(car -> car.proceed(racingExecutor.proceed(generateProceedNumber())));
        printProcess();
    }

    /**
     * 경주 게임에 맞는 랜덤 숫자 생성
     *
     * @return
     */
    private Integer generateProceedNumber() {
        return RNG.generate(PROCEED_NUMBER_BOUND);
    }


    /**
     * 실행 결과 출력
     */
    private void printProcess() {
        StringBuilder sb = new StringBuilder();
        this.cars.getCars().forEach(car -> sb.append(car.getName()).append(": ").append(StringUtils.getIterableDashes(car.getProceedCount())).append("\n"));
        System.out.println(sb);
    }

    /**
     * 경기 결과 확인
     */
    public void openResult() {
        this.cars.validateWinners();
        printResult();
    }

    /**
     * 경기 결과 출력
     */
    private void printResult() {
        String winnerNames = String.join(", ", this.cars.getWinnerNames());
        System.out.println(winnerNames + WINNER_GUIDE);
    }
}
