import java.util.*;

class RaceService {
    private Vector<Racer> racers;
    private int numTries;

    public RaceService(Vector<Racer> racers, int numTries) {
        this.racers = racers;
        this.numTries = numTries;
    }

    //레이스 실행하는 함수
    public void runRace() {
        for (int i = 0; i < numTries; i++) {
            for (Racer racer : racers) {
                racer.Go();
                System.out.println(racer.name + ": " + racer.far);
            }
            System.out.println();
        }
    }

    //위너 계산할 때 레이서 백터 전달하는 함수
    public Vector<Racer> getRacers() {
        return racers;
    }
}
