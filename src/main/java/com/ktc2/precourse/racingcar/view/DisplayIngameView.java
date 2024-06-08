package com.ktc2.precourse.racingcar.view;

import com.ktc2.precourse.racingcar.model.RacingCar;
import java.util.List;

/**
 * 표준 출력으로 게임 중인 상황을 출력한다.
 */
public class DisplayIngameView implements DisplayView<List<RacingCar>> {

    @Override
    public void display(List<RacingCar> data) {
        data.forEach(System.out::println);
        System.out.println();
    }
}
