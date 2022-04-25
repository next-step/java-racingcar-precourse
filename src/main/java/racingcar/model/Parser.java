package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    /**
     * 턴 파싱 함수
     *
     * @param turnCount 파싱할 문자열
     * @return 파싱된 턴 값
     */
    public Integer parseTurn(String turnCount) {
        try {
            validateTurn(turnCount);
            return Integer.valueOf(turnCount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바르지 않은 숫자 입력");
            return null;
        }
    }

    /**
     * 턴 유효성 검증 함수
     *
     * @param turnCount 검증할 문자열
     */
    private void validateTurn(String turnCount) {
        if (!turnCount.matches("[1-9]\\d*")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 이름 파싱 함수
     *
     * @param input 파싱할 문자열
     * @return 파싱된 이름 값 리스트
     */
    public List<String> parseName(String input) {
        try {
            List<String> names = Arrays.asList(input.split(","));
            names.forEach(this::validateName);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바르지 않은 이름 입력");
            return Collections.emptyList();
        }
    }

    /**
     * 이름 유효성 검증 함수
     *
     * @param name 검증할 문자열
     */
    private void validateName(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
