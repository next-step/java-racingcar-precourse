package Controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Model.Car;

import Util.NameValidity;
import Util.NumberValidity;
import Util.CarMovement;

import java.io.IOException;

class ApplicationTest {
    @Test
    @DisplayName("이름이 , 로 구분이 잘되는지 테스트")
    void 문자열분리테스트()throws IOException {
        Game game = new Game();
        String name = "A,B,C,D";
        game.separateName(name);
        assertThat(game.getBeforeCheckCarNames()[0]).isEqualTo("A");
        assertThat(game.getBeforeCheckCarNames()[1]).isEqualTo("B");
        assertThat(game.getBeforeCheckCarNames()[2]).isEqualTo("C");
        assertThat(game.getBeforeCheckCarNames()[3]).isEqualTo("D");
    }

    @Test
    @DisplayName("올바른 이름의 입력이 이루어지는지 테스트")
    void 자동차이름입력_테스트()throws IOException{
        // 올바른 입력
        String correctName = "pobi";
        assertThat(NameValidity.checkNameValidity(correctName)).isEqualTo(true);
        // 공백 포함
        String incorrectNameBlank = "po bi";
        assertThat(NameValidity.checkNameValidity(incorrectNameBlank)).isEqualTo(false);
        // 영어로 이루어져있지 않음
        String incorrectNameNotEnglish = "4비";
        assertThat(NameValidity.checkNameValidity(incorrectNameNotEnglish)).isEqualTo(false);
        // 이름 중복
        String incorrectSameName = "same,same";
        Game game = new Game();
        game.separateName(incorrectSameName);
        assertThat(game.makeCars()).isEqualTo(false);
        // 자동차 1대 일때
        String incorrectNameJustOneCar = "pobi";
        game = new Game();
        game.separateName(incorrectNameJustOneCar);
        assertThat(game.makeCars()).isEqualTo(false);
    }

    @Test
    @DisplayName("올바른 자동차 경주 시도횟수 입력이 이루어지는지 테스트")
    void 올바른_자동차경주_시도횟수_테스트()throws IOException{
        // 올바른 입력
        String correctNumber = "1";
        assertThat(NumberValidity.checkNumberValidity(correctNumber)).isEqualTo(true);
        // 음수일떄
        String incorrectNumber1 = "-1";
        assertThat(NumberValidity.checkNumberValidity(incorrectNumber1)).isEqualTo(false);
        // 0일때
        String incorrectNumber2 = "0";
        assertThat(NumberValidity.checkNumberValidity(incorrectNumber2)).isEqualTo(false);
        // int 범위를 넘는경우
        String incorrectNumber3 = "3000000000"; // 30억
        assertThat(NumberValidity.checkNumberValidity(incorrectNumber3)).isEqualTo(false);
        // 소수일때
        String incorrectNumber4 = "1.2";
        assertThat(NumberValidity.checkNumberValidity(incorrectNumber4)).isEqualTo(false);
        //숫자가 아닐때
        String incorrectNumber5 = "a";
        assertThat(NumberValidity.checkNumberValidity(incorrectNumber5)).isEqualTo(false);
    }
    @Test
    @DisplayName("0 ~ 3정지 일때 4 ~ 9일때 전진하는지 테스트")
    void 전진정지테스트()throws IOException{
        //0일때
        int num1 = 0;
        Car car1 = new Car("car","",0);
        CarMovement.checkMoveOrNot(num1,car1);
        assertThat(car1.getNowStatus()).isEqualTo("car : ");
        //3일때
        int num2 = 3;
        Car car2 = new Car("car","",0);
        CarMovement.checkMoveOrNot(num2,car2);
        assertThat(car2.getNowStatus()).isEqualTo("car : ");
        //4일때
        int num3 = 4;
        Car car3 = new Car("car","",0);
        CarMovement.checkMoveOrNot(num3,car3);
        assertThat(car3.getNowStatus()).isEqualTo("car : -");
        //9일때
        int num4 = 9;
        Car car4 = new Car("car","",0);
        CarMovement.checkMoveOrNot(num4,car4);
        assertThat(car4.getNowStatus()).isEqualTo("car : -");
    }

    @Test
    @DisplayName("우승자가 1명일때와 2명이상일때 테스트")
    void 우승자테스트()throws IOException {
        // 우승자가 1명일때
        Game game1 = new Game();
        Car[] cars1 = new Car[3];
        cars1[0] = new Car("one","---",1);
        cars1[1] = new Car("two","--",2);
        cars1[2] = new Car("three","-",3);
        game1.setCars(cars1);
        game1.makeAndPrintWinner();
        assertThat(game1.getWinner().getWinner()).isEqualTo("three");
        //우승자가 2명이상일때
        Game game2 = new Game();
        Car[] cars2 = new Car[3];
        cars2[0] = new Car("one","---",1);
        cars2[1] = new Car("two","--",3);
        cars2[2] = new Car("three","-",3);
        game2.setCars(cars2);
        game2.makeAndPrintWinner();
        assertThat(game2.getWinner().getWinner()).isEqualTo("two, three");
    }
}