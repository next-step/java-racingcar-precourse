package primitiveWrapperClass;

public class RandomNumber {
    private final int randomNumber;

    public RandomNumber( int randomNumber ) {
        this.validateNumberRule( randomNumber );
        this.randomNumber = randomNumber;
    }

    private void validateNumberRule( int randomNumber ) {
        if (randomNumber < 0 || randomNumber > 9){
            throw new IllegalArgumentException( "[ERROR] 게임에서 사용할 수 있는 랜덤 수가 아닙니다." );
        }
    }

    public boolean isGreaterThanEqualFour(){
        return randomNumber >= 4 ? true : false;
    }
}
