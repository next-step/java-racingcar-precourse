package racingcar;

public enum CarStatus {
    FOWARD, BACKWORD;

    private static final int MIN_FOWARD_NUM = 4;

    public static CarStatus checkBackOrFoward(int number){

        if(number < MIN_FOWARD_NUM){
            return BACKWORD;
        }

        return FOWARD;
    }

    public boolean isFoward(){
        return this == FOWARD;
    }

    public boolean isBACKWORD(){
        return this == BACKWORD;
    }
}
