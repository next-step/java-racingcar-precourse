package racingcar.domain.race;

import racingcar.Constant;
import racingcar.domain.car.Car;
import racingcar.domain.car.ParticipatingCars;

public class RaceProcess {
    public int startrace(ParticipatingCars allRacingCars, int position) {
        int leadPosition = position;

        for (Car car : allRacingCars.getCars()) {
            int value = car.getRandomValue();

            car.forward(value);

            if (updateLeadPosition(car, leadPosition)) {
                leadPosition++;
            }
        }

        return leadPosition;
    }

    private boolean updateLeadPosition(Car car, int leadPosition) {
        return car.isLead(leadPosition);
    }


    public void showCurrentSituation(ParticipatingCars allRacingCars) {
        for (Car car : allRacingCars.getCars()) {
            System.out.print(car.getName() + Constant.COLON);
            showEachCarSituation(car.getPosition());
        }

        System.out.println();
    }

    private void showEachCarSituation(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print(Constant.FORWARD_SIGN);
        }

        System.out.println();
    }
}
