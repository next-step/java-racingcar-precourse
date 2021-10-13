package constant;

public enum GameArgumentConstant {

	CAR_NAME_SPLIT_ARGUMENT (","),
	;

    private String constantValue;

    private GameArgumentConstant(String constantValue) {
        this.constantValue = constantValue;
    }

	public String getArgumentValue() {
		return constantValue;
	}
    
}
