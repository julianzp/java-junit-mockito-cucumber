import org.example.Game;
import org.example.dao.RandomDao;
import org.example.dao.ScannerDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.when;

//ESTA ES LA CLASE QUE IMPLEMENTA MOCKITO
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;

    private ByteArrayOutputStream out;


    // De esta forma se captura todo lo que SALE POR CONSOLA
    @Before
    public void setUp(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @InjectMocks
    private Game game;

    @Mock
    ScannerDao scannerDao;

    @Mock
    RandomDao random;

    // *************************************En todos estos TEST gana el USUARIO*****************************************
    @Test
    public void when_writeQuit_ExitGame (){

        when(scannerDao.readLine()).thenReturn("Quit");

        game.play();

        Assert.assertTrue(out.toString().contains("Let's play Rock"));

    }

    @Test
    public void when_chooseRock_then_beatsScissors (){

        when(scannerDao.readLine()).thenReturn("Rock").thenReturn("Quit");

        when(random.nextInt(3)).thenReturn(OPTION_SCISSORS);

        game.play();

        Assert.assertTrue(out.toString().contains("Computer chose scissors"));
        Assert.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_chooseScissors_then_beatsPaper (){

        when(scannerDao.readLine()).thenReturn("Scissors").thenReturn("Quit");

        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();

        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_choosePaper_then_beatsRock (){

        when(scannerDao.readLine()).thenReturn("Paper").thenReturn("Quit");

        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();

        Assert.assertTrue(out.toString().contains("Computer chose rock"));
        Assert.assertTrue(out.toString().contains("wins:1"));

    }

    // *************************************En este TEST hay EMPATE*****************************************************
    @Test
    public void when_bothChooseRock_then_tie (){

        when(scannerDao.readLine()).thenReturn("Rock").thenReturn("Quit");

        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();

        Assert.assertTrue(out.toString().contains("Computer chose rock"));
        Assert.assertTrue(out.toString().contains("wins:0"));
        Assert.assertTrue(out.toString().contains("ties:1"));

    }

    // *************************************En este TEST gana la COMPUTADORA********************************************
    @Test
    public void when_chooseRockAndComputerChoosePaper_then_lose (){

        when(scannerDao.readLine()).thenReturn("Rock").thenReturn("Quit");

        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();

        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("loses:1"));

    }


}
