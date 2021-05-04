public class Car {
    String name;
    int position;
    int moveCount;

    private Car(){}

    public Car(String name) throws InvalidCarNameException {
        setName(name);
        position = 0;
        moveCount = 0;
    }


    private Car setName(String name) throws InvalidCarNameException {
        invalidCheck(name);
        this.name = name;
        return this;
    }

    private void invalidCheck(String name) throws InvalidCarNameException {
        if (name==null) throw new InvalidCarNameException("입력된 차량 이름이 Null입니다.");
        if (name.equals("")) throw new InvalidCarNameException("입력된 차량 이름이 없습니다");
        if (name.length() > 5) throw new InvalidCarNameException("입력된 차량의 이름" + name + "이 5를 초과합니다.");
    }

    public String getName() {
        return name;
    }

    public void moveOrDont(int accelValue) {
        this.moveCount++;
        if (accelValue < 4) {
            // do nothing
            return;
        }

        if (accelValue >= 4) {
            move();
            return;
        }

    }

    public int getPosition() {
        return this.position;
    }

    private void move() {
        this.position++;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
