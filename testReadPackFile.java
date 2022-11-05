import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.AfterClass;
import java.util.ArrayList;

/**
 * The test class testReadPackFile.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testReadPackFile
{   
    /**
     * Default constructor for test class testNonexistantPackFile
     */
    
    public testReadPackFile()
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
       
       
    
    }
    


    @Test
    public void validPackTest() throws Exception
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