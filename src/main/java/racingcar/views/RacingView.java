package racingcar.views;

import racingcar.models.Car;
import racingcar.models.Racing;

import java.util.ArrayList;

public class RacingView extends View {

    @Override
    public void render() {
        System.out.println("게임 실행 결과\n");
        Racing racing = (Racing) this.getContext().get("racing");
        System.out.println(racing.getResults().toString());
        Car[] cars = racing.getWinners(racing.getScores());
        ArrayList<String> arrNames = new ArrayList<>();
        for (Car car : cars) {
            arrNames.add(car.getName());
        }
        String prefix = arrNames.size() > 1 ? "공동 우승자" : "최종 우승자";
        System.out.printf("%S : %s", prefix, String.join(",", arrNames));
    }
}
