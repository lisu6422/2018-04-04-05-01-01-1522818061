package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    private final Answer answer = Answer.createAnswer("1 2 3 4");

    @Test
    public void test_answer_4_0() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 2 3 4");
        input.validate();
        Assert.assertEquals("4:0","4:0",answer.check(input).toString());
    }

    @Test
    public void test_answer_3_0() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 2 3 9");
        input.validate();
        Assert.assertEquals("3:0","3:0",answer.check(input).toString());
    }

    @Test
    public void test_answer_2_0() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 2 8 9");
        input.validate();
        Assert.assertEquals("2:0","2:0",answer.check(input).toString());
    }

    @Test
    public void test_answer_1_0() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 7 8 9");
        input.validate();
        Assert.assertEquals("1:0","1:0",answer.check(input).toString());
    }

    @Test
    public void test_answer_0_0() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("6 7 8 9");
        input.validate();
        Assert.assertEquals("0:0","0:0",answer.check(input).toString());
    }

    @Test
    public void test_answer_2_1() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 2 4 5");
        input.validate();
        Assert.assertEquals("2:1","2:1",answer.check(input).toString());
    }

    @Test
    public void test_answer_1_1() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 8 4 5");
        input.validate();
        Assert.assertEquals("1:1","1:1",answer.check(input).toString());
    }

    @Test
    public void test_answer_2_2() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 2 4 3");
        input.validate();
        Assert.assertEquals("2:2","2:2",answer.check(input).toString());
    }

    @Test
    public void test_answer_1_2() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 6 4 3");
        input.validate();
        Assert.assertEquals("1:2","1:2",answer.check(input).toString());
    }
    @Test
    public void test_answer_1_3() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("1 4 2 3");
        input.validate();
        Assert.assertEquals("1:3","1:3",answer.check(input).toString());
    }

    @Test
    public void test_answer_0_4() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("2 4 1 3");
        input.validate();
        Assert.assertEquals("0:4","0:4",answer.check(input).toString());
    }

    @Test
    public void test_answer_0_3() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("4 3 1 9");
        input.validate();
        Assert.assertEquals("0:3","0:3",answer.check(input).toString());
    }

    @Test
    public void test_answer_0_2() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("4 3 5 6");
        input.validate();
        Assert.assertEquals("0:2","0:2",answer.check(input).toString());
    }

    @Test
    public void test_answer_0_1() throws OutOfRangeAnswerException {
        final Answer input = getInputAnswer("6 7 8 3");
        input.validate();
        Assert.assertEquals("0:1","0:1",answer.check(input).toString());
    }



    private Answer getInputAnswer(String input){
        return Answer.createAnswer(input);
    }

}