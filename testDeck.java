

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The test class testDeck.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testDeck
{
    /**
     * Default constructor for test class testDeck
     */
    public testDeck()
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
    public void testGetDeckID() throws Exception{
        Deck testDeck = new Deck(1);
        assertEquals(1,testDeck.getDeckID());
        
    }
    
    @Test
    public void testAddCard() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        assertEquals(testCard, testDeck.getCardList().get(0));
        
    }
    
    @Test
    public void testRemoveCard() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        assertEquals(testCard, testDeck.removeCard());
        
    }
    
    @Test
    public void testRemoveCardOrdering() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        Card testCard2 = new Card(2);
        Card testCard3 = new Card(1);
        testDeck.addCard(testCard);
        testDeck.addCard(testCard2);
        testDeck.addCard(testCard3);
        assertEquals(testCard, testDeck.removeCard());
        
    }
    
    @Test
    public void testEndGame() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        Card testCard2 = new Card(2);
        Card testCard3 = new Card(1);
        testDeck.addCard(testCard);
        testDeck.addCard(testCard2);
        testDeck.addCard(testCard3);
        testDeck.endGame();
        try{
            File file = new File("deck1_output.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line=br.readLine();
            br.close();
            assertTrue(line.equals("deck 1 contents: 1 2 1"));
          } catch (IOException e){
            e.printStackTrace();
            assertTrue(false);
          }
        
        
        
    }
    
    @Test
    public void testIsNonEmptyDeckEmpty() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        assertFalse(testDeck.isDeckEmpty());
        
    }
    
    @Test
    public void testIsEmptyDeckEmpty() throws Exception{
        Deck testDeck = new Deck(1);
        assertTrue(testDeck.isDeckEmpty());
        
    }
    
    @Test
    public void testIsNonFullDeckFull() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        assertFalse(testDeck.isDeckFull());
        
    }
    
    @Test
    public void testIsFullDeckFull() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        Card testCard2 = new Card(1);
        testDeck.addCard(testCard2);
        Card testCard3 = new Card(1);
        testDeck.addCard(testCard3);
        Card testCard4 = new Card(1);
        testDeck.addCard(testCard4);
        assertTrue(testDeck.isDeckFull());
        
    }
    
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        try{
            File fileToDelete = new File("deck1_output.txt");
            fileToDelete.delete();
        }catch(Exception e) {
            
        }
    }
}
