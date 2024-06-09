package service;

import domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {
    RacingCarService racingCarService = new RacingCarService();

    @Test
    @DisplayName("[save()] 레이싱 카 객체들 저장 테스트")
    void saveRacingCarList(){
        //given
        RacingCar racingCar1 = new RacingCar("kim");
        RacingCar racingCar2 = new RacingCar("yu");
        RacingCar racingCar3 = new RacingCar("lee");
        List<RacingCar> racingCarList = List.of(racingCar1, racingCar2, racingCar3);

        //when
        racingCarService.save(racingCarList);

        //then
        assertThat(racingCarService.getRacingCarList().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[checkMaxMove()] 레이싱 카들 중 가장 먼 거리 반환 테스트")
    void getMaxMove(){
        //given
        RacingCar racingCar1 = new RacingCar("kim",5);
        RacingCar racingCar2 = new RacingCar("yu",3);
        RacingCar racingCar3 = new RacingCar("lee",2);
        List<RacingCar> racingCarList = List.of(racingCar1, racingCar2, racingCar3);
        racingCarService.save(racingCarList);

        //when
        int max = racingCarService.checkMaxMove();

        //then
        assertThat(max).isEqualTo(5);
    }

    @Test
    @DisplayName("[getWinners()] 최종 우승자가 한 명인 경우 반환 테스트")
    void test_getWinners_one(){
        //given
        RacingCar racingCar1 = new RacingCar("kim",5);
        RacingCar racingCar2 = new RacingCar("yu",3);
        RacingCar racingCar3 = new RacingCar("lee",2);
        List<RacingCar> racingCarList = List.of(racingCar1, racingCar2, racingCar3);
        racingCarService.save(racingCarList);

        //when
        List<RacingCar> winnerList = racingCarService.getWinners();

        //then
        assertThat(winnerList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("[getWinners()] 최종 우승자가 여러 명인 경우 반환 테스트")
    void test_getWinner_several(){
        //given
        RacingCar racingCar1 = new RacingCar("kim",5);
        RacingCar racingCar2 = new RacingCar("yu",3);
        RacingCar racingCar3 = new RacingCar("lee",2);
        RacingCar racingCar4 = new RacingCar("cho",5);
        List<RacingCar> racingCarList = List.of(racingCar1, racingCar2, racingCar3, racingCar4);
        racingCarService.save(racingCarList);

        //when
        List<RacingCar> winnerList = racingCarService.getWinners();

        //then
        assertThat(winnerList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("[generateRandomNumber()] 랜덤 값이 0~9 범위 내로 생성되는 지 테스트")
    void check_generateRandomNumber_Range(){
        int num = racingCarService.generateRandomNumber();
        assertThat(num).isBetween(0,9);
    }

//    @Test
//    @DisplayName("[playRound()] 정상작동 테스트")
//    void check_playRound(){
//        //given
//        RacingCar racingCar1 = new RacingCar("kim");
//        RacingCar racingCar2 = new RacingCar("yu");
//        RacingCar racingCar3 = new RacingCar("lee");
//        List<RacingCar> racingCarList = List.of(racingCar1, racingCar2, racingCar3);
//        racingCarService.save(racingCarList);
//
//        racingCarService.playRound();
//
//        assertThat(racingCarService.getRacingCarList()).isEqualTo(racingCarList); //모든 객체가 다 바뀌어서 안됨..
//    }
}