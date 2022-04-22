package primitiveWrapperClass;

public class TryCount {
    private final int tryCount;

    public TryCount( String tryCount ) {
        validateCountRule( tryCount );
        this.tryCount = Integer.parseInt( tryCount );
    }

    public void validateCountRule( String tryCount ) {
        if ( Integer.parseInt( tryCount ) < 1 ) {
            throw new IllegalArgumentException( "[ERROR] 게임 횟수는 최소 1회 이상으로 입력하세요." );
        }

        if ( Integer.parseInt( tryCount ) > 1000 ) {
            throw new IllegalArgumentException( "[ERROR] 게임 횟수는 최대 1000회 이하로 입력하세요." );
        }
    }

    public int showGameTryCount(){
        return this.tryCount;
    }
}
