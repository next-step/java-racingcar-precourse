package camp.nextstep.edu.presenter.dto.request;

public class Request {
    private final String content;

    public Request(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static Request of(String content) {
        return new Request(content);
    }
}