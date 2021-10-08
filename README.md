# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구 사항
* n대의 차는 전진 or 멈춤 한다.
* 전진 조건은 0~9 random 중에 4 이상이면 전진, 아니면 멈춤
  

* 차는 이름을 가진다. (이름은 5자 이하만 가능)
* 차를 출력할 때 이름을 출력한다.
* 차 이름은 쉼표로 구분한다.
* 자동차 이동을 입력한다.

## 체크 사항
* [일급 컬렉션 활용할 것](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
* [모든 원시값 & 문자열 포장할 것](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)

## 기능 목록

### 생각 중인 플로우
* 입력을 받는다.
  
    * 차 이름 (쉼표로 받는다)
        * 차 이름이 문자인지
        * 모든 차 이름이 5자 이하인지
    
    * 이동 횟수
        * 이동 횟수는 숫자인지


* 차를 등록한다. (+차 목록)
    
    * 필요 정보
        * 이름
        * 이동 횟수


* 레이스를 등록한다.
    
    * 필요 정보
        * 차들
        * 현재 횟수


* 레이스를 진행한다.
  
    * 차들의 각각 차 마다 랜덤 숫자를 구한다
        * 들어온 입력이 숫자인지 
        * 랜덤 숫자는 1-9 사이인지


* 레이스 결과를 구한다. (한 번 진행될 때 마다)
  
  * 필요 정보
    * 차 이름, 차 횟수 출력
    * 레이스가 끝났는 지 횟수 확인
    * 끝났다면 끝남 메시지 추가
    
### TODO WITH TDD

---
car name : a, moveCount : 0  
random : 4 -> moveCount 1 pass  
random : 1 -> moveCount 0 fail 

---

