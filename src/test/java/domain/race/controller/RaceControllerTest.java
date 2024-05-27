package domain.race.controller;

class RaceControllerTest {


    @Test
    @DisplayName("정상적인 값이 입력되었을때")
    void normalInput() {
        Assertions.assertThat(UtilClass.isFinish("123", "321")).isFalse();
        Assertions.assertThat(UtilClass.isFinish("321", "321")).isTrue();
    }
}