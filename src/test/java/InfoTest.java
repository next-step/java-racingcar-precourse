import Model.Info;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class InfoTest {

    private Info info;

    @BeforeEach
    void setUp(){
        info = new Info();
        info.insert("test1,test2,test3,test4"  , 0);
    }

    @AfterEach
    void clear(){
        info = null;
    }

    @Test
    @DisplayName("Info의 insert() 메서드 정상작동 검사")
    void insertTest(){
        assertThat(info.getCarList()).extracting("name") //저장된 값의 이름만 추출하여
            .contains("test1","test2","test3","test4"); //해당값 포함 여부
    }


    @RepeatedTest(value = 5, name = "round() 호출 횟수 = {currentRepetition}")
    @DisplayName("Progress 정상 출력 검사")
    void getProgressListTest(RepetitionInfo repetitionInfo){
        for(int i = 0;i < repetitionInfo.getCurrentRepetition();i++)
            info.round();
        //모든 테스트에 대한 전진 길이는 currntRepetion보다 클 수 없음
        System.out.println(info.getProgressList());
    }


    @RepeatedTest(value = 5, name = "round() 호출 횟수 = {currentRepetition}")
    @DisplayName("getWinner 정상 출력 검사")
    void getWinnerTest(RepetitionInfo repetitionInfo){
        for(int i = 0;i < repetitionInfo.getCurrentRepetition();i++)
            info.round();
        System.out.println(info.getWinner());
        assertThat(info.getWinner().length()).isNotEqualTo(0);
    }
}
