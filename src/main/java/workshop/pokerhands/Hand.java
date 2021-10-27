package workshop.pokerhands;

class Hand {

    private String name;
    private Card[] cards;

    public Hand(String name, Card[] cards) {
        this.name = name;
        this.cards = cards;
    }

    public Hand() {
    }

    public HandType bestHand() {
        if (this.getStraightFlush() != -1) {
            return HandType.STRAIGHTFLUSH;
        }
        if (this.getFOAK() != -1) {
            return HandType.FOAK;
        }
        if (this.getFullHouse() != -1) {
            return HandType.FULLHOUSE;
        }
        if (this.getFlush() != -1) {
            return HandType.FLUSH;
        }
        if (this.getStraight() != -1) {
            return HandType.STRAIGHT;
        }
        if (this.getTOAK() != -1) {
            return HandType.TOAK;
        }
        if (this.getTwoPair() != -1) {
            return HandType.TWOPAIR;
        }
        if (this.getPair() != -1) {
            return HandType.PAIR;
        }
        return HandType.HIGHCARD;
    }

    public int getStraightFlush() {
        if (getFlush() != -1 && getStraight() != -1) {
            return cards[0].getNumber();
        }
        return -1;
    }

    public int getFOAK() {
        for (int i = 0; i < 2; i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber() && cards[i].getNumber() == cards[i + 2].getNumber() && cards[i].getNumber() == cards[i + 3].getNumber()) {
                return cards[i].getNumber();
            }
        }

        return -1;
    }

    public int getFullHouse() {
        if (getTOAK() != -1) {
            if (cards[3].getNumber() == cards[4].getNumber()) {
                return cards[0].getNumber();
            }
        }
        return -1;
    }

    public int getFlush() {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getSuit() != cards[i + 1].getSuit()) {
                return -1;
            }
        }
        return cards[0].getNumber();
    }

    public int getStraight() {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getNumber() - 1 != cards[i + 1].getNumber()) {
                return -1;
            }
        }
        return cards[0].getNumber();
    }

    public int getTOAK() {
        for (int i = 0; i < cards.length - 2; i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber() && cards[i].getNumber() == cards[i + 2].getNumber()) {
                return cards[i].getNumber();
            }
        }
        return -1;
    }

    public int getTwoPair() {
        int firstPair = 0;
        int secondPair = 0;
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber()) {
                if (firstPair == 0) {
                    firstPair = cards[i].getNumber();
                } else {
                    secondPair = cards[i].getNumber();
                }
            }
        }
        if (firstPair != 0 && secondPair != 0 && firstPair != secondPair) {
            return firstPair;
        }

        return -1;
    }

    public int getPair() {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber()) {
                return cards[i].getNumber();
            }
        }
        return -1;
    }

    public int getHighestCard() {
        return cards[0].getNumber();
    }

    public Card[] getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public void setName(String name) {
        this.name = name;
    }

}
