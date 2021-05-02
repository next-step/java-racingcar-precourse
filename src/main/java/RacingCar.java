public class RacingCar implements Comparable<RacingCar> {
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

    @Override
    public int compareTo(RacingCar car){
        return this.count <= car.getCount()? 1: -1;
    }
    @Override
    public String toString(){
        return "이름: "+ this.name +", 전진횟수: "+ this.count;
    }
    /**
     * 0~9 사이의 난수를 추출하여, 4 이상일 경우 전진한다.
     * @return 해당 회차의 난수를 반환
     */
    public int playOneRound() {
        int rand_number = (int)(Math.random()*10);
        if(rand_number>=4){
            this.count++;
        }
        return rand_number;
    }

    /**
     * 현재 회차의 전진 횟수를 출력한다.
     * @return 결과 포맷의 String 반환
     */
    public String printCurrentCount(){
        String res = this.name + " : ";
        for(int i=0;i<count;i++){
            res += "-";
        }
        System.out.println(res);
        return res;
    }
}
