# 질문 모음

+ 입력값 검증에 대한 테스트 코드를 짤 때, 잘못된 입력값 여러 개를 테스트 하고 싶다면 주로 어떻게 하는 것이 좋은지?

아래처럼 배열로 하는 것이 좋은건지, 아니면 다른 더 좋은 방법이 있는건지?!
```java
class RacerTest {
    @Test
    @DisplayName("Racer 생성자 실패 테스트")
    void racerConstructorWithInvalidDataTest() {
        // given: 생성자 데이터
        List<String> invalidNameList = Arrays.asList(null, "", "   ");

        for (String invalidName : invalidNameList) {
            // when
            ThrowableAssert.ThrowingCallable constructorCall = () -> new Racer(invalidName);

            // then
            assertThatThrownBy(constructorCall)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }
    }
}
```

+ 