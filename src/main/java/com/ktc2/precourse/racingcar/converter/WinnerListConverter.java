package com.ktc2.precourse.racingcar.converter;

import com.ktc2.precourse.racingcar.exception.GameException;
import com.ktc2.precourse.racingcar.model.RacingCar;
import java.util.List;

/**
 * 경주 자동차 목록을 우승자 목록으로 변환하는 converter
 */
public class WinnerListConverter extends Converter<List<RacingCar>, List<String>> {

    /**
     * 경주 자동차 목록을 우승자 목록으로 변환함
     *
     * @param input 우승자 목록을 구할 경주 자동차 목록
     * @return 우승자 목록
     * @throws GameException 예외를 반환하지 않음
     */
    @Override
    public List<String> convertOrThrow(List<RacingCar> input) throws GameException {
        //경주 자동차 중 가장 큰 position을 구한다.
        int maxPosition = input.stream()
            .mapToInt(RacingCar::position)
            .max()
            .orElse(-1);

        //가장 큰 position을 가진 경주 자동차 목록을 반환한다.
        return input.stream()
            .filter(car -> car.position() == maxPosition)
            .map(RacingCar::name)
            .toList();
    }
}
