package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    Name name;
    RaceProgress raceProgress;

    public RacingCar(String name) throws IllegalArgumentException {
        this.name = new Name(name);
        this.raceProgress = new RaceProgress();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getRaceProgress() {
        return this.raceProgress.getProgress();
    }

    public void race(int number) {
        this.raceProgress.forwardProgress(number);
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        return (this.raceProgress.getProgress() > racingCar.raceProgress.getProgress()) ? 1 : -1;
    }

}