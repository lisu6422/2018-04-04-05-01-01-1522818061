package tw.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GameController gameController;
    private InputCommand inputCommand;


    @Before
    public void setup() throws OutOfRangeAnswerException {
        this.inputCommand = mock(InputCommand.class);
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4)).thenReturn("1 2 3 4");
        this.gameController = new GameController(new Game(new AnswerGenerator(randomIntGenerator)),new GameView());
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void test_success() throws IOException {
        gameController.beginGame();

        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));
        gameController.play(inputCommand);
        Assert.assertTrue(systemOut().endsWith("Game Status: success\n"));

    }

    @Test
    public void test_fail() throws IOException {
        gameController.beginGame();

        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 5"));
        gameController.play(inputCommand);
        Assert.assertTrue(systemOut().endsWith("Game Status: fail\n"));

    }



    private String systemOut() {
        return outContent.toString();
    }

}