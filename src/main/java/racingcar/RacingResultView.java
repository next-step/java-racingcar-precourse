package racingcar;

import java.util.List;

public class RacingResultView {

    public void getIntro() {
        System.out.println("실행 결과");
    }

    public void getPosition(Car car, int position) {
        System.out.print(car.getName() + " : ");
        for(int i = 0; i < position; i++){
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public void getWinner(List<String> winners){
        String names = String.join(",", winners);
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
