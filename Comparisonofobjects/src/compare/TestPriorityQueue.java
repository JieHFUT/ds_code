package compare;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-10
 * Time: 0:00
 */






class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public int compareTo(Card o) {
        return this.suit.compareTo(o.suit);
    }
}
public class TestPriorityQueue {
    public static void TestPriorityQueue()
    {
        PriorityQueue<Card> p = new PriorityQueue<>();
        p.offer(new Card(1, "♠"));
        p.offer(new Card(2, "♠"));
    }
    public static void main(String[] args) {
        TestPriorityQueue();
    }
}
