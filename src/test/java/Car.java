import java.util.Random;

public class Car {
    private String name;
    private int curLocation=0;

    public Car(String name) {
        this.name = name;
    }

    public int getCurLocation() {
        return curLocation;
    }

    public String getName() {
        return name;
    }

    public void run(){
        Random random = new Random();
        int k = random.nextInt(10);
        if (k>=4){
            curLocation +=1;
        }
    }

    public void showLocation(){
        System.out.print(this.name+" : ");
        for (int i=0;i<curLocation;i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
