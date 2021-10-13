package racinggame.domain;

public class RacingGame {
    private final Cars cars;
    private final RaceNum raceNum;
    private AllRaceStates allRaceStates;
    private MaxGoCount maxGoCount;
    private Winners winners;

    public RacingGame(CarNames carNames, RaceNum raceNum) {
        this.cars = new Cars(carNames);
        this.raceNum = raceNum;
        setGameResult();
    }

    public MaxGoCount getMaxGoCount() {
        return maxGoCount;
    }

    public AllRaceStates getAllRaceStates() {
        return allRaceStates;
    }

    public Winners getWinners() {
        return winners;
    }

    public RaceStates getRaceStates() {
        RaceStates raceStates = new RaceStates();
        for (Car car : cars.getCars()) {
            CarMovement currentCarMovement = new CarMovement(car.getCarMovements());
            Car currentCar = new Car(car.getCarName(), currentCarMovement, car.getGoCount());
            raceStates.add(currentCar);
            setMaxGoCount(car.getGoCount());
        }
        return raceStates;
    }

    private void setMaxGoCount(GoCount goCount) {
        if (maxGoCount.getMaxGoCount().compareTo(goCount) < 0) {
            maxGoCount.setMaxGoCount(goCount);
        }
    }

    private void setAllRaceStates() {
        for (int raceIdx = 0; raceIdx < raceNum.getRaceNum(); raceIdx++) {
            goRace();
        }
    }

    private void setWinners() {
        for (Car car : cars.getCars()) {
            winners.addWinners(car, maxGoCount);
        }
    }

    private void setGameResult() {
        initializeGame();
        setAllRaceStates();
        setWinners();
    }

    private void initializeGame() {
        maxGoCount = new MaxGoCount();
        allRaceStates = new AllRaceStates();
        winners = new Winners();
    }

    private void goRace() {
        cars.moveCars();
        allRaceStates.add(getRaceStates());
    }
}
