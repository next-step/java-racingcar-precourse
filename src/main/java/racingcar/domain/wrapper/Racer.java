package racingcar.domain.wrapper;

import racingcar.enumeration.MoveStatus;
import racingcar.view.OutputView;

public class Racer {
    private final RacerName name;
    private final Location location;

    public Racer(final String name) {
        this.name = new RacerName(name);
        this.location = new Location();
    }

    public void move(final long randomNumber) {
        if (MoveStatus.isMoved(randomNumber)) {
            location.moveForward();
        }
        printCurrentDistance();
    }

    public int maxInstance(final int maxInstance) {
        return Math.max(maxInstance, location.getDistance());
    }

    public String getWinnerName(final int maxInstance) {
        if (isWinner(maxInstance)) {
            return name.getName();
        }
        return null;
    }

    private void printCurrentDistance() {
        OutputView.printEachStage(name.getName(), location.getDashDistance());
    }

    private boolean isWinner(final int maxInstance) {
        return location.getDistance() == maxInstance;
    }
}
