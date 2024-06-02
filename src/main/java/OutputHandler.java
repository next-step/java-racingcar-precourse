import java.util.Vector;

public class OutputHandler {
    public static void FowardOutput(Vector<Car> cars) {
        for(int i = 0; i < cars.size(); i++) {
            System.out.print(cars.elementAt(i).getName() + " : ");
            for(int j = 0; j < cars.elementAt(i).getNumber(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }

    }

}
