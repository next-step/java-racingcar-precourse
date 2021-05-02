package domain;

import dto.CarDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceReport {
    private List<CarDto> results;
    private List<CarDto> winners;
    private RaceStatus raceStatus;

    public RaceReport(List<CarDto> results, RaceStatus raceStatus) {
        this.results = results;
        this.raceStatus = raceStatus;
        if (raceStatus.isEnd()) {
            winners = findWinners();
        }
    }

    private List<CarDto> findWinners() {
        List<CarDto> winners = new ArrayList<>();
        Distance maxDistance = findMaxDistanceOfResults();
        for (CarDto carDto : results) {
            ifMaxDistanceAddToList(winners, carDto, maxDistance);
        }
        return winners;
    }

    private Distance findMaxDistanceOfResults() {
        CarDto carDto = Collections.max(results);
        return carDto.getLocation();
    }

    private void ifMaxDistanceAddToList(List<CarDto> carDtos, CarDto carDto, Distance maxDistance) {
        if (maxDistance.equals(carDto.getLocation())) {
            carDtos.add(carDto);
        }
    }

    public List<CarDto> getResults() {
        return results;
    }

    public List<CarDto> getWinners() {
        return winners;
    }

    public boolean isEndReport() {
        return raceStatus.isEnd();
    }
}
