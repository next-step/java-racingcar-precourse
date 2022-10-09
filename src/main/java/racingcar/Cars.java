package racingcar;

import java.util.Collections;
import java.util.List;

public class Cars{
    List<Car> carList;
    
    public Cars(List<Car> carList){
        this.carList = carList;
    }
    
    public List<Car> getCarList(){
        return this.carList;
    }

    public void showResult(){
        for(Car car : this.carList){
            String result = "";
            result += car.name + " : ";
            result += car.go;
            System.out.println(result);
        }
    }

    public void finalResult(){
        Collections.sort(this.carList,Collections.reverseOrder());
        String result = carList.get(0).name.toString();
        for(int i = 1; i<carList.size(); i++){
            if(carList.get(0).go.length()==carList.get(i).go.length())result+=", "+carList.get(i).name;
        }

        System.out.println(Message.fianlInfoString + result);
    }

}
