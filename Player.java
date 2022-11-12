import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player implements Runnable
{
    // instance variables - replace the example below with your own]
    private int playerID;
    private ArrayList<Card> hand= new ArrayList<Card>();
    private Deck dropDeck;
    private Deck pickDeck;
    private String playerFile;
    private Boolean hasWon;
    private volatile Boolean alive;

    /**
     * Constructor for objects of class Player
     */
    public Player(int playID, Deck dropper, Deck picker)
    {
        // initialise instance variables
        playerID = playID;
        dropDeck = dropper;
        pickDeck = picker;
        alive = true;
        hasWon = false;
        playerFile = String.format("player%d_output.txt", playerID);

        // find better way of creating file if doesnt exist and
        // overridng one that does
        // also shouldnt be in try except
        try{
        FileWriter fileToWrite = new FileWriter(playerFile);
        BufferedWriter output = new BufferedWriter(fileToWrite);
        output.write("");
        output.close();
      } catch(Exception e){}


    }

    public void kill(){
      alive = false;
    }

    public int getPlayerID(){
      return playerID;
    }

    /**
     * Writes stringToWrite to player output file
     *
     * @param  stringToWrite string to write to file
     * @return  None
     */
    private void writeToPlayerFile(String stringToWrite){

      try {
        // true in FileWritter sets to append mode
        FileWriter fileToWrite = new FileWriter(playerFile, true);
        BufferedWriter output = new BufferedWriter(fileToWrite);
        output.write(stringToWrite);
        output.close();

      } catch (IOException e) {
        e.printStackTrace();
      }

    }

    /**
     * Method to add Card object to the Deck list (to bottom of deck)
     *
     * @param  cardName  Card object to add
     * @return    none
     */
    public void addCard(Card cardName)
    {
      // check whether full of not done in Player
      hand.add(0, cardName);
    }

    /**
     * Checks if all cards in player hand have the same value
     * Player wins the game if they do
     * Triggers game to end??
     *
     * @param  None
     * @return  None
     */
    public boolean checkVictory(){

      boolean winner = true;
      int firstCard;

      if (hand.size() == 4){
        firstCard = hand.get(0).getCardValue();

        for (Card eachCard : hand){
          if (eachCard.getCardValue() != firstCard){
            winner = false;
            break;
          }
        }
      } else {
        winner = false;
      }

      hasWon = winner;
      if (hasWon){
        this.alive = false;
      }

      return hasWon;


      // stop all theads immediately after player wins
      // call event to end threads etc and output to files
      // should store the winner or winner ID
    }

    /**
     *
     *
     * @param
     * @return
     */
    public Boolean getHasWon(){
      return this.hasWon;

    }

    /**
     * Output to screen the player has won and write this to player file
     * Then calls endGame method
     *
     * @param  None
     * @return  None
     */
    public void win(){

      String winMessage = String.format("player %d wins \n", playerID);
      System.out.print(winMessage);
      endGame(winMessage);

    }

    /**
     * Write that the player has lost to another player in player file
     * Then calls endGame method
     *
     * @param  winnerID playerID of the player than has won
     * @return  None
     */
    public void loss(int winnerID){

      String lossMessage = String.format(
      "player %d has informed player %d that player %d has won", winnerID, playerID, winnerID);

      endGame(lossMessage);

    }

    /**
     * Write to player file that they have exited and write their hand
     *
     * @param  endMessage  message deatilign a win or loss
     * @return    the sum of x and y
     */
    private void endGame(String endMessage){

      String textFileString;
      ArrayList<String> handContent = new ArrayList<String>();

      for (Card cardItem : hand){
        handContent.add(cardItem.toString());
      }

      textFileString = endMessage + "\n" + String.format("player %d exits\n", playerID) ;
      textFileString += String.format("player %d final hand: ",playerID);
      textFileString += String.join(" ", handContent);

      writeToPlayerFile(textFileString);

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private synchronized void pickAndDrop(){

      String textFileString;

      if (pickDeck.isDeckFull() && !dropDeck.isTooBig()){

        Card pickedCard = pickDeck.removeCard();

        if (pickedCard == null){
          System.out.println("The card is null fuckers");
        }

        ArrayList<Card> possibleDrops = new ArrayList<Card>();

        for (Card eachCard : hand){
          if (eachCard.getCardValue() != playerID){
            possibleDrops.add(eachCard);
          }
        }

        int dropNum;
        if (possibleDrops.size() > 1){
          Random random = new Random();
          int randNum = random.nextInt(possibleDrops.size()-1);
          dropNum = randNum;
        } else {
          dropNum = 0;
        }
        Card cardToDrop = possibleDrops.get(dropNum);


        hand.remove(cardToDrop);
        dropDeck.addCard(cardToDrop);

        hand.add(pickedCard);

        textFileString = String.format("player %d draws a %d from deck %d\n",
        playerID, pickedCard.getCardValue(),pickDeck.getDeckID());
        textFileString += String.format("player %d discards a %d to deck %d\n",
        playerID, cardToDrop.getCardValue(), dropDeck.getDeckID());

        ArrayList<String> handContent = new ArrayList<String>();

        for (Card cardItem : hand){
          handContent.add(cardItem.toString());
        }

        textFileString += String.format("player %d current hand: ",playerID);
        textFileString += String.join(" ", handContent) + "\n";

        writeToPlayerFile(textFileString);


     }
    }


    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }


    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void run(){


      while (alive){
        if (hand.size() == 4){
          if (checkVictory()){
            break;
          }
          this.pickAndDrop();
        }
      }

    }
}
