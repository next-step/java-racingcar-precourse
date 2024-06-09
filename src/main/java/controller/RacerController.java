package controller;

import entity.Racer;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class RacerController {
    public static final String VALIDATE_GAME_COUNT_ERROR_MESSAGE = "gameCount는 null이거나 음수일 수 없습니다.";

    private List<Racer> raceList;

    private BigInteger maxGameCount;

    private BigInteger currentGameCount;

    public RacerController() {
        this.raceList = new ArrayList<>();
        this.maxGameCount = new BigInteger("-1");
        this.currentGameCount = new BigInteger("-1");
    }

    /**
     * @throws IllegalArgumentException nameString이 null 또는 빈 문자열일 때, ","를 기준으로 split 했을 때 빈 문자열인 경우
     */
    public void setUpRacer(String nameString) {
        validateName(nameString);

        List<Racer> newRacerSet = Arrays.stream(nameString.split(","))
                .map(Racer::new)
                .toList();

        raceList.clear();
        raceList.addAll(newRacerSet);
    }

    /**
     * @throws IllegalArgumentException input이 null 또는 음수일 때
     */
    public void setUpGameCount(BigInteger input) {
        validateGameCount(input);

        maxGameCount = input;
        currentGameCount = BigInteger.ZERO;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }
    }

    private void validateGameCount(BigInteger integer) {
        if (integer == null || integer.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(VALIDATE_GAME_COUNT_ERROR_MESSAGE);
        }
    }
}
