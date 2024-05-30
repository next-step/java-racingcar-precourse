package View;

import java.util.ArrayList;

public class ProgressView {
    public void printProgress(ArrayList<String> list){
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("");
    }
}
