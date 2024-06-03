import java.util.Map.Entry;
import java.util.Random;

import model.GameStatus;

import Show;

public static class OverallController() {
    GameStatus status = new GameStatus();
    Show show = new Show()

    public void start(){
        gameInit(show.nameInit());

        numberInit(show.numInit());

        while(noWinner()){
            show.currentStatus(status);
            moveFoward();
        }

        show.winner(status)
    }

    public void gameInit(String name){
        String[] names = splitString(name);
        status.initTryCurrent(names);
    }

    public String[] splitString(String str){
        return str.split(",");
    }

    public void numberInit(int num){
        status.setTryGoal(num);
    }
}

    public void moveFoward(){
        for(Integer i : status.getTryCurrent().keySet()){ //저장된 key값 확인
             if(getRandom()){
                 status.updateTryCurrent(ststus.getTryCurrent().get(i););
             }
        }
    }

    public boolean getRandom(){
        Random rand = new Random();
        boolean ans = false
        if(rand.nextInt(10) > 3){
            ans = true;
        }
        return ans;
    }

    public boolean noWinner(){
        boolean result = true;
        for (Entry<String, Integer> entry : status.getTryCurrent().entrySet()) {
            if(entry.getValue() == status.getTryGoal()) {
                result = false;
                status.setWinners(enrty.getKey());
            }
        return result;
    }
}
