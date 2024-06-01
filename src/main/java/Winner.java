import java.util.ArrayList;

public class Winner {

    private ArrayList<Car> carList;
    private ArrayList<String> winners = new ArrayList<>();

    public Winner(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void findWinner(){

        int maxForward = getMaxForward();
        for(Car c: carList){
            if(c.getProgress() == maxForward){
                winners.add(c.getName());
            }
        }

    }

    public int getMaxForward(){
        int maxForward = 0;

        for(Car c: carList){
            if(maxForward < c.getProgress()){
                maxForward = c.getProgress();
            }
        }
        return maxForward;
    }

    public ArrayList<String> getWinners() {
        findWinner();
        return winners;
    }
}
