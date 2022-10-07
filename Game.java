/** Game.java
*   Author: Charlie Liu CRL2157
*   Date: 4/4/22
*   
*   Game class for playing crazy eights in commandline
*   To be used with Player, Card, Deck classes
*
*/


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Game{

    private char currentSuit; 
    private Card faceup; 
    private Scanner input;
    private Player p1;
    private ArrayList<Card> compHand;
    private Deck cards;
    
    // sets up the Game object for play
    public Game(){ 
        input = new Scanner(System.in);
        cards = new Deck();
        cards.shuffle();
        // shuffle the deck before dishing out cards
        p1 = new Player(cards, input);

        compHand = new ArrayList<Card>();
        for (int i = 0; i < 7; i++){
            compHand.add(cards.deal()); 
        }
        // create array list for computers hand, then fill with 7 cards

        faceup = cards.deal();
        currentSuit = faceup.getSuit(); 
    }

    public boolean play(){
    // Plays a game of crazy eights 
        while(true){
        // Returns true to continue playing and false to stop playing
            Card p1Play = p1.playsTurn(cards, faceup, currentSuit);
            if (p1Play == null){
            // if there are no more cards in the deck
                return gameOver();
            }
            if (p1.getHand().size() != 0){
            // if p1 hasn't won yet
                faceup = p1Play;
                currentSuit = faceup.getSuit();
                if (faceup.getRank() == 8){
                    System.out.println("Please pick a suit (c, h, d, s): ");
                    currentSuit = input.nextLine().charAt(0);
                    // if p1 plays 8 let them pick suit and update currentSuit
                }
            } else{
            // otherwise p1 has no more cards and they won
                return gameOver();
            }
            if (compHand.size() != 0){
            // if computer has not won yet
                Card compPlay = computerTurn();
                faceup = compPlay;
            } else{
                return gameOver();
            // otherwise computer has no more cards and it won
            }
        }
    }

    private Card computerTurn(){ 
        for (Card card: compHand){
            Card value = compCard(card);
            // checks each card for playability by calling compCard() method
            
            if (value != null){
            // will play the first card that is playable
                compHand.remove(value);
                return value;
            }
        }  

        while (true) {
        // terminates once computer plays a card or deck runs out
            if (cards.canDeal()){
            // checks if deck still has cards
                Card card = cards.deal();
                compHand.add(card);
                System.out.println("The computer drew a card");
                // if yes computer draws card and updates player
                
                Card value = compCard(card);
                // plays the first playable drawn card
                if (value != null) {
                    compHand.remove(value);
                    return value;
                }

            } else {
            // otherwise deck is empty so game ends
                return null;
            }
        }
    }

    private Card compCard(Card card){
        if (card.getRank() == 8){
        // if computer plays 8 it randomly pick which suit to change to
            char[] suits = {'c', 'h', 'd', 's'};
            
            int min = 0;
            int max = 3;
            Random rand = new Random();
            int index = rand.nextInt((max - min) + 1) + min;
            currentSuit = suits[index];
            
            System.out.println("Computer played: " + card);
            System.out.println("Computer picked: " + card.fSuit(currentSuit));
            // updates user on computer's play and the suit picked (formatted)
            return card;
            
        } 
        else if(card.getRank()==faceup.getRank()||card.getSuit()==currentSuit){
        // otherwise check rank and suit to make sure either/both match
            System.out.println("You played: " + faceup);
            currentSuit = card.getSuit();   
            System.out.println("Computer played: " + card);
            return card;
            //updates plays and suit
        } else {
        // otherwise computer has no playable cards and needs to draw
            return null;
            
        }
    }

    private boolean gameOver(){
    // method that terminates the game and asks if user wants to play again
        System.out.println("GAME OVER!");
        if (p1.getHand().size() < compHand.size()){
        // compare hand size, the one with less wins in all instances
            System.out.println("You won! YAY!! card master");
            System.out.println("You have " + p1.getHand().size() + " left");
            System.out.println("Computer has " + compHand.size() + " left"); 
        } else{
            System.out.println("The computer won! You lost! LOSER");
            System.out.println("You have " + p1.getHand().size() + " left");
            System.out.println("Computer has " + compHand.size() + " left"); 
        }

        System.out.println("Do you want to play again? (y/n)");
        String again = input.nextLine();

        if (again.equals("y")){
            return true;
        } else{
            System.out.println("K BYEEEE!!");
            return false;
        }
        // if user wants to play again, play() method will run again
    }
}