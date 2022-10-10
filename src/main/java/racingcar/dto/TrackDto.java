package racingcar.dto;

import racingcar.domain.Track;

public class TrackDto {

    private final String input;

    public TrackDto(String input) {
        this.input = input;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("레이싱 트랙 값은 숫자만 가능합니다.");
        }
    }

    public Track toDomain() {
        return Track.of(parseInt(input));
    }
}
