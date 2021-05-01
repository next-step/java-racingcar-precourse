package racing.vo;

public class Round {

    private int round;
    public Round(int round) {
        if(round<=0){
            throw new IllegalArgumentException("이동횟수는 1이상 입력해주시길 바랍니다.");
        }
        this.round = round;
    }

    public int getValue(){
        return this.round;
    }

}
