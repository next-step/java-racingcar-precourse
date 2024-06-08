package com.ktc2.precourse.racingcar.view;

import com.ktc2.precourse.racingcar.converter.Converter;
import com.ktc2.precourse.racingcar.exception.GameException;

import java.util.Scanner;

/**
 * 사용자와 소통하며 표준 입력(System.in)으로부터 올바른 입력을 받는 뷰
 *
 * @param <D> 사용자로부터 입력받고자 하는 객체 타입
 */
public abstract class AcceptView<D> {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * AcceptView 사용시 입력 정보를 가이드하는 문자열을 반환한다.
     *
     * @return 입력 가이드 문자열
     */
    protected abstract String getInputGuide();

    /**
     * System.in 으로부터 받은 String을 D로 변환할 Converter 를 반환한다.
     *
     * @return Validator
     */
    protected abstract Converter<String, D> getConverter();

    /**
     * 표준 입력으로부터 해당하는 D를 반환한다.
     *
     * @return System.in 으로부터 변환된 객체 타입 D
     */
    public final D getDto() {
        // 입력해야 하는 형식을 가이드하고 표준 입력을 받는다.
        System.out.print(this.getInputGuide() + ": ");
        String input = scanner.nextLine();

        try {
            // Converter 로 변환을 시도한다. 실패 시 예외
            return this.getConverter().convertOrThrow(input);

        } catch (GameException e) {
            // 실패 이유를 출력하고 다시 입력을 받음(재귀적)
            System.out.println(e.getMessage());
            return this.getDto();
        }
    }
}
