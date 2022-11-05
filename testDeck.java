

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        
        //need to check some file stuff here - will have to wait to ask lucia about this
        
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
    @AfterEach
    public void tearDown()
    {
    }
}
