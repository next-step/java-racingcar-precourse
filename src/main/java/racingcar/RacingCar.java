package racingcar;

public class RacingCar implements Comparable<RacingCar> {

    private final RacingCarName racingCarName;

    private final RacingCarStatus racingCarStatus;

    public RacingCar(String racingCarName) {
        this.racingCarName = new RacingCarName(racingCarName);
        this.racingCarStatus = new RacingCarStatus();
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }

    public RacingCarStatus getRacingCarStatus() {
        return this.racingCarStatus;
    }

    public void command(CommandCount commandCount) {
        for (int i = 0; i < commandCount.getCommandCount(); i++) {
            runCommand();
        }
    }

    private void runCommand() {
        RacingCarCommand racingCarCommand = new RacingCarCommand();
        if (racingCarCommand.isMoveCommand()) {
            racingCarStatus.move();
        }
        if (racingCarCommand.isStopCommand()) {

        }
    }

    @Override
    public String toString() {
        return racingCarName + " : " + racingCarStatus;
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        return this.racingCarStatus.compareTo(racingCar.racingCarStatus);
    }
}
