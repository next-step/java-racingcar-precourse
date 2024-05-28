import java.util.ArrayList;

public class InputCarName {

    private String[] carNames;
    ArrayList<Car> carList = new ArrayList<>();

    public void splitInput(String names){
        carNames = names.split(",");
        makeCarList();
    }

    public void makeCarList(){
        for(String name: this.carNames){
            carList.add(new Car(name));
        }
    }
}
