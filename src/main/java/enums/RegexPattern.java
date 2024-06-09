package enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    REGEXP_PATTERN_NUMBER(Pattern.compile("^[\\d]*$"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern){
        this.pattern = pattern;
    }

    public boolean match(String input){
        return pattern.matcher(input).matches();
    }
}
