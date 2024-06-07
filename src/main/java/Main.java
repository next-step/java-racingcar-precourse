

public class Main {

    public static void main(String[] args) {
        Input i = new Input();
        String players = i.inputPlayer();
        int n = i.inputMatch();

        Car[] cars = new Car[i.numOfPlayers(players)];
        i.createCarArray(players, cars);

        System.out.println("실행결과 : ");
        doRacing(n, cars);
    }

    public static void doRacing(int n, Car[] cars) {
        Race r = new Race();
        for(int i=0; i<n; i++) {
            r.updateCars(cars);
            r.printCars(cars);
            System.out.println();
        }
    }

}
