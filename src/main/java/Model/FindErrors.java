package Model;

public class FindErrors {
    public void validCarNames(String input){
        String[] carNames = input.split(",");
        for(String name : carNames){
            if(name.length() > 5 || name.contains(" ")){
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다. 또한 자동차의 이름에 띄어쓰기가 있으면 안됩니다.");
            }
        }
    }

}
