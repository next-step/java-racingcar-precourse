package camp.nextstep.edu.presenter.dto.request;

public record Request(String content) {

    public static Request of(String content) {
        return new Request(content);
    }
}