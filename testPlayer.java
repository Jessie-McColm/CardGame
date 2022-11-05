

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.After;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The test class testPlayer.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testPlayer
{
    /**
     * Default constructor for test class testPlayer
     */
    public testPlayer()
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

    @Test
    public void testGetPlayerID() {
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        assertTrue(testPlayer.getPlayerID()==1);
    }
    
    @Test
    public void testWriteToPlayerFile() {
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        
        
    }
    
    @Test 
    public void testAddCard(){
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        Card testCard=new Card(1);
        testPlayer.addCard(testCard);
        assertEquals(testPlayer.getHand().get(0),testCard);
    }
    
    @Test 
    public void testGetCard(){
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        Card testCard=new Card(1);
        testPlayer.addCard(new Card(1));
        assertNotEquals(testPlayer.getHand().get(0),testCard);
    }
    
    
    
    @Test
    public void testCheckVictoryWhenWinner() {
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        assertTrue(testPlayer.checkVictory());
        
        
    }
    
    @Test
    public void testCheckVictoryWhenNotWinner() {
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(2));
        assertFalse(testPlayer.checkVictory());
        
        
    }
    
    @Test
    public void testWin(){
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(2));
        testPlayer.win();
        try{
            File file = new File("player1_output.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line=br.readLine();
            br.close();
            assertTrue(line.equals("player 1 wins"));
          } catch (IOException e){
            e.printStackTrace();
            assertTrue(false);
          }
    }
    
    
    //need to double cj=heck these - should be failing i think rn
    @Test
    public void testLoss(){
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(2));
        testPlayer.loss(3);
        try{
            File file = new File("player1_output.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line=br.readLine();
            br.close();
            assertTrue(line.equals("player 3 has informed player 1 that player 3 has won"));
          } catch (IOException e){
            e.printStackTrace();
            assertTrue(false);
          }
    }
    
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        try{
            File fileToDelete = new File("player1_output.txt");
            fileToDelete.delete();
        }catch(Exception e) {
            
        }
    }
}
