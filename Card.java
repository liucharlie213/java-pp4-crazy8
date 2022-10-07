/** Card.java
*   Author: Charlie Liu CRL2157
*   Date: 4/4/22
*   
*   Models a typical playing card
*
*/

class Card{
    
    private char suit; 
    private int rank; 
    //every object of Card class has two characteristics, suit and rank

    public Card(char suit, int rank){
    // constructor initializes a card instance
        this.suit = suit;
        this.rank = rank;
    }

    public char getSuit(){
    // Accessor method for suit
        return suit;
    }
    
    public int getRank(){
    // Accessor method for rank
        return rank;
    }

    public static String fSuit(char suit){
    // Method that formats the current suit when printed
        String strSuit = "";
        String desc = "";
        switch(suit){
            case 'h': strSuit = "Hearts"; break;
            case 's': strSuit = "Spades"; break;
            case 'c': strSuit = "Clubs"; break;
            case 'd': strSuit = "Diamonds"; break;
            default: strSuit = "Invalid Suit"; break;
        }
        desc += strSuit;
        return desc; 
    }

    public String toString(){ 
    // Method that formats each Card object to be printable as a String
        String descRank = "";
        String descSuit = "";
        
        switch(rank){
            case 1: descRank = "Ace"; break;
            case 11: descRank = "Jack"; break;
            case 12: descRank = "Queen"; break;
            case 13: descRank = "King"; break;
            default: descRank = String.valueOf(rank);
        }
        switch(suit){
            case 'h': descSuit = "Hearts"; break;
            case 's': descSuit = "Spades"; break;
            case 'c': descSuit = "Clubs"; break;
            case 'd': descSuit = "Diamonds"; break;
            default: descSuit = "Invalid Suit"; break;
        }
        // use switch statement to go case by case

        String desc = descRank + " of " + descSuit;
        return desc;
    }
}