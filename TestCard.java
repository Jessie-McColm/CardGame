

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TestCard.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestCard
{
    /**
     * Default constructor for test class TestCard
     */
    public TestCard()
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
    public void testGetCardValue() {
        Card testCard=new Card(1);
        assertTrue(testCard.getCardValue()==1);
    }
    
    @Test 
    public void testCardToString() {
        Card testCard=new Card(1);
        assertTrue(testCard.toString().equals("1"));
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
