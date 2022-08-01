package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-01
 * Time: 0:30
 */


public class Card {

    public static final String[] suits = {"♠","♥","♣","♦"};

    public static List<OneCard> buyCard(){
        List<OneCard> cardList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = suits[i];
                int rank = j;
                OneCard oneCard = new OneCard(suit,rank);
                cardList.add(oneCard);
            }
        }
        return cardList;
    }

    public static List<OneCard> shufft(List<OneCard> cardList){
        Random random = new Random();
        for (int i = cardList.size()-1; i >=1 ; i--) {
            int randNum = random.nextInt(i);
            OneCard oneCard = cardList.get(randNum);
            cardList.set(randNum,cardList.get(i));
            cardList.set(i,oneCard);
        }
        return cardList;
    }

    public static List<OneCard> licensing(List<List<OneCard>> people, List<OneCard> cardList,int k){
        for (int i = 0; i < 5; i++) {
            people.get(k).add(cardList.remove(2*i));
        }
        return people.get(k);
    }





    public static void main(String[] args) {

        List<OneCard> cardList = buyCard();
        System.out.println("洗牌前："+cardList);

        cardList = shufft(cardList);
        System.out.println("洗牌后："+cardList);

        List<OneCard> peopleOne = new ArrayList<>();
        List<OneCard> peopleTwo = new ArrayList<>();
        List<OneCard> peopleThree = new ArrayList<>();


        List<List<OneCard>> people = new ArrayList<>();
        people.add(peopleOne);
        people.add(peopleTwo);
        people.add(peopleThree);



        peopleOne = licensing(people,cardList,0);
        peopleTwo = licensing(people,cardList,1);
        peopleThree = licensing(people,cardList,2);


        System.out.println("第一个人的牌：" + peopleOne);
        System.out.println("第二个人的牌：" + peopleTwo);
        System.out.println("第三个人的牌：" + peopleThree);

        System.out.println("剩余的牌：" + cardList);

    }

}
