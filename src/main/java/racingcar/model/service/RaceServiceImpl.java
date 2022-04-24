package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import org.assertj.core.util.Strings;
import racingcar.constants.Constant;
import racingcar.constants.Messages;
import racingcar.model.domain.Car;
import racingcar.view.OutputView;

public class RaceServiceImpl implements RaceService {

    @Override
    public String getResult(ArrayList<Car> cars, int times) {
        // 우승자는 중복이 없으므로 HashSet으로 선언
        HashSet<String> winner = new HashSet<>();
        int winnerDistance = 0;
        for (Car car : cars) {
            // 이동거리 구하기
            car = raceStart(car, times);
            OutputView.printCarScore(car);

            // 현재 최고 이동거리보다 크면 최고이동거리 갱신, 현시점 우승자 갱신
            if (winnerDistance < car.getDistance()) {
                winner.clear();
                winner.add(car.getName());
                winnerDistance = car.getDistance();
                continue;
            }

            // 공동 우승자는 우승자리스트에 추가
            if (winnerDistance == car.getDistance()) {
                winner.add(car.getName());
                continue;
            }
        }
        return String.join(",", winner);
    }

    @Override
    public ArrayList<Car> validateCars(String names) {
        String[] carArr = names.split(",");
        ArrayList<String> dulchk = new ArrayList<>();// 자동차 이름 중복을 위해 사용
        ArrayList<Car> cars = new ArrayList<>();

        if (carArr.length == 0) {
            throw new IllegalArgumentException(Messages.EMPTY_CAR_MESSAGE);
        }

        for (String carName : carArr) {
            if (Strings.isNullOrEmpty(carName)) {
                throw new IllegalArgumentException(Messages.INVALID_CAR_MESSAGE);
            }

            if (carName.length() > Constant.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(Messages.INVALID_CAR_LENGTH_MESSAGE);
            }

            // 자동차 이름이 중복되는 경우
            boolean isDulChk = dulchk.contains(carName);
            if (isDulChk) {
                throw new IllegalArgumentException(Messages.DUPLICATED_CAR_NAME);
            }

            // 자동차 이름 정상
            Car car = new Car(carName);
            cars.add(car);
            dulchk.add(carName);
        }
        return cars;
    }


    @Override
    public int validateTimes(String timesStr) {
        int times = 0;
        try {
            times = Integer.parseInt(timesStr);
        } catch (Exception e) {
            // String을 int로 파싱하다가 오류 나는 경우 처리
            OutputView.printErrorMessage(Messages.INVALID_TIMES_MESSAGE);
        }
        return times;
    }

    @Override
    public Car raceStart(Car car, int times) {
        int distance = 0;
        int win = 0;
        for (int i = 0; i < times; i++) {
            // 각 회차 마다 이동 결과 가져옴
            if (getMove()) {
                // 이동 시, 이동거리 갱신
                car.addDistance(Constant.MOVE_NUMBER);
            }
        }
        return car;
    }

    private boolean getMove() {
        int random = Randoms.pickNumberInRange(Constant.MIN_VALUE, Constant.MAX_VALUE);
        // 랜덤으로 가져온 값이 GO 조건에 최소 값보다 크면 이동
        if (random >= Constant.MIN_MOVE_SCORE) {
            return true;
        }
        return false;
    }
}
