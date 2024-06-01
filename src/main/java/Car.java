public class Car {
    private String name;
    private int position;
    public Car(String name) {
        if(name.length()>5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백을 포함할 수 없습니다.");
        }
        this.name=name;
        this.position=0;
    }

    public void move(int randomValue){
        if(randomValue >= 4){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
