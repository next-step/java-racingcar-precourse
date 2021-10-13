package racinggame.domain.cars;

import nextstep.utils.Randoms;
import racinggame.domain.constants.Numbers;
import racinggame.domain.constants.Status;

import static racinggame.domain.constants.Status.FORWARD;

public class Car implements Comparable<Car> {

    private final String name;
    private int forwardingCount;

    public Car(String name) {
        this.name = name;
        this.forwardingCount = 0;
    }

    public String getName() {
        return name;
    }

    public String forward() {

        forwardingCount++;
        return showResult();
    }

    public String stop() {
        return showResult();
    }

    public String showResult() {

        StringBuilder forwardingStatus = new StringBuilder();
        forwardingStatus.append(name).append(Status.NAMING_COLON.getMessage());
        for (int i = 0; i < forwardingCount; i++) {
            forwardingStatus.append(FORWARD.getMessage());
        }
        return forwardingStatus.toString();
    }

    public String judgeToStopOrForward(int random) {
        if (Numbers.MIN_NO <= random && random < Numbers.STANDARD_FORWARD) return stop();

        return forward();
    }

    public int getRandomValueBetweenOneAndNine() {
        return Randoms.pickNumberInRange(Numbers.MIN_NO, Numbers.MAX_NO);
    }

    public int getForwardingCount() {
        return forwardingCount;
    }

    @Override
    public int compareTo(Car car) {
        return car.getForwardingCount() - forwardingCount;
    }
}
