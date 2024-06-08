import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD  = 4;
    private static final Random RANDOM = new Random();

    private final String name;
    private int position;
    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (RANDOM.nextInt(10) >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    // 테스트를 위해 오버로딩한 move 메서드
    public void move(int value) {
        if (value >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

}