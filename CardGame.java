/**
 * Main class that runs the card game
 *
 * @Jessie McColm and Lucia Adams
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;

public class CardGame {

  public static void main(String[] args){

    // takes user inputs
    ArrayList<Card> cardList = setUpCards();
    int numOfPlayers = cardList.size()/8;

    Deck[] gameDecks = new Deck[numOfPlayers];
    Player[] gamePlayers = new Player[numOfPlayers];

    // loop through to make the decks
    for (int i=0; i< numOfPlayers; i++){
      gameDecks[i] = new Deck(i+1);
    }

    //loop through to make the players
    // with their corresponding pick and drop decks
    for (int i=0; i< numOfPlayers; i++){
      gamePlayers[i] = new Player(i+1, gameDecks[(i+1)%numOfPlayers], gameDecks[i]);
    }

    dealCards(cardList, gameDecks, gamePlayers);

    for (Player eachPlayer : gamePlayers){
      Thread playerThread = new Thread (eachPlayer);
      playerThread.start();
    }



    // Create the decks and players :)
    // Deal out the cards to the decks and players :)
    // start the threads yay

  }

  /**
   * Method to take in user input of number of players and deck file
   *
   * @param  None
   * @return  cardList list of cards in the game
   */
  public static ArrayList<Card> setUpCards(){

    Scanner readInput = new Scanner(System.in);
    boolean invalidInput = true;
    //has to be set to 0 as java doesn't like lack of instantiation - will always be changed if
    //we break out of the first while loop
    int nOfPlayers = 0;

    // Enter the number of players
    while (invalidInput){
      System.out.println("Please enter the number of players:");
      if (readInput.hasNextInt()){
        nOfPlayers = readInput.nextInt();
        readInput.nextLine(); // as only reads int. Needs to clear over rest of line
        if (nOfPlayers > 0){invalidInput = false;}
      }
    }

    invalidInput = true;
    Pack cardPack = new Pack();

    // Enter the pack file name
    while (invalidInput){
      System.out.println("Please enter location of pack to load:");
      String filename = readInput.nextLine();
      cardPack.readPackFile(filename, nOfPlayers);
      invalidInput = !(cardPack.getValidity());

    }

    ArrayList<Card> cardList = new ArrayList<Card>();
    cardList = cardPack.getCardList();

    return cardList;

  }

  public static void dealCards(ArrayList<Card> cardsInGame, Deck[] decksInGame,
  Player[] playersInGame){

    int cardCounter = 0;

    for (int i=0; i<4 ; i++){
      for (Player eachPlayer : playersInGame){
        eachPlayer.addCard(cardsInGame.get(cardCounter));
        cardCounter++;
      }
    }

    for (int i=0; i<4 ; i++){
      for (Deck eachDeck : decksInGame){
        eachDeck.addCard(cardsInGame.get(cardCounter));
        cardCounter++;
      }
    }
  }


}
