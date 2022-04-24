package racingcar.resolver;

import racingcar.utils.InputValidator;
import racingcar.utils.TypeTransformer;

public class StringArrayArgumentResolver implements ArgumentResolver<String[]>{
    private static String REPLACE_TARGET = " ";
    private static String REPLACEMENT = "";
    private static StringArrayArgumentResolver argumentResolver;

    private InputValidator inputValidator = InputValidator.getInstance();

    private StringArrayArgumentResolver() {}

    public synchronized  static StringArrayArgumentResolver getInstance() {
        if (argumentResolver == null)
            argumentResolver = new StringArrayArgumentResolver();
        return argumentResolver;
    }

    @Override
    public String[] convert(String input) {
        return validate(input);
    }

    private String[] validate(String input) {
        inputValidator.validateEmpty(input);
        inputValidator.validateSplitWord(input);
        inputValidator.validateLeastCandidate(input);
        inputValidator.validateSameName(input);
        String[] res = TypeTransformer.changeString2Array(input);
        validateName(res);
        return res;
    }

    private void validateName(String[] name) {
        for (String value : name) {
            inputValidator.validateEmptyName(value);
            inputValidator.validateNameLimit(value);
        }
    }
}
