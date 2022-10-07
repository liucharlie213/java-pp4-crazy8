/** Deck.java
*   Author: Charlie Liu CRL2157
*   Date: 4/4/22
*
*   Models a typical deck of playing cards
*   To be used with Card class
*
*/

import java.util.Random;
class Deck{

    private Card[] deck; 
    private int top;
    public static final char[] suits = {'c','d','h','s'};

    public Deck(){ 
    // constructs a default Deck
        deck = new Card[52];
        //creates an empy array of 52 slots
        int cardNum = 0;
        for (int i = 0; i < suits.length; i++){
            for (int j = 1; j < 14; j++){
                deck[cardNum] = new Card(suits[i], j);
                cardNum++;
            }
            //fills the deck with 13 cards for each of the 4 suits
        }
        top = 0; 
    }

    public Card deal(){
    // Deals the top card off the deck
        top++;
        //modifies the reference to the top card of the deck
        return deck[top-1];
    }

    public boolean canDeal(){
    // returns true provided there is a card left in the deck to deal
        if (top < 52){
            return true;
        }
        else{
            return false;
        }
    }

    public void shuffle(){ 
    // Shuffles deck by switching the position of two random cards 1 mil times
        for (int i = 0; i < 1000000; i++){ 
            Random rand = new Random();
            int max = 51;
            int min = 0;
            int firstNum = rand.nextInt((max - min) + 1) + min;
            int secondNum = rand.nextInt((max - min) + 1) + min;
            // randomly generate two integers to pick which cards to switch
            
            Card first = deck[firstNum];
            deck[firstNum] = deck[secondNum];
            deck[secondNum] = first;
            // switches the position of the cards using a temporary variable 
        }
    }

    public String toString(){
    // Returns a string representation of the whole deck

        String deckStr = "";
        for(int i = 0; i < deck.length; i++){
            deckStr += deck[i] + "\n";
            // java will call on the toString method in the Card class
        }
        return deckStr;
    }
}