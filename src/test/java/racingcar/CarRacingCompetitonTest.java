package racingcar;

import exception.ExceptionWrapper;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CarRacingCompetition;

public class CarRacingCompetitonTest {


    CarRacingCompetitonTest(){
        자동차_명단의_null_체크();
        자동차_명단의_구분자_체크();
        참여_자동차명의_공백값_여부_확인();
        참가_자동차_이름_길이_확인();
        참가_자동차_명단_등록();
        시도_횟수_유효성_확인();
    }

    @Test
    @DisplayName("시도_횟수_유효성_확인")
    void 시도_횟수_유효성_확인(){
        Assertions.assertThatThrownBy(
                        ()-> {
                            CarRacingCompetition carRacingCompetition
                                    = CarRacingCompetition.getCarRacingCompetion("shin,jin") ;
                            carRacingCompetition.startRacing("5s");
                        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 다른 값이 입력되었습니다.");
        Assertions.assertThatThrownBy(
                        ()-> {
                            CarRacingCompetition carRacingCompetition
                                    = CarRacingCompetition.getCarRacingCompetion("shin,jin") ;
                            carRacingCompetition.startRacing("-2147483648");
                        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("0 미만의 숫자값이 입력되었습니다.");
    }

    @Test
    @DisplayName("참가_자동차_이름_길이_확인")
    void 참가_자동차_이름_길이_확인(){
        Assertions.assertThatThrownBy(
                ()->CarRacingCompetition.getCarRacingCompetion("shins,jin  s"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("참가 자동차의 이름이 6글자 이상입니다.");
    }

    @Test
    @DisplayName("참가_자동차_명단_등록")
    void 참가_자동차_명단_등록(){
        Assertions.assertThatNoException().isThrownBy(
                ()-> CarRacingCompetition.getCarRacingCompetion("shin,jin")
        );
    }

    @Test
    @DisplayName("자동차_명단의_null_체크")
    void 자동차_명단의_null_체크(){
        Assertions.assertThatThrownBy(()->CarRacingCompetition.getCarRacingCompetion(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("참여하는 자동차의 명단이 null 입니다.");
    }

    @Test
    @DisplayName("자동차_명단의_구분자_체크")
    void 자동차_명단의_구분자_체크(){
        Assertions.assertThatThrownBy(()-> CarRacingCompetition.getCarRacingCompetion("shin,,jin"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(",가 2개 이상 연속적으로 입력되었습니다.");
        Assertions.assertThatThrownBy(()-> CarRacingCompetition.getCarRacingCompetion("shin,,,jin"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(",가 2개 이상 연속적으로 입력되었습니다.");
    }

    @Test
    @DisplayName("참여_자동차명의_공백값_여부_확인")
    void 참여_자동차명의_공백값_여부_확인(){
        Assertions.assertThatThrownBy(()-> CarRacingCompetition.getCarRacingCompetion("shin, , ,jin"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여 자동차명이 공백값 입니다.");
    }
}
