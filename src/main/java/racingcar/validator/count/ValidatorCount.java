package racingcar.validator.count;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.Message;

public class ValidatorCount {
    public int validateCnt() throws IllegalArgumentException{
        int cnt;

        try{
            cnt=  Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_COUNT_WRONG);
        }

        checkUnderZero(cnt);

        System.out.println(cnt);
        return cnt;
    }

    public void checkUnderZero(int cnt) throws IllegalArgumentException{
        if(cnt < 1){
            throw new IllegalArgumentException(Message.ERROR_INVALID_CNT);
        }
    }
}
