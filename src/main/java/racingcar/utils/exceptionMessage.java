package racingcar.utils;

public class exceptionMessage {
    public String inputOnlyNumber(){
        return "[ERROR] 숫자만 입력해 주세요";
    }
    public String noInputCarName(){
        return "[ERROR] 자동차 이름을 입력하지 않았습니다.";
    }
    public String InputCarName5Over(){
        return "[ERROR] 자동차 이름의 길이가 5를 넘었습니다.";
    }
    public String InputCarNameWrong(){
        return "[ERROR] 자동차의 이름이 잘못 입력되었습니다.";
    }
    public String InputNumNegative(){
        return "[ERROR] 입력하신 숫자가 음수입니다.";
    }
    public String InputNumNegativeAndUnderZero(){
        return "[ERROR] 게임 진행을 위한 1이상의 숫자를 입력해주세요.";
    }
    public String WrongPositionNumber(){
        return "[ERROR] position 값이 잘못 들어갔습니다.";
    }
}
