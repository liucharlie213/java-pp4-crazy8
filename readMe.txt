Name: Charlie Liu 
Uni: CRL2157
I talked about this project with peer William Groger

For this project I started with the Card and Deck class. 

a) Card class
I first declared and instantiated all the instance variables of a card, then
I created two formatting methods, fSuit() and toString(). The fSuit() method
takes in the char currentSuit object and formats it into a readable String
which is reported to the user as te game proceeds. The toString method formats
each card object to make it readable as Rank of Suit, which is conventional 
formatting for cards

b) Deck class
I first declared and instantiated all the instance variables of a deck object,
then I constructed a deck and filled it with the conventional 52 cards. Next 
I worked on the deal() method which deals the top card off the deck, then I 
worked on the canDeal() method which checks if the deck has any cards left to
deal. Next I worked on the shuffle() method which shuffles the deck by 
switching the position of two random cards 1 million times. Finally I worked 
on a toString()method which formats the deck into a String that displays every
single card in teh deck. This toString() method automatically calls on the 
toString() method I wrote in the Card class in order to format the Card objects
in the deck.

Next I moved to the Player class and the Game class

a) Player class

For the player class I started by creating the hand of cards for the player.
Next I worked on the addCard() method which takes in a card object and adds it to
the player's hand. Next I worked on the getHand() which is an accessor method 
that returns the players hand. Next I worked on the handToString() method which 
returns a printable String representing the player's hand. This method will 
automatically call the toString methods made in the Card class when working on 
a card object. Then, I went back and worked on the playsTurn() method which 
effectively plays one turn of the players turn. All of this method is put in a
while(true) loop so that the player can keep playing until the game ends.
This method prints the players hand after every turn, the current face up card, 
and the current suit. It allows the player to draw or play a card for their turn 
using a makeChoice() helper method that just takes in a input via Scanner.
If the player chooses to draw, the deck is checked to make sure it still has cards,
otherwise, the player's play is checked for validity using helper method 
checkPlay(). The checkPlay() method checks the player's play, making sure
it is both a card that the player has, and that it is either an 8 or it matches
the current suit or the rank of the faceup card. If the player is cheating,
I ask them to play a valid card and they get to play again due to the while loop.
When the player plays a valid card, it is removed from theur hand and the faceup 
and current suit are updated. 

b) Game class

In the Game class I first declare and instantiate the instance values. I make sure to
shuffle the deck before filling the players hand and the computers hand. Next I worked
on the play() method that lets the players play, then checks if the deck is empty
in which case the game ends. It also checks if p1 has played all its cards, in which case 
the game ends. Same with the computer hand, checks if it has used all its cards. In each 
case the gameOver() helper method is called which prints who is the winner and asks 
the user if they want to play again. If they do, the game restarts, if not it terminates.
In the computerTurn() method I check every card in the computers hand using the compCard()
helper method and then play the first card that is playable. The compCard() method checks 
each card if it is an 8 (in which case I let the computer randomly select a suit to
change to) or if the card matches the rank of the faceup or suit of current suit. If the 
computer has no playable cards, I have it draw and check each drawn card as it draws 
until it draws a playable card, in which case it will play it.

Design/Naming choices
For my variable and helper method names, I tried to make them as accurate and descriptive
to what they do as possible. For example my fSuit() method stands for format suit as it
formats the char parameter as a readable string. Another example is my compCard() helper 
method which checks each card in the computer's hand to determine which card the computer
should play. I made helper methods to abstract away repetitive chunks of code and to help 
save space in longer methods.
