package com.ktc2.precourse.racingcar.converter;

import com.ktc2.precourse.racingcar.Config;
import com.ktc2.precourse.racingcar.exception.*;
import com.ktc2.precourse.racingcar.model.DtoRacingCarList;
import com.ktc2.precourse.racingcar.model.RacingCar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * String을 DtoRacingCarList로 변환하는 converter
 */
public class RacingCarListConverter extends Converter<String, DtoRacingCarList> {

    private final static int nameMin = Config.CAR_NAME_MIN_LENGTH;
    private final static int nameMax = Config.CAR_NAME_MAX_LENGTH;
    private final static String spliter = Config.CAR_NAME_SPLITTER;

    private Optional<String> anyHasInvalidLength(List<String> token) {
        return token.parallelStream()
            //길이 조건을 불만족하는 요소를 찾기
            .filter(name -> !(nameMin <= name.length() && name.length() <= nameMax))
            .findAny();
    }

    private Optional<String> anyContainsWhiteSpace(List<String> token) {
        return token.parallelStream()
            //공백이 들어가지 않은 요소를 찾기
            .filter(name -> name.matches(".*\\s.*"))
            .findAny();
    }

    /**
     * String을 DtoRacingCarList로 변환함
     *
     * @param input DtoRacingCarList로 변환할 String
     * @return 경주 자동차 목록을 저장하고 있는 DTO
     * @throws InvalidCarNameLengthException        자동차 이름 중 하나가 기대되는 길이를 만족하지 못 한 경우
     * @throws ContainsWhiteSpaceToCarNameException 자동차 이름 중 하나가 공백 문자를 포함한 경우
     */
    @Override
    public DtoRacingCarList convertOrThrow(String input) throws GameException {
        //input string을 구분자로 구분함
        List<String> token = Stream.of(
                input.split(spliter, -1)
            )
            .map(String::trim)
            .toList();

        //이름 중 길이 조건을 만족하지 않은 이름이 있는 경우
        anyHasInvalidLength(token).ifPresent(name -> {
            throw new InvalidCarNameLengthException(name);
        });

        //이름 중 공백이 포함된 이름이 있는 경우
        anyContainsWhiteSpace(token).ifPresent(name -> {
            throw new ContainsWhiteSpaceToCarNameException(name);
        });

        //DTO를 반환한다.
        return new DtoRacingCarList(
            token.stream().map(RacingCar::new).collect(Collectors.toList()));
    }
}
