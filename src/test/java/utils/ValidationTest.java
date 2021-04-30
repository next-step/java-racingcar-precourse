package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    
    @Test
    @DisplayName("5글자 이하인지 검증")
    public void nameLengthTest() {
        String carName_3 = "bee";
        String carName_5 = "apple";
        String carName_6 = "banana";
        
        boolean isAvailableName_3 = ValidationUtil.validCarNameLength(carName_3);
        boolean isAvailableName_5 = ValidationUtil.validCarNameLength(carName_5);
        boolean isAvailableName_6 = ValidationUtil.validCarNameLength(carName_6);
        
        Assertions.assertThat(isAvailableName_3).isTrue();
        Assertions.assertThat(isAvailableName_5).isTrue();
        Assertions.assertThat(isAvailableName_6).isFalse();
    }
    
}
