/** Player.java
*   Author: Charlie Liu CRL2157
*   Date: 4/4/22
*   Player class as part of Crazy Eights
*   To be used with Game, Card, Deck classes
*
*/


//CHECK PRIVATE VS PUBLIC

import java.util.ArrayList;
import java.util.Scanner;

class Player{
    
    private ArrayList<Card> hand; // the player's hand
    private Scanner input;

    public Player(Deck deck, Scanner input){
    // constructor initializes instance variables
        this.input = input;
        hand = new ArrayList<Card>();
        for (int i = 0; i < 7; i++){
            hand.add(deck.deal());
        }
        // creates an arraylist then populates it w/ 7 cards from the deck 
    }

    public void addCard(Card c){
    // Mutator method that adds a card to the player's hand
        hand.add(c);
    }
   
    public Card playsTurn(Deck deck, Card faceup, char currentSuit){
    // Covers all the logic regarding a human player's turn

        while (true){
        // while loop so that the players keep playing until the game ends
            System.out.println("\nThis is your current hand: ");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println((i+1) + ") " + hand.get(i));
            }
            // updates players current hand after every turn

            System.out.println("\nCurrent face up card: " + faceup);
            System.out.println("Suit: "+faceup.fSuit(currentSuit)+"\n");
            // updates current face up card and formated suit after every turn
            
            String choice = makeChoice();

            if (choice.equals("draw")){
                if (deck.canDeal()){
                // checks if deck still has cards to deal when player draws
                    hand.add(deck.deal()); 
                    // if yes, deck draws card and adds it to players hand
                } else{
                    System.out.println("No more cards!");
                    return null;
                    // if no, returns null so game can end
                }                
            } else if(checkPlay(choice, faceup, currentSuit)){
            //if card played then checkPlay() method called to check validity
                Card tempHold = hand.get(Integer.valueOf(choice)-1);

                hand.remove(hand.get(Integer.valueOf(choice) - 1));
                return tempHold;
                // returns the played card using a temporary variable
            } else{
            // if player is cheating, returns nothing so player can replay
                System.out.println("STOP cheating CHEATER pick a valid card");
            }
        }
    }

    public ArrayList<Card> getHand(){
    // Accessor method for the players hand
        return hand;
    }

    public String handToString(){
    // Returns a printable string representing the player's hand
        String desc = "";
        for (Card card: hand){
            desc += card;
        }
        return desc;
    }

    private String makeChoice(){
    // method that prompts player to make a play
        System.out.println("Pick a card to play or type draw to draw");
        String choice = input.nextLine();
        return choice;
    }

    private boolean checkPlay(String choice, Card faceup, char currentSuit){
    // method that checks the players play for validity
        int choiceInt = Integer.valueOf(choice);

        if (choiceInt >= 1 && choiceInt <= hand.size()){
        // checks that the player is playing a card they actually have
            Card play = hand.get(choiceInt - 1);
            
            if (play.getRank()==faceup.getRank()||play.getSuit()==currentSuit){
            // checks that the card's rank matches rank or suit
                return true;
            }
            else if (play.getRank() == 8 ){
            // otherwise check if the card is an 8 (always playable)
                return true;
            }
        }
        return false;
    }
} 
// end
