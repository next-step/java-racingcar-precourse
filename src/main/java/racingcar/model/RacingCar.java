package racingcar.model;

import racingcar.util.Message;
import racingcar.util.RacingGameUtil;
import racingcar.view.OutputView;

public class RacingCar {

    private final String name;

    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrNot(int number) {
        if(number >= RacingGameUtil.MOVABLE_NUMBER) {
            position++;
        }
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName());
        sb.append(Message.SEPARATOR.getMessage());
        for(int i=0; i<getPosition(); i++) {
            sb.append(Message.DASH.getMessage());
        }

        OutputView.print(sb.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
