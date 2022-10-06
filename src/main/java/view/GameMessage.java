package view;

import java.util.Map;

public class GameMessage {
    public void getCarNAmeMessage(){
        System.out.println("경주할자동차이름(이름은쉼표(,)기준으로구분)");
    }
    public void getGameNumberMessage(){
        System.out.println("시도할 횟수");
    }

    public void getCarState(String name, int state){
        String position="";
        for(int i =0;i<state;i++){
            position+="-";
        }
        System.out.println(name +" : " + position);
    }
    public void showWinner(String winner){
        System.out.println("최종 우승자 : " + winner.substring(0,winner.length()-1));
    }
}
