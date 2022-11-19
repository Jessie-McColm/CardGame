
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.AfterClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * The test class testNonexistantPackFile.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testPack
{
    /**
     * Default constructor for test class testNonexistantPackFile
     */
    public testPack()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() throws Exception
    {
       
        
    }
    
    @Test
    public void readValidPackTest() throws Exception
    {
        Pack testPack= new Pack();
        testPack.readPackFile("./packFiles/validPack.txt",2);
        ArrayList<Card> testCardList = testPack.getCardList();
        int[] cards = {1,4,88,99,5,65,76,43,86,34,56,3,7,5,56,33};
        ArrayList<Card> cardList = new ArrayList<Card>();
        for (int eachCard:cards){
            Card cardToAdd =new Card(eachCard);
            cardList.add(cardToAdd);
        }
        
        boolean areEqual=true;
        if (cardList.size()==testCardList.size()){
            for (int i =0; i< cardList.size(); i++){
                if (cardList.get(i).getCardValue() != testCardList.get(i).getCardValue()){
                    areEqual=false;
                }
            }
        
        

        }else{
            areEqual=false;
        }
        assertTrue(areEqual);
    }
    
    @Test
    public void testReadInvalidPack() throws Exception
    {
        Pack testPack= new Pack();
        testPack.readPackFile("./packFiles/invalidCharPack.txt",2);
        ArrayList<Card> testCardList = testPack.getCardList();
        assertTrue(testCardList.size()==0);
    }


    @Test
    public void validPackTest() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/validPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertTrue (testPack.getValidity());
    }
    
    @Test
    public void longerValidPackTest() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/longerValidPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 3);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertTrue (testPack.getValidity());
    }
    
    @Test
    public void testShortPack() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/sortPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertFalse (testPack.getValidity());
    }
    
    @Test
    public void testLongPack() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/longPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertFalse (testPack.getValidity());
    }
    
    @Test
    public void testInvalidCharPack() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/invalidCharPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertFalse (testPack.getValidity());
    }
    
    @Test
    public void testZeroPack() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/zeroPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertTrue (testPack.getValidity());
    }
    
    @Test
    public void testNegativePack() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/negativePack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertFalse (testPack.getValidity());
    }
    
    @Test
    public void testEmptyPack() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/emptyPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertFalse (testPack.getValidity());
    }
    
    @Test
    public void testNonexistantPackFile() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "./packFiles/emptyPack.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertFalse (testPack.getValidity());
    }
    
    
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
