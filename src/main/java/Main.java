public class Main {

    private static int n;
    private static Car[] cars;

    public static void main(String[] args) {
        try {
            inputValue();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
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

    public static void inputValue() throws IllegalArgumentException{
        Input i = new Input();
        String players;
        try {
            players = i.inputPlayer();
            n = i.inputMatch();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        cars = new Car[i.numOfPlayers(players)];
        i.createCarArray(players, cars);
    }
}
