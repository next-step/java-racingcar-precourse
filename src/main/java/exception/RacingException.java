package exception;

import constant.Constant;

public class RacingException extends Exception{

    public RacingException(String msg){
        super(Constant.ERROR_MSG + msg);
    }
}
