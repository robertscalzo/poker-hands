package workshop.pokerhands;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class HandServiceTest {
    @Autowired
    HandService handService;

    @Test
    public void checkWinnerTestHighCard() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(5, Suit.SPADE);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(3, Suit.DIAMOND);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(7, Suit.SPADE);
        Card card7 = new Card(5, Suit.SPADE);
        Card card8 = new Card(4, Suit.DIAMOND);
        Card card9 = new Card(3, Suit.DIAMOND);
        Card card10 = new Card(2, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");

    }

    @Test
    public void checkWinnerTestPairBeatsHighCard() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.SPADE);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(3, Suit.DIAMOND);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(5, Suit.SPADE);
        Card card8 = new Card(4, Suit.DIAMOND);
        Card card9 = new Card(3, Suit.DIAMOND);
        Card card10 = new Card(2, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");

    }

    @Test
    public void checkWinnerTestTwoPairBeatsPair() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.SPADE);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.DIAMOND);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(10, Suit.SPADE);
        Card card8 = new Card(4, Suit.DIAMOND);
        Card card9 = new Card(3, Suit.DIAMOND);
        Card card10 = new Card(2, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");

    }

    @Test
    public void checkWinnerTestTOAKBeatsTwoPair() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.SPADE);
        Card card3 = new Card(8, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.DIAMOND);
        Card card5 = new Card(2, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(10, Suit.SPADE);
        Card card8 = new Card(4, Suit.DIAMOND);
        Card card9 = new Card(4, Suit.DIAMOND);
        Card card10 = new Card(2, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");

    }

    @Test
    public void checkWinnerTestStraightBeatsTOAK() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(7, Suit.SPADE);
        Card card3 = new Card(6, Suit.DIAMOND);
        Card card4 = new Card(5, Suit.DIAMOND);
        Card card5 = new Card(4, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(10, Suit.SPADE);
        Card card8 = new Card(10, Suit.DIAMOND);
        Card card9 = new Card(5, Suit.DIAMOND);
        Card card10 = new Card(4, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");

    }
    @Test
    public void checkWinnerTestFlushBeatsStraight() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(7, Suit.SPADE);
        Card card3 = new Card(6, Suit.DIAMOND);
        Card card4 = new Card(5, Suit.DIAMOND);
        Card card5 = new Card(4, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(3, Suit.SPADE);
        Card card8 = new Card(4, Suit.SPADE);
        Card card9 = new Card(5, Suit.SPADE);
        Card card10 = new Card(7, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P2");

    }
    @Test
    public void checkWinnerTestFullHouseBeatsFlush() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.SPADE);
        Card card3 = new Card(8, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.DIAMOND);
        Card card5 = new Card(4, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(3, Suit.SPADE);
        Card card8 = new Card(4, Suit.SPADE);
        Card card9 = new Card(5, Suit.SPADE);
        Card card10 = new Card(7, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");
    }
    @Test
    public void checkWinnerTestFOAKBeatsFullHouse() {
        Card card1 = new Card(8, Suit.SPADE);
        Card card2 = new Card(8, Suit.SPADE);
        Card card3 = new Card(8, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.DIAMOND);
        Card card5 = new Card(4, Suit.SPADE);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(10, Suit.SPADE);
        Card card8 = new Card(10, Suit.SPADE);
        Card card9 = new Card(10, Suit.SPADE);
        Card card10 = new Card(7, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P2");
    }
    @Test
    public void checkWinnerTestStraightFlushBeatsFOAK() {
        Card card1 = new Card(8, Suit.HEART);
        Card card2 = new Card(7, Suit.HEART);
        Card card3 = new Card(6, Suit.HEART);
        Card card4 = new Card(5, Suit.HEART);
        Card card5 = new Card(4, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.SPADE);
        Card card7 = new Card(10, Suit.SPADE);
        Card card8 = new Card(10, Suit.SPADE);
        Card card9 = new Card(10, Suit.SPADE);
        Card card10 = new Card(7, Suit.SPADE);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");
    }
/*

    @Test
    public void compareSameStraightFlush() {
        Card card1 = new Card(8, Suit.HEART);
        Card card2 = new Card(7, Suit.HEART);
        Card card3 = new Card(6, Suit.HEART);
        Card card4 = new Card(5, Suit.HEART);
        Card card5 = new Card(4, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(7, Suit.HEART);
        Card card7 = new Card(6, Suit.HEART);
        Card card8 = new Card(5, Suit.HEART);
        Card card9 = new Card(4, Suit.HEART);
        Card card10 = new Card(3, Suit.HEART);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");
    }
    @Test
    public void compareSameFOAK() {
        Card card1 = new Card(4, Suit.HEART);
        Card card2 = new Card(4, Suit.HEART);
        Card card3 = new Card(4, Suit.DIAMOND);
        Card card4 = new Card(4, Suit.HEART);
        Card card5 = new Card(2, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(7, Suit.HEART);
        Card card7 = new Card(7, Suit.HEART);
        Card card8 = new Card(7, Suit.SPADE);
        Card card9 = new Card(7, Suit.HEART);
        Card card10 = new Card(3, Suit.HEART);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P2");
    }
    @Test
    public void compareSameFullHouseHighTOAK() {
        Card card1 = new Card(4, Suit.HEART);
        Card card2 = new Card(4, Suit.HEART);
        Card card3 = new Card(4, Suit.CLUB);
        Card card4 = new Card(2, Suit.HEART);
        Card card5 = new Card(2, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(7, Suit.HEART);
        Card card7 = new Card(7, Suit.DIAMOND);
        Card card8 = new Card(7, Suit.HEART);
        Card card9 = new Card(3, Suit.HEART);
        Card card10 = new Card(3, Suit.HEART);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P2");
    }
        @Test
        public void compareSameFullHouseSameTOAK() {
        Card card1 = new Card(10, Suit.HEART);
        Card card2 = new Card(10, Suit.CLUB);
        Card card3 = new Card(10, Suit.HEART);
        Card card4 = new Card(2, Suit.HEART);
        Card card5 = new Card(2, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.HEART);
        Card card7 = new Card(10, Suit.CLUB);
        Card card8 = new Card(10, Suit.HEART);
        Card card9 = new Card(3, Suit.HEART);
        Card card10 = new Card(3, Suit.HEART);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P2");
    }
    @Test
        public void compareSameFlush() {
        Card card1 = new Card(10, Suit.HEART);
        Card card2 = new Card(9, Suit.HEART);
        Card card3 = new Card(8, Suit.HEART);
        Card card4 = new Card(7, Suit.HEART);
        Card card5 = new Card(5, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(9, Suit.HEART);
        Card card7 = new Card(8, Suit.HEART);
        Card card8 = new Card(7, Suit.HEART);
        Card card9 = new Card(6, Suit.HEART);
        Card card10 = new Card(3, Suit.HEART);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");
    }
    @Test
        public void compareSameStraight() {
        Card card1 = new Card(10, Suit.HEART);
        Card card2 = new Card(9, Suit.HEART);
        Card card3 = new Card(8, Suit.DIAMOND);
        Card card4 = new Card(7, Suit.HEART);
        Card card5 = new Card(6, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(9, Suit.HEART);
        Card card7 = new Card(8, Suit.HEART);
        Card card8 = new Card(7, Suit.DIAMOND);
        Card card9 = new Card(6, Suit.HEART);
        Card card10 = new Card(5, Suit.HEART);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");
    }
    @Test
        public void compareSameTOAK() {
        Card card1 = new Card(10, Suit.HEART);
        Card card2 = new Card(10, Suit.HEART);
        Card card3 = new Card(10, Suit.DIAMOND);
        Card card4 = new Card(7, Suit.HEART);
        Card card5 = new Card(5, Suit.HEART);
        Card[] cards1 = {card1, card2, card3, card4, card5};
        Card card6 = new Card(10, Suit.HEART);
        Card card7 = new Card(10, Suit.HEART);
        Card card8 = new Card(10, Suit.DIAMOND);
        Card card9 = new Card(6, Suit.HEART);
        Card card10 = new Card(5, Suit.HEART);
        Card[] cards2 = {card6, card7, card8, card9, card10};

        Hand hand1 = new Hand("P1", cards1);
        Hand hand2 = new Hand("P2", cards2);
        Hand hands[] = {hand1, hand2};

        assertThat(handService.checkWinner(hands)).isEqualTo("P1");
    }
*/

}