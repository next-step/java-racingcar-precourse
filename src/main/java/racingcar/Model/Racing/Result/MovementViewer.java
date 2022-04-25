package racingcar.Model.Racing.Result;

import java.util.ArrayList;
import java.util.List;

public class MovementViewer {
    private final List<String> MovementsView = new ArrayList<>();

    public void setMovementsView(String movementString) {
        this.MovementsView.add(movementString);
    }

    public void startMoving() {
        System.out.println("실행 결과");
        for (String movementsString : this.MovementsView) {
            System.out.printf("%s \n", movementsString);
        }
    }
}
