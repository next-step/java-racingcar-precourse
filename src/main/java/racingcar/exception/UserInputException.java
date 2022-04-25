package racingcar.exception;

import racingcar.model.Message;

public class UserInputException extends IllegalArgumentException{
    public UserInputException(String msg){
        super(msg);
        System.out.println(Message.ERROR + msg);
    }
}
