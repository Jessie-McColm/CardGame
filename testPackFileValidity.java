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

/**
 * The test class testNonexistantPackFile.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testPackFileValidity
{
    /**
     * Default constructor for test class testNonexistantPackFile
     */
    public testPackFileValidity()
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
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        
    }
    


    @Test
    public void validPackTest() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "validPack.txt");
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
        fileName.set(testPack, "longerValidPack.txt");
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
        fileName.set(testPack, "sortPack.txt");
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
        fileName.set(testPack, "longPack.txt");
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
        fileName.set(testPack, "invalidCharPack.txt");
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
        fileName.set(testPack, "zeroPack.txt");
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
        fileName.set(testPack, "negativePack.txt");
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
        fileName.set(testPack, "emptyPack.txt");
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
        fileName.set(testPack, "emptyPack.txt");
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
