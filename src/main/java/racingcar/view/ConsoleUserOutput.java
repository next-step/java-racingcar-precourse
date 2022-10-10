package racingcar.view;

/**
 * @author garden.iee
 */
public class ConsoleUserOutput implements UserOutput {
	@Override
	public void show(String text) {
		System.out.println(text);
	}
}