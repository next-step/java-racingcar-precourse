package racingcar.service;

public class RepeatService {

    /**
     * 유효한 값이 나올 때까지 로직 반복
     *
     * @param callBack 실행 할 로직
     * @param <T> 초기화 할 객체 타입
     * @return 초기화 할 객체
     */
    public <T> T initTarget(CallBackInputValue<T> callBack) {
        T target = null;

        while (target == null) {
            target = getTarget(callBack);
        }

        return target;
    }

    private <T> T getTarget(CallBackInputValue<T> callBack) {
        try {
            return callBack.execute();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
