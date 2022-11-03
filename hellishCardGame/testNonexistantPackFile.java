import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
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
public class testNonexistantPackFile
{
    /**
     * Default constructor for test class testNonexistantPackFile
     */
    public testNonexistantPackFile()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        
    }
    


    @Test
    public void test1() throws Exception
    {
        Pack testPack= new Pack();
        Class packClass = testPack.getClass();
        Field fileName = packClass.getDeclaredField("fileName");
        fileName.setAccessible(true);
        fileName.set(testPack, "pack1.txt");
        Field nPlayers = packClass.getDeclaredField("nPlayers");
        nPlayers.setAccessible(true);
        nPlayers.set(testPack, 2);
        Method checkFileValidity= packClass.getDeclaredMethod("checkFileValidity");
        checkFileValidity.setAccessible(true);
        checkFileValidity.invoke(testPack);
        

        assertTrue (testPack.getValidity());
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
