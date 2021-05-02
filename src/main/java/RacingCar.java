import java.util.HashMap;

public class RacingCar {
    private String name;
    private int count = 0;
    public RacingCar(String str){
        this.name = str;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String str){
        this.name = str;
    }
    public int getCount(){
        return this.count;
    }
    public void setCount(int num){
        this.count = num;
    }

    /**
     * 0~9 사이의 난수를 추출하여, 4 이상일 경우 전진한다.
     * @return 해당 회차의 난수를 반환 (확인용)
     */
    public int playOneRound() {
        int rand_number = (int)(Math.random()*10);
        if(rand_number>=4){
            this.count++;
        }
        return rand_number;
    }
}
