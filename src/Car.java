package src;

public class Car {
    private Name name = new Name();
    private Position position = new Position();

    public Car(String name) {
        this.name.setValue(name);
    }

    public String getName(){
        return name.value();
    }

    public int getPosition(){
        return position.value();
    }

    public void increasePosition() {
        position.increasePosition();
    }

    public int compareMaxAndPosition(int maxPosition) {
        return Math.max(maxPosition, position.value());
    }

    public StringBuilder addWinner(StringBuilder winner, int position) {
        if (position == this.position.value()) {
            if (!winner.isEmpty()) {
                winner.append(",");
            }
            winner.append(name.value());
        }
        return winner;
    }

}
