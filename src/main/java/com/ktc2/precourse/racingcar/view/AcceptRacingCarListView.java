package com.ktc2.precourse.racingcar.view;

import com.ktc2.precourse.racingcar.converter.RacingCarListConverter;
import com.ktc2.precourse.racingcar.converter.Converter;
import com.ktc2.precourse.racingcar.model.DtoRacingCarList;

/**
 * 표준 입력으로부터 DtoRacingCarList(경주 자동차 목록)를 입력받는 클래스
 */
public class AcceptRacingCarListView extends AcceptView<DtoRacingCarList> {

    private final static Converter<String, DtoRacingCarList> converter = new RacingCarListConverter();
    private boolean firstGuide = true;

    @Override
    protected String getInputGuide() {
        //처음 가이드하는 경우 입력 형식을 상세히 가이드한다.
        if (firstGuide) {
            firstGuide = false;
            return "경주할 자동차들의 이름을 입력하세요(이름은 쉼표(,)로 구분되며 공백없는 1~5자여야 함)";
        }

        //한 번 가이드하면 간략히 가이드한다.
        return "경주할 자동차들의 이름을 입력하세요";
    }

    @Override
    protected Converter<String, DtoRacingCarList> getConverter() {
        return converter;
    }
}
