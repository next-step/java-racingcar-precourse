package controller;

import entity.Racer;

import java.util.*;
import java.util.stream.Collectors;

public class RacerController {
    private List<Racer> raceList;

    public RacerController() {
        this.raceList = new ArrayList<>();
    }

    public void setUpRacer(String nameString) {
        validateName(nameString);

        List<Racer> newRacerSet = Arrays.stream(nameString.split(","))
                .map(Racer::new)
                .toList();

        System.out.println(newRacerSet);

        raceList.clear();
        raceList.addAll(newRacerSet);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }
    }
}
