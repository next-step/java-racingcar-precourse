package katecam.racingcar.application.dto.query;

import java.util.List;

public record GameTotalResultRes(List<String> winners) {

    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(", ", winners);
    }
}
