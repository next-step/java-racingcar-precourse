package dto;

public record RacerResult (
        boolean isEnded,

        Iterable<RacerDto> racerDtos
) {
}
