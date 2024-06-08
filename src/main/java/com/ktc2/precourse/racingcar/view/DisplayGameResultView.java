package com.ktc2.precourse.racingcar.view;

import com.ktc2.precourse.racingcar.converter.WinnerListConverter;
import com.ktc2.precourse.racingcar.model.RacingCar;
import java.util.List;

/**
 * 표준 출력으로 게임 결과를 출력한다.
 */
public class DisplayGameResultView implements DisplayView<List<RacingCar>> {

    // 자동차 목록을 우승자 목록으로 변환하는 converter
    private final static WinnerListConverter converter;

    static {
        converter = new WinnerListConverter();
    }

    @Override
    public void display(List<RacingCar> data) {
        System.out.print("최종 우승자: " + converter.convertOrThrow(data)
            .toString()
            //List를 출력할 때 표시되는 대괄호[]를 제거함
            .replaceAll("[\\[\\]]", ""));
    }
}
