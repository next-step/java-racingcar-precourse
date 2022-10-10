package racingcar.controllers;

import racingcar.communications.Request;
import racingcar.communications.Response;
import racingcar.views.GameLandingView;
import racingcar.views.View;

import java.util.HashMap;

public class GameLandingController extends Controller {

    public View getView(Request request) {
        return new GameLandingView();
    }

    public Response get(Request request) {
        return new Response(this.getView(request), this.getContextData(request));
    }
    public Response post(Request request) {
        return new Response(this.getView(request), this.getContextData(request)); // TODO: 에러 반환
    }
}
