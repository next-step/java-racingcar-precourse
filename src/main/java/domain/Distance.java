package domain;

public class Distance {

    private static String BAR = "-";

    int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getDistanceByBar() {
        return makeBar(distance);
    }

    public void move(){
        distance += 1;
    }

    public String makeBar(int distance){
        StringBuilder bar = new StringBuilder();
        for(int i=0; i<distance; i++){
            bar.append(BAR);
        }
        return bar.toString();
    }
}
