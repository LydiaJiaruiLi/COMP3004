import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Lydia on 2018/9/17.
 */


public class blackjack {

    public static void main(String[] args) throws IOException {
        Deck newDeck = new Deck();
        newDeck.createDeck();

        Hand player = new Hand();
        Hand dealer = new Hand();

        player.addCard(newDeck.getCard());
        player.addCard(newDeck.getCard());
        System.out.println("Player gets " + player.handToString() + ": hand value is " + player.handGetValue());

        dealer.addCard(newDeck.getCard());
        System.out.println("Dealer shows " + dealer.handToString() + ": hand value is " + dealer.handGetValue());
        Card hiddenCard = newDeck.getCard();
        //dealer.addCard(newDeck.getCard());


        while(player.handGetValue() < 21 ){
            boolean addCard = Hit();
            if (player.handGetValue() > 21 || player.handGetValue() == 21 || !addCard) {
                break;
            } else {
                player.addCard(newDeck.getCard());
                System.out.println("Player gets " + player.handToString() + ": hand value is " + player.handGetValue());


            }

        }

        while (dealer.handGetValue() <= 16 && player.handGetValue() < 21) {
            dealer.addCard(newDeck.getCard());
            System.out.println("Dealer shows " + dealer.handToString() + ": hand value is " + dealer.handGetValue());

        }

        int playerTotal = player.handGetValue();
        int dealerTotal = dealer.handGetValue() + hiddenCard.getValue();

        checkWinner(playerTotal, dealerTotal);
    }


    public static boolean Hit(){
        boolean isHit = false;
        System.out.println("S(Stand) or H(Hit)?");
        Scanner input = new Scanner(System.in);
        String answer = input.next();

            if (answer.indexOf("S") == 0 || answer.indexOf("s") == 0) {
                isHit = false;
            } else if (answer.indexOf("H") == 0 || answer.indexOf("h") == 0) {
                isHit = true;
            }

        return isHit;
    }

    public static void checkWinner(int playerValue, int dealerValue) {
        if (playerValue == 21) {
            System.out.println("Player got BlackJack.");
            System.out.println("Player wins!");
        } else if (playerValue > 21) {
            System.out.println("Player busts.");
            System.out.println("Dealer wins!");
        } else if (playerValue == dealerValue) {
            System.out.println("Player and Dealer have same score.");
            System.out.println("Dealer wins!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts.");
            System.out.println("Player wins!");
        }
    }


}
