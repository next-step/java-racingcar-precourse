package constant;

public enum MsgConstant {

    CAR_NAME_SETTING_MSG( "경주할 자동차 이름을 입력하세요." ),

    ;

    private String msg;

    MsgConstant(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    private void printMsg(MsgConstant constant ){
        System.out.println( constant.getMsg() );
    }

}
