package controller;

import dto.RacerDto;
import dto.RacerResult;
import entity.Racer;
import utils.RandomNumberGenerator;

import java.math.BigInteger;
import java.util.*;

public class RacerController {
    public static final String VALIDATE_GAME_COUNT_ERROR_MESSAGE = "gameCount는 null이거나 음수일 수 없습니다.";

    public static final String VALIDATE_RACER_LIST_ERROR_MESSAGE = "racerList는 null이거나 빈 배열일 수 없습니다.";

    public static final String VALIDATE_GAME_ENDED_ERROR_MESSAGE = "이미 종료된 게임입니다.";

    private List<Racer> racerList;

    private BigInteger maxGameCount;

    private BigInteger currentGameCount;

    public RacerController() {
        this.racerList = new ArrayList<>();
        this.maxGameCount = new BigInteger("-1");
        this.currentGameCount = new BigInteger("-1");
    }

    /**
     * @throws IllegalArgumentException nameString이 null 또는 빈 문자열일 때, ","를 기준으로 split 했을 때 빈 문자열인 경우
     */
    public void setUp(List<String> nameList, BigInteger input) {
        validateGameCount(input);

        List<Racer> newRacerList = nameList.stream()
                .map(Racer::new)
                .toList();

        maxGameCount = input;
        currentGameCount = BigInteger.ZERO;

        racerList.clear();
        racerList.addAll(newRacerList);
    }

    public RacerResult playGame() {
        validatePlayGame();

        currentGameCount = currentGameCount.add(BigInteger.ONE);

        for (Racer racer : racerList) {
            int randomInteger = RandomNumberGenerator.getInstance().getRandomNumber(0, 9);
            racer.moveIfCan(randomInteger);
        }

        return new RacerResult(
                isEnded(),
                racerList.stream().map(this::getRacerDto).toList()
        );
    }

    public boolean isEnded() {
        return maxGameCount.equals(currentGameCount);
    }

    private RacerDto getRacerDto(Racer racer) {
        if (isEnded()) {
            return RacerDto.of(racer, getMax());
        }

        return new RacerDto(
                racer.getName(),
                racer.getMovedDistance(),
                false
        );
    }

    private BigInteger getMax() {
        if (isEnded()) {
            return racerList.stream()
                    .map(Racer::getMovedDistance)
                    .max(BigInteger::compareTo)
                    .orElseThrow(() -> new IllegalStateException(VALIDATE_RACER_LIST_ERROR_MESSAGE));
        }

        return null;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }
    }

    private void validateRacerList() {
        if (racerList == null || racerList.isEmpty()) {
            throw new IllegalStateException(VALIDATE_RACER_LIST_ERROR_MESSAGE);
        }
    }

    private void validateGameCount(BigInteger integer) {
        if (integer == null || integer.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(VALIDATE_GAME_COUNT_ERROR_MESSAGE);
        }
    }

    private void validatePlayGame() {
        validateRacerList();
        validateGameCount(maxGameCount);
        validateGameCount(currentGameCount);

        if (isEnded()) {
            throw new IllegalStateException(VALIDATE_GAME_ENDED_ERROR_MESSAGE);
        }
    }
}
