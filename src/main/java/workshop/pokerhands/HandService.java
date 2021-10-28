package workshop.pokerhands;

import org.springframework.stereotype.Service;

@Service
public class HandService {

    public String checkWinner(Hand[] hands) {
        if (hands[0].bestHand().getValue() > hands[1].bestHand().getValue()) {
            return hands[0].getName();
        } else if (hands[0].bestHand().getValue() < hands[1].bestHand().getValue()) {
            return hands[1].getName();
        }
        return getHighCard(hands);
    }

    private String compareHandsOfSameRankAndBreakTie(Hand[] hands) {
        switch (hands[0].bestHand()) {
            case FOAK:
                return getHighestFOAK(hands);
            case FULLHOUSE:
                return getHighestFullHouse(hands);
            case TOAK:
                return getHighestTOAK(hands);
            case TWOPAIR:
               return getHighestTwoPair(hands);
            case PAIR:
                return getHighestPair(hands);
            //DEFAULT INCLUDES: STRAIGHTFLUSH, FLUSH, STRAIGHT
            default:
                return getHighCard(hands);
        }
    }

    private String getHighestFOAK(Hand[] hands) {
        if (hands[0].getFOAK() > hands[1].getFOAK()) {
            return hands[0].getName();
        } else {
            return hands[1].getName();
        }
    }

    private String getHighestFullHouse(Hand[] hands) {
        if (hands[0].getFullHouse() > hands[1].getFullHouse()) {
            return hands[0].getName();
        } else if (hands[0].getFullHouse() < hands[1].getFullHouse()) {
            return hands[1].getName();
        } else {

            if (hands[0].getCards()[3].getNumber() > hands[1].getCards()[3].getNumber()) {
                return hands[0].getName();
            } else {
                return hands[1].getName();
            }
        }
    }

    private String getHighestTOAK(Hand[] hands) {
        if (hands[0].getTOAK() > hands[1].getTOAK()) {
            return hands[0].getName();
        } else if(hands[0].getTOAK() < hands[1].getTOAK())
        {
            return hands[1].getName();
        }
        return "DRAW";
    }

    private String getHighestTwoPair(Hand[] hands) {
        return "Draw";
    }

    private String getHighestPair(Hand[] hands) {
        if (hands[0].getPair() > hands[1].getPair()) {
            return hands[0].getName();
        } else if (hands[0].getPair() < hands[1].getPair()) {
            return hands[1].getName();
        } else {
            for (int i = 0; i < hands[0].getCards().length; i++) {
                if (hands[0].getCards()[i].getNumber() > hands[1].getCards()[i].getNumber()) {
                    return hands[0].getName();
                } else if (hands[0].getCards()[i].getNumber() < hands[1].getCards()[i].getNumber()) {
                    return hands[1].getName();
                }
            }
        }
        return "Draw";
    }


    private String getHighCard(Hand[] hands) {
        if (hands[0].getHighestCard() > hands[1].getHighestCard()) {
            return hands[0].getName();
        } else if (hands[0].getHighestCard() < hands[1].getHighestCard()) {
            return hands[1].getName();
        }
        return "Draw";
    }

/*
    private String checkTOAKBeatsTwoPair(Hand[] hands) {
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].getTOAK() != -1) {
                return hands[i].getName();
            }
        }
        return "Draw";
    }
    private String checkTwoPairBeatsPair(Hand[] hands) {
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].getTwoPair() != -1) {
                return hands[i].getName();
            }
        }
        return "Draw";
    }

    private String checkPairBeatsHighCard(Hand[] hands) {
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].getPair() != -1) {
                return hands[i].getName();
            }
        }
        return "Draw";
    }
*/

}
