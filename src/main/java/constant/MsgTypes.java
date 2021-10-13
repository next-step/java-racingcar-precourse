package constant;

public enum MsgTypes {

    CAR_NAME_SETTING_MSG( "경주할 자동차 이름을 입력하세요." ),
    RACING_SETTING_MSG( "시도할 횟수는 몇회인가요?" ),
    RACING_START_MSG( "실행결과" ),
    WINNER_FORMAT_MSG ( " 최종 우승자는 : %s 입니다." ),
    
    EXCEPTION_TO_CAR_NAME ( "[ERROR] 빈값을 제외한 5자리 이하의 이름을 설정하세요." ),
    EXCEPTION_TO_PLAY_COUNT ( "[ERROR] 0을 제외한 %s자리 이하의 숫자를 설정하세요." ),
    EXCEPTION_NOT_NUMBER_TO_TRY_COUNT ( "[ERROR] 숫자만 입력 하세요" ),
    ;

    private String msg;

    private MsgTypes(String msg) {
        this.msg = msg;
    }

    public void getMsg() {
        System.out.println( msg );
    }
    
    public static void getMsg( MsgTypes type, String result ) {
    	System.out.println( String.format( type.msg, result ) );
    }
    
}
