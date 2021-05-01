package util;

public class Car {
    private String[] carList;
    private int[] carProcessList;

    public Car(int indexLength){

    }

    public void setCarList(String car){

    }

    public String getCarList(int index){
        return carList[index];
    }

    public void getCarProcessList(int index){
        for(int i=0;i<carProcessList[index];i++){
            System.out.print("-");
        }
        System.out.println("");
    }
}
