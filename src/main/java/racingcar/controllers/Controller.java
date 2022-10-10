package racingcar.controllers;

import racingcar.communications.Method;
import racingcar.communications.Request;
import racingcar.communications.Response;

import java.util.HashMap;

public class Controller {

    public Response dispatch(Request request) {

        Method reqMethod = request.getMethod();

        if (reqMethod == Method.GET) {
            return this.get(request);
        }
        return this.post(request);
    }

    public HashMap<String, Object> getContextData(Request request) {
        return new HashMap<>();
    }

    public Response get(Request request) {
        return null;
    }

    public Response post(Request request) {
        return null;
    }
}
