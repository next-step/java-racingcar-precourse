package util;

public class Car {
    private String[] carList;
    private int[] carProcessList;

    public Car(int indexLength){
        for(int i=0;i<indexLength;i++){
            carList[i] = "";
            carProcessList[i] = 0;
        }
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

    public void plusCarProcessValue(int index){
        carProcessList[index]++;
    }

    public void minosCarProcessValue(int index){
        if(carProcessList[index] > 0) carProcessList[index]--;
    }
}
