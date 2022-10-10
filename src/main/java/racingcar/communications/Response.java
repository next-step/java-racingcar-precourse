package racingcar.communications;

import racingcar.views.View;

import java.util.HashMap;

public class Response {
    private View view;
    private HashMap<String, Object> context;

    public Response(View view, HashMap<String, Object> context) {
        this.view = view;
        this.context = context;
    }

    public View getView() {
        return view;
    }

    public void render() {
        this.view.setContext(this.context);
        this.view.render();
    }
}
