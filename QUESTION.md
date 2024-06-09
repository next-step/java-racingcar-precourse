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

+ static 키워드에 대한 테스트에 대해서 강사님은 어떻게 생각하시는지?
+ entity, controller, view 여러 곳에 퍼져있는 validate 로직을 통합하는게 나은지, 아니면 지금대로 분산시켜서 각각 검증 로직을 들고 있는게 나은건지?