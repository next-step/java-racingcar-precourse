public class Main {

    public static void main(String[] args) {
        Input i = new Input();
        String players = i.inputPlayer();
        int n = i.inputMatch();

        Car[] cars = new Car[i.numOfPlayers(players)];
        i.createCarArray(players, cars);

        System.out.println("실행결과 : ");
        doRacing(n, cars);
        checkWinner(cars);
    }

    public static void doRacing(int n, Car[] cars) {
        Race r = new Race();
        for(int i=0; i<n; i++) {
            r.updateCars(cars);
            r.printCars(cars);
            System.out.println();
        }
    }

    public static void checkWinner(Car[] cars) {
        Race r = new Race();
        String[] winners = r.returnWinner(cars);

        System.out.print("최종 우승자 : ");
        for(int i=0; i<winners.length; i++) {
            if (i == winners.length - 1) {
                System.out.println(winners[i]);
                break;
            }
            System.out.print(winners[i] + ", ");
        }
    }
}
