package workshop.pokerhands;

public enum HandType {
    HIGHCARD(1),PAIR(2),TWOPAIR(3), TOAK(4), STRAIGHT(5), FLUSH(6), FULLHOUSE(7), FOAK(8), STRAIGHTFLUSH(9);

    private final int value;
    HandType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

