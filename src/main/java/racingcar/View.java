package racingcar;

import java.util.ArrayList;
import java.util.List;

public class View {
    public void startGame(){
        innerCarName();
        innerTryCount();
        Application.contorller.resultRacing();
    }

    public void innerCarName(){
        List<String> carNameList = new ArrayList<>();
        try{        
            Application.contorller.data.inItCarNameList();
            System.out.println(Message.carInfoString);
            String carName = camp.nextstep.edu.missionutils.Console.readLine();
            Application.contorller.nameCheck(carName);
        }catch(IllegalArgumentException il){
            System.out.println("[ERROR]" + il.getMessage());
            innerCarName();
        }
    }

    public void innerTryCount(){
        try{
            Application.contorller.data.inItTryCount();
            System.out.println(Message.tryCountInfoString);
            String tryCount = camp.nextstep.edu.missionutils.Console.readLine();
            Application.contorller.tryCountCheck(tryCount);
        }catch(IllegalArgumentException il){
            System.out.println("[ERROR]" + il.getMessage());
            innerTryCount();
        }
    }
}
