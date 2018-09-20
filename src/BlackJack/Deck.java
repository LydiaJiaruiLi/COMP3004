/**
 * Created by Lydia on 2018/9/18.
 */

import java.util.Collections;
import java.util.Arrays;

public class Deck {
    Card cardSet[] = new Card[52];
    int position;


    public void createDeck(){

        String suites = "HSCD";
        String cards = "A23456789TJQK";
        int index = 0;

        for(int i = 0; i < suites.length(); i++){
            for(int j =0; j < cards.length(); j++){
                Card tempCard = new Card(cards.charAt(j), suites.charAt(i));
                cardSet[index] = tempCard;
                index++;
            }
        }
        shuffleCard();
    }

    public void shuffleCard(){

        Collections.shuffle(Arrays.asList(this.cardSet));
    }

    public Card getCard(){
        if (position == 51){
            return null;
        }
        Card temp = this.cardSet[position];
        position++;
        return temp;
    }
}


//test
