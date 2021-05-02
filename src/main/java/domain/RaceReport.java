package domain;

import dto.CarDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceReport {
    private List<CarDto> results;

    public RaceReport(List<CarDto> results) {
        this.results = results;
    }

    public List<CarDto> findWinners() {
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
}
