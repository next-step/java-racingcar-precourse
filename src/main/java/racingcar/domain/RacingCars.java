package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(List<String> names) {
        validateCarsCount(names);
        validateCarDuplication(names);
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(RacingCar.of(name));
        }
        return new RacingCars(racingCars);
    }

    public List<RacingCar> getCars() {
        return racingCars;
    }

    public void moveAll() {
        for (RacingCar car : racingCars) {
            car.move();
        }
    }

    public String getWinnersName() {
        Integer maxOffset = 0;
        String winnersName = "";
        List<RacingCar> sortedRacingCars = getSortedRacingCars();
        for (RacingCar racingCar : sortedRacingCars) {
            maxOffset = getMaxOffset(maxOffset, racingCar);
            winnersName += getWinnerName(maxOffset, racingCar);
        }
        return winnersName.trim().replace(" ", ", ");
    }

    private List<RacingCar> getSortedRacingCars() {
        Comparator<RacingCar> comparator = (rc1, rc2) -> rc2.getOffset() - rc1.getOffset();
        List<RacingCar> sortedRacingCars = new ArrayList<>(racingCars);
        sortedRacingCars.sort(comparator);
        return sortedRacingCars;
    }

    private Integer getMaxOffset(Integer maxOffset, RacingCar racingCar) {
        if (maxOffset <= racingCar.getOffset()) {
            return racingCar.getOffset();
        }
        return maxOffset;
    }

    private String getWinnerName(Integer maxOffset, RacingCar racingCar) {
        if (maxOffset.equals(racingCar.getOffset())) {
            return " " + racingCar.getName();
        }
        return "";
    }

    private static void validateCarDuplication(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            throw new IllegalArgumentException("[ERROR] 동일한 이름의 차량을 등록할 수 없습니다");
        }
    }

    private static void validateCarsCount(List<String> names) {
        if (names.size() <= 1) {
            throw new IllegalArgumentException("[ERROR] 차량을 1대이하로 등록할 수 없습니다");
        }
    }
}
