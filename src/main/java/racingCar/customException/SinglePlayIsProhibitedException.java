package racingCar.customException;

import java.security.PublicKey;

public class SinglePlayIsProhibitedException extends IllegalArgumentException implements CustomException{
    public SinglePlayIsProhibitedException(){}
    public SinglePlayIsProhibitedException(String message){ super(message); }
}
