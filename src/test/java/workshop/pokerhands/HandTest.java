package workshop.pokerhands;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {

    @Test
    public void handConstructorTest() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(5, Suit.SPADE);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(3, Suit.DIAMOND);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);

        assertThat(true).isEqualTo(true);
        assertThat(handTest.getName()).isEqualTo("P1");
        assertThat(handTest.getCards()).isEqualTo(cards);

    }
    @Test
    public void handBestHandTest() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.SPADE);
        Card card3 = new Card(8, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.DIAMOND);
        Card card5 = new Card(4, Suit.SPADE);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);

        assertThat(handTest.bestHand()).isEqualTo(HandType.FULLHOUSE);

    }

    @Test
    public void handGetHighestCardTest() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(5, Suit.SPADE);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(3, Suit.DIAMOND);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);

        assertThat(handTest.getHighestCard()).isEqualTo(card1.getNumber());
    }

    @Test
    public void handGetHighestPairTest() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.DIAMOND);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.SPADE);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getPair()).isEqualTo(card1.getNumber());
    }
    @Test
    public void handGetTwoPair() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.DIAMOND);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.SPADE);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getTwoPair()).isEqualTo(card1.getNumber());
    }
    @Test
    public void handGetTOAK() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.DIAMOND);
        Card card3 = new Card(8, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.SPADE);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getTOAK()).isEqualTo(card1.getNumber());
    }
    @Test
    public void handGetStraight() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(7, Suit.DIAMOND);
        Card card3 = new Card(6, Suit.DIAMOND);
        Card card4 = new Card(5, Suit.SPADE);
        Card card5 = new Card(4, Suit.SPADE);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getStraight()).isEqualTo(card1.getNumber());
    }
    @Test
    public void handGetFlush() {
        Card card1 = new Card(10, Suit.CLUB);
        Card card2 = new Card(7, Suit.CLUB);
        Card card3 = new Card(6, Suit.CLUB);
        Card card4 = new Card(5, Suit.CLUB);
        Card card5 = new Card(4, Suit.CLUB);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getFlush()).isEqualTo(card1.getNumber());
    }
    @Test
    public void handGetFullHouse() {
        Card card1 = new Card(10, Suit.CLUB);
        Card card2 = new Card(10, Suit.CLUB);
        Card card3 = new Card(10, Suit.DIAMOND);
        Card card4 = new Card(8, Suit.CLUB);
        Card card5 = new Card(8, Suit.CLUB);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getFullHouse()).isEqualTo(card1.getNumber());
    }
    @Test
    public void handGetFOAK() {
        Card card1 = new Card(10, Suit.CLUB);
        Card card2 = new Card(10, Suit.CLUB);
        Card card3 = new Card(10, Suit.DIAMOND);
        Card card4 = new Card(10, Suit.CLUB);
        Card card5 = new Card(8, Suit.CLUB);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getFOAK()).isEqualTo(card1.getNumber());
    }
    @Test
    public void handGetStraightFlush() {
        Card card1 = new Card(10, Suit.CLUB);
        Card card2 = new Card(9, Suit.CLUB);
        Card card3 = new Card(8, Suit.CLUB);
        Card card4 = new Card(7, Suit.CLUB);
        Card card5 = new Card(6, Suit.CLUB);
        Card[] cards = {card1, card2, card3, card4, card5};

        Hand handTest = new Hand("P1", cards);
        assertThat(handTest.getStraightFlush()).isEqualTo(card1.getNumber());
    }
}