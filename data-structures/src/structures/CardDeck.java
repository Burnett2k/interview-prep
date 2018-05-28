package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CardDeck {

	String[] vals = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	String[] suits = { "Diamond", "Spade", "Heart", "Club" };

	List<Card> cards = new ArrayList<Card>();
	

	public CardDeck() {
		for (String suit : suits) {
			for (String val : vals) {
				cards.add(new Card(suit, val));
			}
		}
	}

	public void listCards() {
		for (Card card : cards) {
			System.out.println(card.getVal() + " of " + card.getSuit());
		}
		
		System.out.println("number of cards = " + cards.size());
	}
	
	public void shuffleCards() {
		List<Card> shuffledDeck = new ArrayList<Card>();
		//loop through cards
		//choose a random one and add it to the deck and remove from initial list
		
		for (int i = 0; i < 52; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, cards.size());
			shuffledDeck.add(cards.remove(randomNum));
		}
		
		cards = shuffledDeck;
		shuffledDeck = null;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CardDeck cd = new CardDeck();
		cd.shuffleCards();
		cd.listCards();

	}

}

class Card {

	private String suit;
	private String val;

	Card(String suit, String val) {
		this.suit = suit;
		this.val = val;
	}

	public String getSuit() {
		return suit;
	}

	public String getVal() {
		return val;
	}

}
