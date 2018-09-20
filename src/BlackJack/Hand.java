/**
 * Created by Lydia on 2018/9/19.
 */
import java.util.ArrayList;
import java.util.List;


public class Hand {
    ArrayList<Card> arr = new ArrayList<Card>();

    public void addCard(Card c){
        arr.add(c);
    }

    public String handToString(){
        String hand = "";
        for (int i = 0; i < arr.size(); i++){
            //if(arr.get(i).getFace() == 'T') arr.get(i).setFace('10');
            hand += arr.get(i).cardToString() + " ";
        }

        return hand;
    }

    public int handGetValue(){
        int totalValue = 0;
        boolean ace = false;

        for (int i = 0;i < arr.size();i++ ){
            Card tempCard = arr.get(i);
            int cardValue = tempCard.getValue();

            if( cardValue > 10) cardValue = 10;
            if( cardValue == 1)  ace = true;

            totalValue += cardValue;

        }
            if (ace == true && totalValue + 10 <= 21) totalValue = totalValue + 10;

            return totalValue;
    }


}
