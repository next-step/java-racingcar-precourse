package racingcar.controller;


/**
 * Created by eunbi on 2022/04/18
 */
public class GameValidator {
    // 자동차 이름의 길이 체크
    public void checkNameLength(String carName){
        if( carName == null || carName.length() ==0 || carName.length() > 5){
            System.out.println("[ERROR] 잘못된 자동차 이름입니다.");
            throw new IllegalArgumentException();
        }
    }

    // random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다
    public boolean checkMoveNum (int moveNum){
        if (moveNum<0 || moveNum > 9){
            System.out.println("[ERROR] 이동 숫자가 잘못되었습니다.");
            throw new IllegalArgumentException();
        }
        return moveNum>=4;
    }



}
