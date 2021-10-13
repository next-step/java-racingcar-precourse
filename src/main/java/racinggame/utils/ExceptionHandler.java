package racinggame.utils;

import java.util.function.Supplier;

import racinggame.view.ConsoleView;

public class ExceptionHandler {
	public static  <T> T processException(Supplier<T> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException exception) {
			ConsoleView.printExceptionMessage(exception.getMessage());
			return processException(supplier);
		}
	}
}