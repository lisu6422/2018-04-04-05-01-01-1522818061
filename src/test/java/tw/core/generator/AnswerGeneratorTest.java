package tw.core.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.Mockito.*;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    private AnswerGenerator answerGenerator;
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup() {
        randomIntGenerator = mock(RandomIntGenerator.class);
        answerGenerator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void test_answer() throws OutOfRangeAnswerException {
        when(randomIntGenerator.generateNums(9,4)).thenReturn("1 2 3 4");
        Assert.assertEquals("1 2 3 4",answerGenerator.generate().toString());
    }


}

