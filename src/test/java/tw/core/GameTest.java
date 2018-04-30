package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    private Game game;

    @Before
    public void setup() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4)).thenReturn("1 2 3 4");
        this.game = new Game(new AnswerGenerator(randomIntGenerator));
    }

    @Test
    public void test_success(){
        game.guess(Answer.createAnswer("1 2 3 4"));

        Assert.assertEquals(GameStatus.SUCCESS, game.checkStatus());
    }

    @Test
    public void test_continue(){
        game.guess(Answer.createAnswer("1 2 4 3"));
        Assert.assertEquals(GameStatus.CONTINUE, game.checkStatus());
    }

    @Test
    public void test_fail(){
        game.guess(Answer.createAnswer("6 7 8 9"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("5 4 7 8"));
        game.guess(Answer.createAnswer("5 6 9 8"));
        game.guess(Answer.createAnswer("5 6 7 9"));
        game.guess(Answer.createAnswer("1 6 7 9"));
        Assert.assertEquals(GameStatus.FAIL, game.checkStatus());
    }

}
