package racingcar.domain.dto;

import java.util.List;

public class PlayHistories {

    private final List<PlayHistory> playHistories;

    public PlayHistories(List<PlayHistory> playHistories) {
        this.playHistories = playHistories;
    }

    public List<PlayHistory> getPlayHistories() {
        return playHistories;
    }
}