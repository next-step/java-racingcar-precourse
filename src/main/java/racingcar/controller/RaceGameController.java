package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.CarFactory;
import racingcar.domain.dto.RacingCarDto;
import racingcar.domain.model.RaceRecordBoard;
import racingcar.domain.model.RacingCar;
import racingcar.view.RaceInputView;
import racingcar.view.RaceOutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameController {

    private final RaceInputView inputView;
    private final RaceOutputView outputView;
    private final RaceRecordBoard recordBoard;

    public RaceGameController() {
        this.inputView = new RaceInputView();
        this.outputView = new RaceOutputView();
        this.recordBoard = new RaceRecordBoard();
    }

    /**
     * 자동차 경주 게임 플레이
     */
    public void playGame() {
        String[] carNames = inputView.readCarNames();
        Integer tryNumber = inputView.readTryNumber();

        CarFactory factory = new CarFactory(carNames, tryNumber, recordBoard);
        List<RacingCar> carList = factory.createCars();
        race(carList, tryNumber);
        outputView.printWinners(recordBoard.findWinners());
    }

    /**
     * play Race
     */
    private void race(List<RacingCar> carList, Integer tryNumber) {
        for (int i = 0; i < tryNumber; i++){
            forwardCars(carList);
            outputView.printRaceProgress(transModelToDtoList(carList));
        }
    }

    /**
     * 차량 전진 시키기
     */
    private void forwardCars(List<RacingCar> carList){
        for (RacingCar rc : carList) {
            rc.move(getRandomNumber());
        }
    }

    /**
     * 1 ~ 9 사이 숫자 랜덤 생성
     */
    private Integer getRandomNumber(){
        return Randoms.pickNumberInRange(1, 9);
    }

    /**
     * transform - RacingCar to RacingCarDto
     */
    private List<RacingCarDto> transModelToDtoList(List<RacingCar> carList){
        List<RacingCarDto> carDtoList = new ArrayList<>();
        carList.forEach(car -> carDtoList.add(new RacingCarDto(car.getName(), car.getDistance())));

        return carDtoList;
    }
}
