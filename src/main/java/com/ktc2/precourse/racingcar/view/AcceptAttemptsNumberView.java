package com.ktc2.precourse.racingcar.view;

import com.ktc2.precourse.racingcar.converter.Converter;
import com.ktc2.precourse.racingcar.converter.AttemptsNumberConverter;
import com.ktc2.precourse.racingcar.model.DtoAttemptsNumber;

/**
 * 표준 입력으로부터 DtoAttemptsNumber(시도 횟수)를 입력받는 클래스
 */
public class AcceptAttemptsNumberView extends AcceptView<DtoAttemptsNumber> {

    private final static AttemptsNumberConverter converter = new AttemptsNumberConverter();

    @Override
    protected String getInputGuide() {
        return "시도 횟수를 입력하세요";
    }

    @Override
    protected Converter<String, DtoAttemptsNumber> getConverter() {
        return converter;
    }
}
