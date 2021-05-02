package racing.vo;

import racing.util.ValidationUtil;

public class Round {

    private int round;
    private String inputValue;

    public Round(String inputValue) {
        this.inputValue = inputValue;
        if(numberCheck()){
            this.round = Integer.parseInt(inputValue);
            movingCountCheck();
        }
    }

    public boolean numberCheck(){
        if(!ValidationUtil.numberChk(this.inputValue)){
            throw new IllegalArgumentException("숫자를 입력해주시길 바랍니다.");
        }
        return true;
    }

    public boolean movingCountCheck(){
        if(round<=0){
            throw new IllegalArgumentException("이동횟수는 1이상 입력해주시길 바랍니다.");
        }
        return true;
    }

    public int getValue(){
        return this.round;
    }

}
