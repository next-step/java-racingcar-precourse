package dto;

import entity.Racer;

import java.math.BigInteger;

public record RacerDto(
        String name,

        BigInteger movedDistance,

        boolean isWinner
) {
    public static RacerDto of(Racer racer, BigInteger input) {
        return new RacerDto(
                racer.getName(),
                racer.getMovedDistance(),
                racer.isWinner(input)
        );
    }
}
