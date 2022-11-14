
/**
 * Object acting as deck of cards. Consists of list of cards it stores
 * and methods to add and remove cards
 *
 * @Jessie McColm and Lucia Adams
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Deck {

    private int deckID;
    // start of list is bottom of deck, end of list is top
    private ArrayList<Card> cardList = new ArrayList<Card>();

    private String deckFile;

    /**
     * Constructor for objects of class Deck
     */
    public Deck(int ID)
    {
        deckID = ID;
        deckFile = String.format("deck%d_output.txt", deckID);
    }

    public int getDeckID(){
      return deckID;
    }

    /**
     *
     *
     * @param  none  Card object to add
     * @return    none
     */
    public ArrayList<Card> getCardList()
    {
      return cardList;
    }

    /**
     * Method to add Card object to the Deck list (to bottom of deck)
     *
     * @param  cardName  Card object to add
     * @return    none
     */
    public synchronized void addCard(Card cardName)
    {
      // check whether full of not done in Player
      cardList.add(cardName);
    }

    /**
     * Method to remove Card object from the Deck list (from top of deck)
     *
     * @param  None
     * @return cardToReturn Card object removed from deck
     */
    public synchronized Card removeCard()
    {
        Card cardToReturn= null;

        if (cardList.size() != 0){

          //while (cardToReturn == null){
           //cardToReturn = cardList.get(cardList.size()-1);
           cardToReturn=cardList.remove(0);
          }



        return cardToReturn;
    }

    public Boolean isTooBig(){
      boolean isTooBig = false;

      if (cardList.size() > 4){
        isTooBig = true;
      }

      return isTooBig;
    }

    /**
     * Method to output deck content to file named after deckID
     * at the end of the game
     *
     * @param  None
     * @return  None
     */
    public void endGame(){

        String textFileString;
        ArrayList<String> cardListContent = new ArrayList<String>();

        for (Card cardItem : cardList){
          cardListContent.add(cardItem.toString());
        }

        textFileString = String.format("deck %d contents: ",deckID);
        textFileString += String.join(" ", cardListContent);

        try {
          FileWriter fileToWrite = new FileWriter(deckFile);
          BufferedWriter output = new BufferedWriter(fileToWrite);
          output.write(textFileString);
          output.close();

        } catch (IOException e) {
          e.printStackTrace();
        }

    }

    /**
     * Method to check whether the deck is empty (True if empty)
     *
     * @param None
     * @return isEmpty boolean whether the deck is empty or not
     */
    public boolean isDeckEmpty(){

       boolean isEmpty;

       if (cardList.size() == 0){isEmpty = true;
       } else { isEmpty = false;}

       return isEmpty;
    }

    /**
     * Method to check whether the deck is full (True if full)
     *
     * @param  None
     * @return   isFull boolean whether the deck is full or not
     */
    public boolean isDeckFull(){

      boolean isFull;

      if (cardList.size() >= 4){
        isFull = true;
      } else {
        isFull = false;
      }
       return isFull;
    }



}
