package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCarsTest {

    private RaceCars raceCars = new RaceCars();


    @Test
    @DisplayName("경주 참여 자동차 저장 Test")
    void 경주_참여_자동차_저장_TEST(){
        //given
        String[] carsName = {"test1", "test2"};

        //when
        raceCars.addCars(carsName);

        //then
        assertThat(raceCars.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("경주 우승자 위치 정보 GET Test")
    void 경주_우승자_위치_GET_TEST(){
        //given
        String[] carsName = {"test1", "test2"};
        raceCars.addCars(carsName);

        //when
        for(int i=0; i<5; i++){
            raceCars.getCars().get(0).advance(i);
        }

        for(int i=0; i<5; i++){
            raceCars.getCars().get(1).advance(i+3);
        }

        //then
        assertThat(raceCars.getWinnerPosition()).isEqualTo(4);
    }

    @Test
    @DisplayName("경주 우승자 정보 GET Test")
    void 경주_우승자_정보_GET_TEST(){
        //given
        String[] carsName = {"test1", "test2", "test3"};
        raceCars.addCars(carsName);

        //when
        for(int i=0; i<5; i++){
            raceCars.getCars().get(0).advance(i);
        }

        for(int i=0; i<5; i++){
            raceCars.getCars().get(1).advance(i+3);
            raceCars.getCars().get(2).advance(i+3);
        }

        //then
        assertThat(raceCars.getWinners().size()).isEqualTo(2);
        assertThat(raceCars.getWinners().get(0).getName()).isEqualTo("test2");
        assertThat(raceCars.getWinners().get(1).getName()).isEqualTo("test3");
    }



}