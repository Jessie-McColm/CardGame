import java.util.ArrayList;
import java.util.Random;
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

    /**
     * Constructor for objects of class Player
     */
    public Player(int playID, Deck dropper, Deck picker)
    {
        // initialise instance variables
        playerID = playID;
        dropDeck = dropper;
        pickDeck = picker;
        playerFile = String.format("player$d_output.txt", playerID);
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
        FileWriter fileToWrite = new FileWriter(playerFile);
        BufferedWriter ouput = new BufferedWriter(fileToWrite);
        output.write(stringToWrite);
        output.close();

      } catch (IOException e) {
        e.printStackTrace();
      }

    }

    /**
     * Checks if all cards in player hand have the same value
     * Player wins the game if they do
     * Triggers game to end??
     *
     * @param  None
     * @return  None
     */
    public void checkVictory(){

      boolean hasWon = true;
      int firstCard;

      if (hand.size() == 4){
        firstCard = hand.get(0).getCardValue();

        for (Card eachCard : hand){
          if (eachCard.getCardValue() != firstCard){
            hasWon = false;
            break;
          }
        }
      } else {
        hasWon = false;
      }

      // stop all theads immediately after player wins
      // call event to end threads etc and output to files
      // should store the winner or winner ID
    }

    /**
     * Output to screen the player has won and write this to player file
     * Then calls endGame method
     *
     * @param  None
     * @return  None
     */
    public void win(){

      String winMessage = String.format("player %d wins", playerID)
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
      "player %d has informed player %d that player %d has won", winnerID, playerID, winnerID)

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

      if (pickDeck.isFull()){

        Card pickedCard = pickDeck.removeCard();

        // this.checkVictory();  here??
        // or could just say if got 4 of same then drop one not the same


        ArrayList<Card> possibleDrops = new ArrayList<Card>();

        for (Card eachCard : hand){
          if (eachCard.getCardValue() != playerID){
            possibleDrops.add(eachCard);
          }
        }

        Random random = new Random();
        int randNum = random.nextInt(possibleDrops.size()-1);
        Card cardToDrop = possibleDrops.get(randNum);

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
      checkVictory();

      while (true){
        // checkVictory() - do we tdo this here or in pickAndDrop?
        if (hand.size() == 4){
          this.pickAndDrop();
        }
      }

    }
}
