package util;

public class Car {
    private String[] carList;
    private int[] carProcessList;

    public void initCarList(int indexLength){
        carList = new String[indexLength];
        for(int i=0;i<indexLength;i++){
            carList[i] = "";
        }
    }

    public void initCarProcessList(int indexLength){
        carProcessList = new int[indexLength];
        for(int i=0;i<indexLength;i++){
            carProcessList[i] = 0;
        }
    }

    public void setCarList(String carString, int index){
       if(carString.length() < 6) {
           carList[index] = carString;
       } else{
         throw new AssertionError("문자 자릿수 초과로 인한 Exception");
       }
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
