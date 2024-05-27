
public class Position {
    final static int DEFAULT_POSITION = 0;
    private int value;

    public Position(){
        this.value = DEFAULT_POSITION;
    }

    public void increasePosition(){
        value++;
    }
    public int value(){
        return value;
    }
}