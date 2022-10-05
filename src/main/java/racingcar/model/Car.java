package racingcar.model;

import static racingcar.common.Constants.*;

import java.util.Objects;

/**
 * Value Object of Main Domain
 */
public class Car {
    private final String name;

    private Progress currentProgress;

    private Car(String name, int progress) {
        this.name = name;
        this.currentProgress = Progress.from(progress);
    }

    /**
     * Car creation method
     *
     * @param name     name of car
     * @param progress progress of car
     * @return new Car
     */
    public static Car valueOf(String name, int progress) {
        return new Car(name, progress);
    }

    /**
     * Returns the name of the car.
     *
     * @return name of car
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representing the progress of the car as "PROGRESS PARTICLE".
     *
     * @return a string representing the progress of the car as "PROGRESS PARTICLE"
     */
    private String getProgressString() {
        String result = "";
        for (int i = 0; i < currentProgress.getProgress(); i++) {
            result = result.concat(PROGRESS_PARTICLE);
        }
        return result;
    }

    public int getProgress() {
        return currentProgress.getProgress();
    }

    /**
     * Increases the Car's Progress.
     */
    public void increaseProgress() {
        this.currentProgress = this.currentProgress.increaseProgress(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.concat(" : ").concat(getProgressString());
    }
}
