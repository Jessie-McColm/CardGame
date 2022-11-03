import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.AfterClass;

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
    public void setUp()
    {
        String filename = "IamNotReal.txt";
        Pack testPack= new Pack();

    }


    @Test
    public void test()
    {
        //assert 
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
