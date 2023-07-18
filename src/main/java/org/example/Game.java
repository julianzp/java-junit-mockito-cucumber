package org.example;
import org.example.dao.RandomDao;
import org.example.dao.ScannerDao;

public class Game {

    public Game(ScannerDao scannerDao, RandomDao random){
        this.scannerDao = scannerDao;
        this.random = random;
    }
    
    private ScannerDao scannerDao;
    private RandomDao random;

    public void play() {

        //start game
        printGameRules();

        ScoreBoard scoreBoard = new ScoreBoard();

        String choice = scannerDao.readLine().toUpperCase(); //prompt response

        while (!choice.equals("QUIT")) //do the following if the user does not put in "quit"
        {
            GameOption choicenum = getChoiceNum(choice);

                while(choicenum == null) //continue while user input is still not valid
                {
                    System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                    choice = scannerDao.readLine().toUpperCase();

                    choicenum = getChoiceNum(choice);


                }

            GameOption compnum = getComputerChoose();

            incrementScores(scoreBoard, choicenum, compnum);

            printGameResults(scoreBoard);

            choice = scannerDao.readLine().toUpperCase(); //prompt for new user input
        }


    }

    private static void printGameResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLosses() + "\nties:" + scoreBoard.getTies()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private static void incrementScores(ScoreBoard scoreBoard, GameOption choicenum, GameOption compnum) {

        if(choicenum == compnum) //tie cases
        {
            ties(scoreBoard);
        }
        else if (compareChoices(choicenum, compnum))
        {
            wins(scoreBoard);
        }
        else //otherwise computer wins
        {
            lose(scoreBoard);
        }
    }

    private static void lose(ScoreBoard scoreBoard) {
        System.out.println("you lose.");
        scoreBoard.incrementLosses();
    }

    private static void wins(ScoreBoard scoreBoard) {
        System.out.println("you win!");
        scoreBoard.incrementWins();
    }

    private static void ties(ScoreBoard scoreBoard) {
        System.out.println("It's a tie");
        scoreBoard.incrementTies();
    }

    private static boolean compareChoices(GameOption choicenum, GameOption compnum) {
        return (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS) ||
                (choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER) || (choicenum == GameOption.PAPER && compnum == GameOption.ROCK);
    }

    private static void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    // SETEA las opciones del enum, para imprimir y retornarla
    private GameOption getComputerChoose(){

        GameOption optionRandom = GameOption.values()[random.nextInt(3)];;//computer generate random num

        System.out.println("Computer chose " +optionRandom.toString().toLowerCase());

        return optionRandom;

    }

    private GameOption getChoiceNum(String choice){

        GameOption selectedOption = null;

        if (choice.equals("quit"))
            System.exit(0); //quit program

        try{
            selectedOption = GameOption.valueOf(choice);
        } catch (Exception e) {
            return null;
        }

        return selectedOption;

    }
}
