package racingcar.dto;

import racingcar.domain.Name;

public class WinnerDto {
    private String name;

    public WinnerDto(Name name) {
        this.name = name.getNameString();
    }

    public String getName() {
        return name;
    }
}
