package primitiveWrapperClass;

public class Distance {
    private String distance;

    public Distance( String distance ) {
        this.distance = distance;
    }

    public void carMoved(){
        distance += "-";
    }

    public void initDistance() { distance = ""; }

    public String totalDistance(){
        return this.distance;
    }
}
