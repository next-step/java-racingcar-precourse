package racingcar.dto;

import java.util.List;

public class CarRecordDto {
    private final String name;
    private final List<Integer> positions;
    private final boolean winner;

    public CarRecordDto(String name, List<Integer> positions, boolean winner) {
        this.name = name;
        this.positions = positions;
        this.winner = winner;
    }

    public String getName() {
        return name;
    }

    public int getPosition(int index) {
        return positions.get(index);
    }

    public boolean isWinner() {
        return winner;
    }
}
