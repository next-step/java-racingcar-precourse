package racingcar;

import java.util.List;

public class Car implements Comparable<Car>{
    String name;
    String go ="";

    public Car(String name){ 
        this.name = name;
    }

    public void addGo(String text){
        this.go += "-";
    }

    public String getGo(){
        return this.go;
    }

    @Override
    public int compareTo(Car s){
        if(this.go.length() < s.getGo().length()){
            return -1;
        }
        if(this.go.length() > s.getGo().length()){
            return 1;
        }
        return 0;
    }
    
}
