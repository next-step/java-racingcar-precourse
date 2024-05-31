import java.util.*;

class ResultWinner {
    private Vector<Racer> racers;

    public ResultWinner(Vector<Racer> racers) {
        this.racers = racers;
    }

    public Vector<String> getWinners() {
        int max = getMaxDistance();//최대 거리 구하기 호출
        return findWinners(max);//위너 구하기 호출
    }

    //최대 거리 구하기
    private int getMaxDistance() {
        int max = 0;
        for (Racer racer : racers) {
            if (racer.far.length() > max) {
                max = racer.far.length();
            }
        }
        return max;
    }

    //위너 구하기
    private Vector<String> findWinners(int max) {
        Vector<String> winners = new Vector<>();
        for (Racer racer : racers) {
            if (racer.far.length() == max) {
                winners.add(racer.name);
            }
        }
        return winners;
    }

    //위너 프린트 하기
    public static void printWinners(Vector<String> winners) {
        System.out.print("최종 우승자: " + winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i));
        }
        System.out.println();
    }
}

