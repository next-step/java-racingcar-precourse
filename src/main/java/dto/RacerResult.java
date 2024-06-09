package dto;

import java.util.Collection;

public record RacerResult (
        boolean isEnded,

        Collection<RacerDto> racerDtos
) {
}
