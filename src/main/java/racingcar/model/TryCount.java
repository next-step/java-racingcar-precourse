package racingcar.model;

public class TryCount {
    private static final String notIntInputErrMsg = "시도 횟수는 숫자여야 한다.";
    private static final String negativeInputErrMsg = "시도 횟수는 0보다 커야 한다.";
    private final int count;

    public TryCount(String count) {
        int intCount = parseInt(count);
        validPositive(intCount);
        this.count = intCount;
    }

    public int getCount() {
        return this.count;
    }

    private int parseInt(String count){
        try {
            return Integer.parseInt(count);
        }
        catch (Exception e ){
            throw new IllegalArgumentException(notIntInputErrMsg);
        }
    }

    private boolean checkPositive(int count){
        return  count > 0;
    }

    private void validPositive(int count){
        if(!checkPositive(count))
            throw new IllegalArgumentException(negativeInputErrMsg);
    }
}
