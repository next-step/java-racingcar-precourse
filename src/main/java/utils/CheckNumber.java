package utils;

public class CheckNumber {
    private String inputNumber;


    public CheckNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getNumber(){
        if(!inputNumber.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(inputNumber);
    }
}
