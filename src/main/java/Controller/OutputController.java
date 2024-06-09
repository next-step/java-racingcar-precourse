package Controller;

import java.util.Map;
import java.util.Set;

public class OutputController {

    public void printRaceLog(Map<String, Integer> raceLog) {
        String printString = "";

        for(String s : raceLog.keySet()){
            printString += s + " : " + positionMaker(raceLog.get(s))+"\n";
        }

        System.out.println(printString);
    }

    public void printRaceWinner(Set<String> fastCarName) {
        String printString = "최종 우승자 : ";

        for(String s : fastCarName){
            printString += s+", ";
        }
        System.out.println(printString.substring(0,printString.length()-2));

    }

    private String positionMaker(int count){
        String s = "";
        for(int i=0;i<count;i++){
            s+="-";
        }
        return s;
    }
}
