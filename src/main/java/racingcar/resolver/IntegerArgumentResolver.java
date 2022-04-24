package racingcar.resolver;

import racingcar.utils.InputValidator;
import racingcar.utils.TypeTransformer;

public class IntegerArgumentResolver implements ArgumentResolver<Integer>{
    private static IntegerArgumentResolver argumentResolver;
    private InputValidator inputValidator = InputValidator.getInstance();

    private IntegerArgumentResolver() {}

    public synchronized static IntegerArgumentResolver getInstance() {
        if (argumentResolver == null)
            argumentResolver = new IntegerArgumentResolver();
        return argumentResolver;
    }

    @Override
    public Integer convert(String input) {
        return validate(input);
    }

    private Integer validate(String input) {
        inputValidator.validateNumber(input);
        inputValidator.validateNumberRange(input);
        return Integer.parseInt(input);
    }
}
