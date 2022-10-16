package racingcar.view;

import racingcar.model.Name;

import java.util.List;

public class GameResult {
    private List<Name> nameList;

    public GameResult(List<Name> nameList){
        this.nameList = nameList;
    }

    public String getGameResult(){
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < nameList.size(); i++){
            sb.append(nameList.get(i) + " ");
        }
        return sb.toString().trim().replace(" ", ",");
    }

}
