package racingcar.model;

import racingcar.Constans;

import java.util.ArrayList;
import java.util.List;

public class RacingData {
    private List<Car> racingCarlist;
    private String slist;
    private int trys = 0;
    private int winnerDistance = 0;
    private List<Car> winners;

    public int getTrys() {
        return trys;
    }

    public RacingData(String list) throws IllegalArgumentException {
        checkError(list);

        this.slist = list;
        setRacingCarlist();

        if (winners == null) winners = new ArrayList<>();
    }

    private void checkError(String str) {
        if (!str.contains(Constans.DELEMITER.getMessage())) throw new IllegalArgumentException(Constans.ERROR_PREFIX.getMessage()+Constans.ERROR_LIST_INPUT_FORMAT.getMessage());
        if (str.contains(Constans.EMPTYSTR.getMessage())) throw new IllegalArgumentException(Constans.ERROR_PREFIX.getMessage()+Constans.ERROR_LIST_INPUT_FORMAT.getMessage());
    }

    public List<Car> getRacingCarlist() {
        return racingCarlist;
    }

    private void setRacingCarlist() {
        racingCarlist = new ArrayList<>();
        String[] cars = slist.split(Constans.DELEMITER.getMessage());

        for (String name: cars) {
            Car racingCar = new Car(name);
            racingCarlist.add(racingCar);
        }
    }

    public void setTrys(String parseInt) throws IllegalArgumentException {
        try {
            this.trys = Integer.parseInt(parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constans.ERROR_PREFIX.getMessage()+Constans.ERROR_NUMBER_FORMAT.getMessage());
        }
    }

    public void setGoStops() {
        if (trys <= 0) return;
        for (int i = 0; i < racingCarlist.size(); i++) {
            setDistance(racingCarlist.get(i));
        }
    }

    private void setDistance(Car car) {
        int diceN = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        if (diceN > 3) {
            car.go();
        }
        if (car.getDistance() != 0) setWinnerDistance(car.getDistance());
    }

    public void setWinnerDistance(int distance) {
        if (distance >= winnerDistance) {
            winnerDistance = distance;
        }
    }

    public int getWinnerDistance() {
        return winnerDistance;
    }

    public List<Car> getWinners() {
        for (Car car: racingCarlist) {
            setWinners(car);
        }
        return winners;
    }

    private void setWinners(Car c) {
        if (c.getDistance() == winnerDistance) {
            winners.add(c);
        }
    }
}
