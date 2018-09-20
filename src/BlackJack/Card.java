/**
 * Created by Lydia on 2018/9/18.
 */
public class Card {
    //the number of cards
    //public String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    //the suits of cards, there are HEART, SPADE, CLUB and DIAMOND
    //public String[] suits = {"H", "S", "C", "D"};

    private char face;
    private char suite;
    private int value = 0;

    public Card(char f, char s){
        this.face = f;
        this.suite = s;
        this.value = getValue();
    }

    public char getFace(){
        return this.face;
    }

    public char getSuit(){
        return this.suite;
    }

    public void setFace(char f){
        this.face = f;
    }


    public int getValue(){
        if (this.face == 'T') return 10;
        if (this.face == 'J') return 11;
        if (this.face == 'Q') return 12;
        if (this.face == 'K') return 13;
        if (this.face == 'A') return 1;
        else return Integer.parseInt(this.face+"");

    }

    public String cardToString(){
        return this.face + "" + this.suite;
    }
}
