package racinggame.dto;

public class ResponseDto {
	private final Status status;
	private final String message;

	private ResponseDto(Status status, String message) {
		this.status = status;
		this.message = message;
	}

	private enum Status {
		OK, ERROR
	}

	public static ResponseDto ok(String message) {
		return new ResponseDto(Status.OK, message);
	}

	public static ResponseDto error(String message) {
		return new ResponseDto(Status.ERROR, "[ERROR]"+message);
	}

	public boolean isOk() {
		return status == Status.OK;
	}

	public boolean isError() {
		return status == Status.ERROR;
	}

	public String getMessage() {
		return message;
	}
}
