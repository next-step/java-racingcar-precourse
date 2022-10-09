package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.GameManager;
import racingcar.model.function.Function;
import racingcar.model.function.GameRestart;
import racingcar.model.function.ReadyToStart;
import racingcar.utils.InputString;
import racingcar.view.io.OutputFunction;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carName;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private List<InputString> goStack;

    public Car(InputString carName) {


        try {
            if (validLength(carName.getStrValue()) == false) {
                return;
            }
        }catch (IllegalArgumentException e){
            Function gameStart = new ReadyToStart();
            GameManager gameManager = new GameManager(gameStart);
            gameManager.next();
        }
        this.carName = carName.getStrValue();
        goStack = new ArrayList<>();
    }
    public List<InputString> getGoStack(){
        return goStack;
    }

    public static boolean validLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            OutputFunction.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }

        return true;
    }

    public void isGoAndStop(){
        int randomPickNum = Randoms.pickNumberInRange(0, 9);
        InputString goStrStack;
        if(randomPickNum>=4){
            goStrStack = new InputString("-");
            goStack.add(goStrStack);
        }
    }

    public void printGoResult(){
        String goResult ="";
        for (InputString inputString : goStack) {
            goResult +=inputString.getStrValue();
        }

        OutputFunction.print(this.carName +" : ");
        OutputFunction.println(goResult);
    }

    public String getCarName() {
        return this.carName;
    }
}
