package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.util.MessageUtils;

public class OutPutView {
    private static final String WINNER_TOKEN = ",";
    /**
     * 자동차들의 상태를 출력
     */
    public void carsStatusPrint(CarList carList) {
        for (Car car : carList.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void winnerPrint(CarList carList) {
        System.out.println(MessageUtils.OUT_LAST_WINNER + " "
                + carList.getWinnerName(WINNER_TOKEN));
    }
}
