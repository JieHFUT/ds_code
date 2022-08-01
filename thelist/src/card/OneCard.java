package card;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-01
 * Time: 0:24
 */




//抽象出来一张牌
public class OneCard {
    private String suit;//扑克牌花色
    private int rank;//扑克牌大小

    public OneCard(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "{" +
                 suit +
                 rank +
                '}';

    }


}







