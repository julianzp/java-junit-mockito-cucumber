import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Game;
import org.example.dao.RandomDao;
import org.example.dao.ScannerDao;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GameSteps {
    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;

    @InjectMocks
    private Game game;

    @Mock
    ScannerDao scannerDao;

    @Mock
    RandomDao random;
    private ByteArrayOutputStream out;


    // De esta forma se captura todo lo que SALE POR CONSOLA
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }


    @Given("the user will choose {string}")
    public void theUserWillChoose(String userOption) {
        MockitoAnnotations.initMocks(this);
        when(scannerDao.readLine()).thenReturn(userOption).thenReturn("Quit");
    }

    @And("the computer will chose {string}")
    public void theComputerWillChose(String computerOption) {
        int selection = 0;
        if("scissors".equals(computerOption)){
            selection = OPTION_SCISSORS;
        }
        if("rock".equals(computerOption)){
            selection = OPTION_ROCK;
        }
        if("paper".equals(computerOption)){
            selection = OPTION_PAPER;
        }
        when(random.nextInt(3)).thenReturn(selection);
    }

    @When("they play")
    public void theyPlay() {
        game.play();
    }

    @Then("the user wins")
    public void theUserWins() {
        Assert.assertTrue(out.toString().contains("Computer chose scissors"));
        Assert.assertTrue(out.toString().contains("wins:1"));
    }
}
