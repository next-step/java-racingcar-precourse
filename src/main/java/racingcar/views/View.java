package racingcar.views;

import racingcar.communications.Method;

import java.util.HashMap;

public class View {

    private final HashMap<String, String> requestData;
    private HashMap<String, Object> context;

    public View() {
        this.requestData = new HashMap<>();
        this.context = new HashMap<>();
    }

    public HashMap<String, Object> getContext() {
        return this.context;
    }


    public HashMap<String, String> getRequestData() {
        return this.requestData;
    }

    public void render() {
    }

    public void setContext(HashMap<String, Object> context) {
        this.context = context;
    }
}

