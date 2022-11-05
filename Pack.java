import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * Object to handle pack of all cards in the game
 * Methods to read in a pack file, check file is valid and make card
 * instances
 *
 * @Jessie McColm and Lucia Adams
 * @version (a version number or a date)
 */
public class Pack
{
    private ArrayList<Card> cardList = new ArrayList<Card>();
    private String fileName;
    private int nPlayers;
    private boolean valid;

    /**
     * Constructor for objects of class Pack
     */
    public Pack(){this.valid=false;}

    /**
     * Reads file (fileName) if it is valid and creates insatnces of
     * cards and adds to cardList
     *
     * @param  fileName  name of pack file to be read
     * @param  nplayers number of players
     * @return   None
     */
    public void readPackFile(String fileName, int nPlayers)
    {
        this.fileName=fileName;
        this.nPlayers=nPlayers;
        checkFileValidity();
        if (valid){
          try{
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line;
            int cardValue;
            Card newCard;
            while((line = br.readLine()) != null){
              cardValue = Integer.parseInt(line);
              newCard = new Card(cardValue);
              cardList.add(newCard);
            }
            br.close();
          } catch (IOException e){
            e.printStackTrace();
          }
        } else {
          System.out.println("Please submit a valid pack file");
        }

    }

    /**
     * Checks file is valid - ie single non-negative integer
     * value, and has 8n rows
     *
     * @param fileName name of file to check validity of
     * @param nplayers number of players to check the file is valid for
     * @return valid  boolean of whether pack is valid or not
     *
     * if learn reflection- make private
     */
    private void checkFileValidity(){
        boolean isValid = true;
        int fileLines = 0;

        try{
          File file = new File(fileName);
          FileInputStream fis = new FileInputStream(file);
          BufferedReader br = new BufferedReader(new InputStreamReader(fis));

          String line;
          int num;
          while((line = br.readLine()) != null){
            try{
              num = Integer.parseInt(line);
              if (num<0){
                  isValid=false;
              }
            } catch (NumberFormatException e){
              isValid = false;
            }
            fileLines += 1;
          }
          br.close();
        } catch (IOException e){
          // issue reading file
          isValid = false;
        }

        if (fileLines != 8*nPlayers){
          isValid = false;
        }

        this.valid=isValid;
    }

    public boolean getValidity(){
        return this.valid;
    }

    /**
     * Method is getter for cardList
     *
     * @param  None
     * @return   cardList ArrayList of Card objects in the pack
     */
    public ArrayList<Card> getCardList()
    {
        return cardList;
    }
}
