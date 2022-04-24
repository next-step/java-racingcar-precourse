package racingcar.domain;

import racingcar.view.Output;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static final String PRINT_FLAG_POSITION = "-";
    private final String name;
    private int position = 0;
    StringBuffer stringBuffer;

    public Car(final String name) {
        this.name = name;
    }
    public void move() {
        int random = RandomUtils.makeRandom();
        if(random >= 4) {
            this.position++;
        }
        outputResult();
    }
    public void outputResult(){
        stringBuffer = new StringBuffer(this.name);
        stringBuffer.append(" : ");
        for(int i=0; i<this.position; i++){
            stringBuffer.append(PRINT_FLAG_POSITION);
        }
        Output.outputMessage(stringBuffer.toString());
    }
    public int getPosition() {
        return this.position;
    }
    public List<String> addWinnerList(List<String> winnerList){
        List<String> returnList = new ArrayList<>(winnerList);
        returnList.add(this.name);
        return returnList;
    }
}
