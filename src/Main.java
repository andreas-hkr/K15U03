import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Skriv en extern jämförare som jämför objekt av klassen Card
        //  - Endast valörerna spelar roll

        CardComp cc = new CardComp();

        Card c1 = new Card();
        c1.rank = 6;

        Card c2 = new Card();
        c2.rank = 6;

        System.out.println(cc.compare(c1, c2));
    }
}

class CardComp implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        if (c1.rank == c2.rank) {
            return 0;
        } else if (c2.rank == 1) {
            return -1;
        } else if (c1.rank == 1 || c1.rank > c2.rank) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Card {
    static final int CLUBS = 0;
    static final int DIAMONDS = 1;
    static final int HEARTS = 2;
    static final int SPADES = 3;
    static String[] suits = {"Klöver", "Ruter", "Hjärter", "Spader"};
    static String[] ranks = {
            "ess", "två", "tre", "fyra", "fem", "sex", "sju",
            "åtta", "nio", "tio", "knekt", "dam", "kung"
    };

    int suit;
    int rank;

    public int compareTo(Card c) {
        if ( suit < c.suit) {
            return -1;
        } else if (suit > c.suit) {
            return 1;
        } else {
            if (rank == c.rank) {
                return 0;
            } else if (c.rank == 1) {
                return -1;
            } else if (rank == 1 || rank > c.rank) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return suits[suit] + " " + ranks[rank-1];
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Card c) {
            return suit == c.suit && rank == c.rank;
        }
        return false;
    }

    void change(int suit, int rank) {
        if ((suit >= 0 && suit <= 3) && (rank >= 0 && rank <= 13)) {
            this.suit = suit;
            this.rank = rank;
        } else {
            throw new IllegalArgumentException("Felaktigt kort");
        }
    }
}