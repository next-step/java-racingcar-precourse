package constant;

public enum MsgTypes {

    CAR_NAME_SETTING_MSG( "경주할 자동차 이름을 입력하세요." ),
    RACING_SETTING_MSG( "시도할 횟수는 몇회인가요?" ),
    RACING_START_MSG( "실행결과" ),
    ;

    private String msg;

    private MsgTypes(String msg) {
        this.msg = msg;
    }

    public void getMsg() {
        System.out.println( msg );
    }

}
