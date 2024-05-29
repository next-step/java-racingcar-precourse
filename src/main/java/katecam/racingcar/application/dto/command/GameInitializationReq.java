package katecam.racingcar.application.dto.command;

import java.util.List;

public record GameInitializationReq(
        List<String> carNames,
        int numberToAttempt
) {

    public GameInitializationReq{
        if (carNames == null || carNames.isEmpty())
            throw new IllegalArgumentException("리스트 비었음");

        carNames.forEach(name-> {
                    if (name == null || name.length() < 5)
                        throw new IllegalArgumentException("5자리 이상 입력");
                });

        if (numberToAttempt <= 0)
            throw new IllegalArgumentException("올바른 시도 횟수 입력");
    }
}
