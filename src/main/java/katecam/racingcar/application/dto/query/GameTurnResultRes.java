package katecam.racingcar.application.dto.query;

import java.util.List;

public record GameTurnResultRes(List<CarPositionRes> carPositions) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.carPositions.forEach(carPosition ->
                        sb.append(carPosition.carName())
                                .append(" : ")
                                .append("-".repeat(carPosition.position()))
                                .append("\n")
                );
        return sb.toString();
    }
}