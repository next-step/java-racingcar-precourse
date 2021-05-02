package com.game.racingCar;

import com.game.global.exception.CarsException;
import com.game.global.utils.CsvUtils;

import java.util.*;

import static com.game.global.code.CarsExceptionType.DUPLICATE_CAR_NAME;
import static java.lang.String.format;

public class RacingControlTower {

    private Map<String, RacingCar> statusMap;
    private Queue<RacingCar> rankingQueue;


    public RacingControlTower(String csvCarList) {
        this.statusMap = new LinkedHashMap<>();
        this.rankingQueue = new PriorityQueue<>();

        final String[] carList = CsvUtils.makeStringArray(csvCarList);
        for (int i = 0; i < carList.length; i++) {
            final String carName = carList[i];
            validateDuplicateCarName(i, carName);
            statusMap.put(carName, new RacingCar(carName));
        }
    }


    public Map<String, RacingCar> getStatusMap() {
        return statusMap;
    }

    public List<String> getWinnerList() {
        rankRacingCar();

        final RacingCar firstWinner = rankingQueue.poll();
        List<String> winnerList = new ArrayList<>();
        winnerList.add(firstWinner.getName());

        while (!rankingQueue.isEmpty() && firstWinner.compareLocation(rankingQueue.peek())) {
            winnerList.add(rankingQueue.poll().getName());
        }

        return winnerList;
    }


    private void validateDuplicateCarName(int index, String carName) {
        if (statusMap.containsKey(carName)) {
            throw new CarsException(DUPLICATE_CAR_NAME,
                    format(DUPLICATE_CAR_NAME.getDescription(), index+1, carName));
        }
    }

    private void rankRacingCar() {
        rankingQueue.clear();

        final Iterator<String> statusIterator = statusMap.keySet().iterator();
        while (statusIterator.hasNext()) {
            final String carName = statusIterator.next();
            final RacingCar racingCar = statusMap.get(carName);
            rankingQueue.add(racingCar);
        }
    }

}
