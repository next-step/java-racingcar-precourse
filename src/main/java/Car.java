import java.util.Random;

public class Car {
    private final String name;
    private int distance;
    private final Random rand;

    public Car(String name,Random random) {
        this.name = name;
        this.rand = random;
    }
    public void run(){
        if(rand.nextInt(9)>=4){
            distance++;
        }
    }
    public void printStatus(){
        System.out.print(name+" : ");
        for(int i=0; i<distance; i++){
            System.out.print("- ");
        }
        System.out.println();
    }

}
