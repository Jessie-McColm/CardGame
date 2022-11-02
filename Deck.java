
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
public class Deck
{
    // instance variables - replace the example below with your own
    private int deckID;
    private ArrayList<Card> cardList = new ArrayList<Card>();
    

    /**
     * Constructor for objects of class Deck
     */
    public Deck(int ID)
    {
        deckID=ID;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addCard(Card cardName)
    {
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Card removeCard()
    {
        return cardToReturn;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void endGame()
    {
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isDeckEmpty()
    {
       return isEmpty; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isDeckFull()
    {
       return isFull; 
    }
    
    
    
}
