package racingcar.domain;

public class InputData {
    String inputData;

    public InputData(String inputData) {
        this.inputData = inputData;
    }

    public String getInputData(){
        return inputData;
    }

    public String[] getSplitInputData(String regex) {
        if ("".equals(inputData)){
            return new String[0];
        }
        return inputData.split(regex);
    }

    public boolean isEmpty() {
        return inputData.isEmpty();
    }
}
