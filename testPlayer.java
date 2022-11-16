

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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
    public void testFalseGetPlayerID() {
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        assertFalse(testPlayer.getPlayerID()==2);
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
    public void testFalseAddCard(){
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        Card testCard=new Card(1);
        Card testCard2=new Card(1);
        testPlayer.addCard(testCard);
        assertNotEquals(testPlayer.getHand().get(0),testCard2);
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
    public void testPickAndDrop() throws Exception{
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck2, testDeck1);
        Class playerClass = testPlayer.getClass();
        Method pickAndDrop= playerClass.getDeclaredMethod("pickAndDrop");
        pickAndDrop.setAccessible(true);
        
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(2));
        
        testDeck1.addCard(new Card(4));
        testDeck1.addCard(new Card(3));
        testDeck1.addCard(new Card(2));
        testDeck1.addCard(new Card(1));
        
        testDeck2.addCard(new Card(5));
        testDeck2.addCard(new Card(6));
        testDeck2.addCard(new Card(7));
        testDeck2.addCard(new Card(8));
        
        //should pick up from deck 2 - should pick up the card of value 5
        
        pickAndDrop.invoke(testPlayer);
        try{
            File file = new File("player1_output.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line1=br.readLine();
            String line2=br.readLine();
            String line3=br.readLine();
            br.close();

            boolean allLinesEqual=(line1.equals("player 1 draws a 1 from deck 1") && line2.equals("player 1 discards a 2 to deck 2") 
            && line3.equals("player 1 current hand: 1 1 1 1"));
            assertTrue(allLinesEqual);
          } catch (IOException e){
            e.printStackTrace();
            assertTrue(false);
          }
        
    }
    
    @Test
    public void testPickAndDropWithRandomness() throws Exception{
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        Class playerClass = testPlayer.getClass();
        Method pickAndDrop= playerClass.getDeclaredMethod("pickAndDrop");
        pickAndDrop.setAccessible(true);
        
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(1));
        testPlayer.addCard(new Card(2));
        
        testDeck1.addCard(new Card(1));
        testDeck1.addCard(new Card(2));
        testDeck1.addCard(new Card(3));
        testDeck1.addCard(new Card(4));
        
        testDeck2.addCard(new Card(5));
        testDeck2.addCard(new Card(6));
        testDeck2.addCard(new Card(7));
        testDeck2.addCard(new Card(8));
        
        //should pick up from deck 2 - should pick up the card of value 5
        
        pickAndDrop.invoke(testPlayer);
        try{
            File file = new File("player1_output.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line1=br.readLine();
            String line2=br.readLine();
            String line3=br.readLine();
            br.close();
        

            boolean allLinesEqual=(line1.equals("player 1 draws a 4 from deck 1") && (line2.equals("player 1 discards a 2 to deck 2") ||  
            line2.equals("player 1 discards a 4 to deck 2") ) && line3.equals("player 1 current hand: 1 1 1 1"));
            assertTrue(allLinesEqual);
          } catch (IOException e){
            e.printStackTrace();
            assertTrue(false);
          }
        
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
            String line1=br.readLine();
            String line2=br.readLine();
            String line3=br.readLine();
            br.close();
        

            boolean allLinesEqual=(line1.equals("player 1 wins") && line2.equals("player 1 exits") && line3.equals("player 1 final hand: 2 1 1 1"));
            assertTrue(allLinesEqual);
          } catch (IOException e){
            e.printStackTrace();
            assertTrue(false);
          }
    }
    
    
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
            String line1=br.readLine();
            String line2=br.readLine();
            String line3=br.readLine();
            br.close();
        

            boolean allLinesEqual=(line1.equals("player 3 has informed player 1 that player 3 has won") && line2.equals("player 1 exits") && line3.equals("player 1 final hand: 2 1 1 1"));
            assertTrue(allLinesEqual);
          } catch (IOException e){
            e.printStackTrace();
            assertTrue(false);
          }
    }
    
    @Test 
    public void testGetHand(){
        Deck testDeck1 = new Deck(1);
        Deck testDeck2 = new Deck(2);
        Player testPlayer = new Player(1,testDeck1, testDeck2);
        Card testCard=new Card(1);
        Card testCard2=new Card(1);
        Card testCard3=new Card(1);
        Card testCard4=new Card(1);
        testPlayer.addCard(testCard);
        testPlayer.addCard(testCard2);
        testPlayer.addCard(testCard3);
        testPlayer.addCard(testCard4);
        boolean testTruth=true;
        
        if(testPlayer.getHand().get(3)!=testCard || testPlayer.getHand().get(2)!=testCard2 
        || testPlayer.getHand().get(1)!=testCard3 || testPlayer.getHand().get(0)!=testCard4){
            testTruth=false;
        };
        assertTrue(testTruth);
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
