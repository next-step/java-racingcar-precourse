package com.ktc2.precourse.racingcar.model;

import java.util.List;

/**
 * 경주 자동차 목록을 담은 DTO
 * @param racingCarList 경주 자동차 목록
 */
public record DtoRacingCarList(List<RacingCar> racingCarList) {

}
