package tw.core;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup(){
        this.randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void test_right(){
        System.out.println(randomIntGenerator.generateNums(4,4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_exception(){
        randomIntGenerator.generateNums(1,4);
    }

}