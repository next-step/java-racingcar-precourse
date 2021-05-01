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
}
