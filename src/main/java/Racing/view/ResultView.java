package Racing.view;

import java.util.List;

//게임의 최종 결과를 보여주는 뷰. 우승자 명단을 매개변수로 받아 출력한다.
public class ResultView {
    public void printResult(List<String> winner){
        System.out.print("최종 우승자 : ");

        for(char c : winner.toString().toCharArray()){
            if (c != '[' && c != ']') {
                System.out.print(c);
            }
        }
    }

}
