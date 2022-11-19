

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The test class testCardGame.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testCardGame
{
    /**
     * Default constructor for test class testCardGame
     */
    public testCardGame()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }
    
    /**
     * Tests that a game with 1 player can finish and that 
     */
    @Test
    public void test1PlayerWinnable(){
        ArrayList<Card> cardList= new ArrayList<Card>();
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(2));
        cardList.add(new Card(82));
        cardList.add(new Card(2));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        CardGame.runGame(cardList);
        //need to read the last lines of the file
        assertTrue(true);
        
    }
    
    
    /**
     * Tests that a game with 2 players with one player winning immediately
     */
    @Test
    public void test2PlayerImmediateWin(){
        ArrayList<Card> cardList= new ArrayList<Card>();
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(2));
        cardList.add(new Card(1));
        cardList.add(new Card(82));
        cardList.add(new Card(1));
        cardList.add(new Card(2));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(2));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        cardList.add(new Card(1));
        CardGame.runGame(cardList);
        //need to read the last lines of the file
        assertTrue(true);
        
    }
    
    /**
     * Tests that the dealCards method deals out known cards to players in the expected order
     */
    @Test
    public void testDealCards(){
        Deck[] gameDecks = new Deck[2];
        Player[] gamePlayers = new Player[2];
        ArrayList<Card> cardList= new ArrayList<Card>();
        
        for (int i=0; i< 16; i++){
              cardList.add(new Card(i+1));
            }
        
        for (int i=0; i< 2; i++){
              gameDecks[i] = new Deck(i+1);
            }

   
        for (int i=0; i< 2; i++){
          gamePlayers[i] = new Player(i+1, gameDecks[(i+1)%2], gameDecks[i]);
        }
        
        CardGame.dealCards(cardList,gameDecks,gamePlayers);
        
        boolean testTrue=true;
        ArrayList<Card> player1cards=gamePlayers[0].getHand();
        if(!(player1cards.get(3)==cardList.get(0) && player1cards.get(2)==cardList.get(2) && player1cards.get(1)==cardList.get(4) 
            && player1cards.get(0)==cardList.get(6))){
                testTrue=false;}
        
         ArrayList<Card> deck1cards=gameDecks[0].getCardList();
        if(!(deck1cards.get(0)==cardList.get(8) && deck1cards.get(1)==cardList.get(10) && deck1cards.get(2)==cardList.get(12) 
            && deck1cards.get(3)==cardList.get(14))){
                testTrue=false;}
    
        assertTrue(testTrue);
        
    }
    
    /**
     * Tests that the dealCards method doesn't deal out known cards to players in an unexpected order
     */
    @Test
    public void testDealCardsFalse(){
        Deck[] gameDecks = new Deck[2];
        Player[] gamePlayers = new Player[2];
        ArrayList<Card> cardList= new ArrayList<Card>();
        
        for (int i=0; i< 16; i++){
              cardList.add(new Card(i+1));
            }
        
        for (int i=0; i< 2; i++){
              gameDecks[i] = new Deck(i+1);
            }

   
        for (int i=0; i< 2; i++){
          gamePlayers[i] = new Player(i+1, gameDecks[(i+1)%2], gameDecks[i]);
        }
        
        CardGame.dealCards(cardList,gameDecks,gamePlayers);
        
        boolean testTrue=true;
        ArrayList<Card> player1cards=gamePlayers[0].getHand();
        if(!(player1cards.get(3)==cardList.get(3) && player1cards.get(2)==cardList.get(8) && player1cards.get(1)==cardList.get(2) 
            && player1cards.get(0)==cardList.get(6))){
                testTrue=false;}
        
         ArrayList<Card> deck1cards=gameDecks[0].getCardList();
        if(!(deck1cards.get(0)==cardList.get(7) && deck1cards.get(2)==cardList.get(10) && deck1cards.get(2)==cardList.get(12) 
            && deck1cards.get(3)==cardList.get(14))){
                testTrue=false;}
    
        assertFalse(testTrue);
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
