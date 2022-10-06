package utils;

public class SplitCarName {

    private String inputName;

    public SplitCarName(String inputName) {
        this.inputName = inputName;
    }

    public String[] getCarName(){
        if(getSeparator(inputName) +1 != inputName.split(",").length){
            throw new IllegalArgumentException("[ERROR] 자동차의 이름을 공백이 아닌 값으로 입력해 주세요");
        }
        return inputName.split(",");
    }

    private int getSeparator(String inputName) {
        int countSeparator=0;
        for(int i =0; i< inputName.length();i++){
            if(inputName.charAt(i)==','){
                countSeparator+=1;
            }
        }
        return countSeparator;
    }
}
