package primitiveWrapperClass;

public class RemainCount {
    private final int remainCount;

    public RemainCount( String remainCount ) {
        validateCountRule( remainCount );
        this.remainCount = Integer.parseInt( remainCount );
    }

    public void validateCountRule( String remainCount ) {
        if ( Integer.parseInt( remainCount ) < 1 ) {
            throw new IllegalArgumentException( "[ERROR] 게임 횟수는 최소 1회 이상 입력하세요." );
        }
    }

    public int showRemainCount(){
        return this.remainCount;
    }
}
