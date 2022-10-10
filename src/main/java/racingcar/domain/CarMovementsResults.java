package racingcar.domain;

import java.util.List;

public class CarMovementsResults {

    private final List<CarMovementsResult> carMovementsResults;

    public CarMovementsResults(List<CarMovementsResult> carMovementsResults) {
        this.carMovementsResults = carMovementsResults;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        for (CarMovementsResult carMovementsResult : carMovementsResults) {
            result.append(carMovementsResult.toString());
            result.append("\n");
        }

        return result.toString();
    }
}
