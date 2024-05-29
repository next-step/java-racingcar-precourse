# java-racingcar-precourse

헥사고날 아키텍처 연습\
DDD 연습\
일반적인 RESTful api 서버가 M, C를 담당하고 브라우저가 V를 담당하니 비슷하게 구성\
Proxy를 통해 스프링의 @RequestBody처럼 컨트롤러에 들어온 데이터를 알맞게 변환하면 좋겠지만 V에서 바로 변환

1. domain entity 작성
2. port, dto 작성
3. service 작성
4. adaptor 작성
5. view 작성
6. application 작성