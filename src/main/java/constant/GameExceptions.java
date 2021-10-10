package constant;

public enum GameExceptions {

    EXCEPTION_TO_CAR_NAME ( " [ERROR] 빈값을 제외한 5자리 이하의 이름을 설정하세요. " ),
    EXCEPTION_TO_PLAY_COUNT ( " [ERROR] 0을 제외한 65535자리 이하의 숫자를 설정하세요. " );

    private String msg;

    GameExceptions(String msg) {
        this.msg = msg;
    }

    public static Exception throwsException(GameExceptions exceptions) throws Exception {
        System.out.println( exceptions.msg );
        return new Exception();
    }

    public static void throwsExceptionMsg(GameExceptions exceptions) {
        System.out.println( exceptions.msg );
    }
}
