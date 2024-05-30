package model;

import static model.RaceCondition.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class Race {

    private final List<Car> carList;
    private int attemptCount;
    private RaceCondition raceCondition;
    private final PropertyChangeSupport support;

    public Race(List<Car> carList, int attemptCount) {
        this.carList = carList;
        this.attemptCount = attemptCount;
        raceCondition = IN_PROGRESS;
        support = new PropertyChangeSupport(this);
    }

    public void move() {
        if (canMove()) {
            moveCars();
            support.firePropertyChange("raceStatusUpdate", null, getRaceStatus());
        }
    }

    public boolean canMove() {
        return (attemptCount > 0) && (raceCondition == IN_PROGRESS);
    }

    private void moveCars() {
        attemptCount--;
        if (attemptCount == 0) {
            finishRace();
        }
        for (Car car : carList) {
            car.move();
        }
    }

    private void finishRace() {
        raceCondition = FINISHED;
        support.firePropertyChange("raceFinished", null, getWinnerList());
    }

    public List<String> getRaceStatus() {
        return carList.stream()
                .map(Car::getStatus)
                .toList();
    }

    public List<String> getWinnerList() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public RaceCondition getRaceCondition() {
        return raceCondition;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
