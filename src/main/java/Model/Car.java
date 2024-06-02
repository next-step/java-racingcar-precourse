package Model;

public class Car {

    private final String  name;
    private int position;

    public Car(String name) {
        if (name.length() > 5 ){
            throw new IllegalArgumentException("[ERROR] 5글자 이하의 이름으로 지어주세요.");
        }
        this.name = name;
        this.position = 0;
    }
    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    public void move(){
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber > 4){
            // 전진
            position++;
        }
    }
}
