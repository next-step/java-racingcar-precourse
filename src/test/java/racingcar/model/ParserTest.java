package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 턴_입력을_파싱한다() {
        Parser parser = new Parser();
        assertThat(parser.parseTurn("1")).isEqualTo(1);
        assertThat(parser.parseTurn("0")).isNull();
        assertThat(parser.parseTurn("notNumber")).isNull();
    }

    @Test
    void 이름_입력을_파싱한다() {
        Parser parser = new Parser();
        assertThat(parser.parseName("name1,name2,name3")).hasSize(3);
        assertThat(parser.parseName("longlonglonglong")).hasSize(0);
    }
}