package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator;

    @Before
    public void setup(){
        this.inputValidator = new InputValidator();
    }


    @Test
    public void test_input_right(){
        Assert.assertTrue(inputValidator.validate("1 2 3 4"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_input_not_all_number(){
        Assert.assertFalse(inputValidator.validate("1 2 3 t"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_input_all_not_number(){
        Assert.assertFalse(inputValidator.validate("A B C D"));
    }

    @Test
    public void test_input_no_space(){
        Assert.assertFalse(inputValidator.validate("1234"));
    }

    @Test
    public void test_input_length_short(){
        Assert.assertFalse(inputValidator.validate("1 2 3"));
    }

    @Test
    public void test_input_length_long(){
        Assert.assertFalse(inputValidator.validate("1 2 3 4 5"));
    }

    @Test
    public void test_input_repeat(){
        Assert.assertFalse(inputValidator.validate("1 2 1 2"));
    }


}
