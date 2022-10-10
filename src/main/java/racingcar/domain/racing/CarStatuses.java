package racingcar.domain.racing;

import static racingcar.utils.ValidationUtils.requireNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CarStatuses {
    private static final int FIRST_ELEMENT = 0;
    private final List<CarStatus> elements;

    public CarStatuses(List<CarStatus> elements) {
        requireNotNull(elements, "The car status list should not be null!");
        this.elements = elements;
    }

    public List<CarStatus> toList() {
        return Collections.unmodifiableList(this.elements);
    }

    public CarStatuses filterHighestDistanceCars() {
        final CarStatuses sorted = sortedByDistanceDescending();
        final CarStatus highestStatus = sorted.first();
        final int highestDistance = highestStatus.getDistanceFromStartingPoint();

        return sorted.filterEqualToDistance(highestDistance);
    }

    private CarStatuses sortedByDistanceDescending() {
        final List<CarStatus> sortedList = new ArrayList<>(this.elements);
        sortedList.sort(Comparator.comparing(CarStatus::getDistanceFromStartingPoint));
        Collections.reverse(sortedList);
        return new CarStatuses(sortedList);
    }

    private CarStatus first() {
        final CarStatus firstElement = this.elements.get(FIRST_ELEMENT);
        if (Objects.isNull(firstElement)) {
            throw new IllegalStateException("First car status does not exist!");
        }
        return firstElement;
    }

    private CarStatuses filterEqualToDistance(int highestDistance) {
        final List<CarStatus> result = new ArrayList<>();
        for (CarStatus status : this.elements) {
            addIfStatusDistanceIsEqualTo(highestDistance, result, status);
        }
        return new CarStatuses(result);
    }

    private void addIfStatusDistanceIsEqualTo(int highestDistance, List<CarStatus> result, CarStatus status) {
        if (status.getDistanceFromStartingPoint() == highestDistance) {
            result.add(status);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarStatuses that = (CarStatuses) o;
        return elements.equals(that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
