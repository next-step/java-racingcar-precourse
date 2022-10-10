package racingcar;

import racingcar.communications.Method;
import racingcar.communications.Request;
import racingcar.communications.Response;
import racingcar.controllers.Controller;
import racingcar.controllers.GameLandingController;
import racingcar.controllers.RacingController;
import racingcar.views.View;

import java.util.HashMap;

public class Application {

    public static Response handleLandingController() {
        Request req = new Request(Method.GET, new HashMap<>());
        Controller landingController = new GameLandingController();
        Response response = landingController.dispatch(req);
        response.render();
        return response;
    }

    public static Response handleRacingController(HashMap<String, String> reqData) {
        Controller racingController = new RacingController();
        Response response = racingController.dispatch(new Request(Method.POST, reqData));
        response.render();
        return response;
    }
    public static void main(String[] args) {
        try {
            Response response = handleLandingController();
            View view = response.getView();

            handleRacingController(view.getRequestData());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
}
