package view;

import java.util.HashMap;
import java.util.Map.Entry;

public class Result {

    public void output(HashMap<String, String> result) {
        for(Entry<String, String> x : result.entrySet()){
            System.out.println(x.getKey() + " : " + x.getValue());
        }
        System.out.println();

    }

    public void theVictor(String[] winner_list) {
        System.out.println("최종 우승자 : " + String.join(", ", winner_list));
    }
}
