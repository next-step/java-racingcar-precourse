package racingcar.communications;

import java.util.HashMap;

public class Request {
    private final Method method;
    private final HashMap<String, String> body;

    public Request(Method method, HashMap<String, String> body) {
        this.method = method;
        this.body = body;
    }

    public HashMap<String, String> getBody() {
        return body;
    }

    public Method getMethod() {
        return method;
    }
}
