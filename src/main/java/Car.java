public class Car {

    private String name;
    private Integer num;

    public Car(String name) {
        this.name = name;
        this.num = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getNum() {
        return num;
    }

    //    4이상의 값이 들어오면 한 칸 나아간다
    public void updateNum(int num) {
        if (num >= 4) {
            this.num++;
        }
    }
}
