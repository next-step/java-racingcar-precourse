package Views;

import java.util.List;

public class Result {
    public static void printResult(List<String> res){
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < res.size()-1 ; i++) {
            System.out.print(res.get(i) + ", ");
        }
        System.out.println(res.get(res.size()-1));
    }
}
