import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
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
    public void testGetDeckID(){
        Deck testDeck = new Deck(1);
        assertEquals(1,testDeck.getDeckID());
        
    }
    
    @Test
    public void testAddCard(){
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        assertEquals(testCard, testDeck.getCardList().get(0));
        
    }
    
    @Test
    public void testRemoveCard() {
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        assertEquals(testCard, testDeck.removeCard());
        
    }
    
    @Test
    public void testRemoveCardOrdering(){
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
    public void testGetCardListOrdering(){
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        Card testCard2 = new Card(2);
        Card testCard3 = new Card(1);
        testDeck.addCard(testCard);
        testDeck.addCard(testCard2);
        testDeck.addCard(testCard3);
        assertTrue(testDeck.getCardList().get(0)==testCard && 
        testDeck.getCardList().get(1)==testCard2 && testDeck.getCardList().get(2)==testCard3);
    }
    
    @Test
    public void testGetCardListOrderingIsNot(){
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        Card testCard2 = new Card(2);
        Card testCard3 = new Card(1);
        testDeck.addCard(testCard);
        testDeck.addCard(testCard2);
        testDeck.addCard(testCard3);
        assertFalse(testDeck.getCardList().get(2)==testCard);
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
    public void testIsNonEmptyDeckEmpty() {
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        assertFalse(testDeck.isDeckEmpty());
        
    }
    
    @Test
    public void testIsEmptyDeckEmpty() {
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
    
    @Test
    public void testBigDeckIsTooBig() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        Card testCard2 = new Card(1);
        testDeck.addCard(testCard2);
        Card testCard3 = new Card(1);
        testDeck.addCard(testCard3);
        Card testCard4 = new Card(1);
        testDeck.addCard(testCard4);
        Card testCard5 = new Card(2);
        testDeck.addCard(testCard5);
        assertTrue(testDeck.isTooBig());
        
    }
    
    @Test
    public void testSmallDeckIsTooBig() throws Exception{
        Deck testDeck = new Deck(1);
        Card testCard = new Card(1);
        testDeck.addCard(testCard);
        Card testCard2 = new Card(1);
        testDeck.addCard(testCard2);
        Card testCard3 = new Card(1);
        testDeck.addCard(testCard3);
        Card testCard4 = new Card(1);
        testDeck.addCard(testCard4);
        assertFalse(testDeck.isTooBig());
        
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
            File fileToDelete = new File("deck1_output.txt");
            fileToDelete.delete();
        }catch(Exception e) {
            
        }
    }
}
