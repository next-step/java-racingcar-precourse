package racingcar.controllers;

import racingcar.communications.Request;
import racingcar.communications.Response;
import racingcar.models.Car;
import racingcar.models.GameCount;
import racingcar.models.Racing;
import racingcar.models.RacingVO;
import racingcar.views.RacingView;
import racingcar.views.View;

import java.util.HashMap;

public class RacingController extends Controller {
    public View getView(Request request) {
        return new RacingView();
    }

    public Car[] cleanCarNames(String rawCarNames) {
        String[] carNames = rawCarNames.split(",");
        Car[] result = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            result[i] = new Car(carNames[i]);
        }
        return result;
    }

    public GameCount cleanGameCount(String rawGameCount) {
        return new GameCount(rawGameCount);
    }

    public RacingVO clean(HashMap<String, String> data) {
        Car[] cars = this.cleanCarNames(data.getOrDefault("carNames", ""));
        GameCount gameCount = this.cleanGameCount(data.getOrDefault("gameCount", "0"));
        return new RacingVO(cars, gameCount);
    }

    public Response post(Request request) {
        HashMap<String, String> body = request.getBody();
        HashMap<String, Object> context = this.getContextData(request);
        RacingVO cleanedData = this.clean(body);
        Racing racing = new Racing(cleanedData);
        racing.run();

        context.put("racing", racing);
        return new Response(this.getView(request), context);
    }
}
