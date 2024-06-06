package Model;

public class Player {
    // 시도할 횟수 저장
    private int tryNumber;
    // 생성자로 횟수 초기화
    public Player(int tryNumber){
        this.tryNumber = tryNumber;
    }
    // getter로만 접근
    public int getTryNumber() {
        return tryNumber;
    }
}
