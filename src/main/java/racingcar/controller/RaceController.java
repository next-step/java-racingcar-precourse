package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.appconfig.AppConfig;
import racingcar.constants.RaceStatus;
import racingcar.model.domain.Car;
import racingcar.model.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private RaceService service;
    private static ArrayList<Car> carList;

    private static int times = 0;

    public static RaceStatus raceStatus;

    public RaceController() {
        initConfig();
    }

    private void initConfig() {
        // RaceService 자동 객체 생성을 위해 AppConfig 구현
        AppConfig appConfig = new AppConfig();
        service = appConfig.raceService();
        raceStatus = RaceStatus.READY;
    }

    public void start() {
        setStartRace();
        while (raceStatus == RaceStatus.START) {
            racing();
        }
        setRetryRace();
    }

    public void racing() {
        // 자동차 입력
        setCarList();
        if (raceStatus == RaceStatus.ERROR) {
            return;
        }

        int times = setTimes();

        String result = service.getResult(carList, times);

        setEndRace();

        OutputView.printWinners(result.toString());
    }

    public void setCarList() {
        // 자동차 리스트 입력
        InputView.inputCars();
        String cars = Console.readLine();
        try {
            carList = service.validateCars(cars);
        } catch (IllegalArgumentException e) {
            raceStatus = RaceStatus.ERROR;
            OutputView.printErrorMessage(e.getMessage());
            return;
        }
    }

    public int setTimes() {
        // 시도 회수 정상 입력될때까지 입력
        while (times == 0) {
            InputView.inputRaceTimes();
            String timeStr = Console.readLine();
            times = service.validateTimes(timeStr);
        }
        return times;
    }

    public void setEndRace() {
        if (raceStatus == RaceStatus.START) {
            raceStatus = RaceStatus.END;
            return;
        }
        raceStatus = RaceStatus.ERROR;
        return;
    }

    public void setStartRace() {
        if (raceStatus == RaceStatus.READY) {
            raceStatus = RaceStatus.START;
            return;
        }
    }

    public void setRetryRace() {
        if (raceStatus == RaceStatus.ERROR) {
            raceStatus = RaceStatus.READY;
            start();
            return;
        }
    }

}
