package exception;

public enum Error_Code {
	
	INVALID_LENGTH_OF_NAME("이름은 5자 이하로 입력해 주세요");
	
	private String errorMsg;
	
	Error_Code(String errorMsg){
		this.errorMsg=errorMsg;
	}

	public String errorMsg() {
		
		return this.errorMsg;
		
	}
	
}
