package racingcar.view;

import racingcar.model.racingCar;
import racingcar.utils.inputOutputMessage;
import java.util.List;
public class racingcarView {
    private static inputOutputMessage message = new inputOutputMessage();
    public void printMatchResult(List<racingCar> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getCarNameClass().getCarName() + " : " + cars.get(i).getPositionClass());
        }
    }
    public void printMatchResultWinner(String winner){
        System.out.println(message.outputMessage()+winner);
    }
}
