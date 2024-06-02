import java.util.Random;
public class Car {
    static final int NAME_LENGTH = 5;
    static final Random random = new Random();
    private String name;
    private int position = 0;
    public Car(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }
    public void makeMove() {
        int randVal = random.nextInt(10);
        if (randVal >= 4) {
            position++;
        }
    }
    public String getPosition() {
        String visualPosition = "";
        for(int i = 0; i < position;i++){
            visualPosition = visualPosition + "-";
        }
        return visualPosition;
    }
    public String getName(){
        return name;
    }
}
