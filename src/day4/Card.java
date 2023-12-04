package day4;

import java.util.ArrayList;
import java.util.List;

import utils.DataHandling;

public class Card {
    private List<String> cardNumbers = new ArrayList<>();
    private List<String> winNumbers = new ArrayList<>();
    private int sumOfWinnumbers;
    private int instances = 1;
    private int amountMatchingNumbers;

    public List<String> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(List<String> cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    public int getSumOfWinnumbers() {
        return sumOfWinnumbers;
    }

    public void setSumOfWinnumbers(int sumOfWinnumbers) {
        this.sumOfWinnumbers = sumOfWinnumbers;
    }

    public List<String> getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers(List<String> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    public int getAmountMatchingNumbers() {
        return amountMatchingNumbers;
    }

    public void setAmountMatchingNumbers(int amountMatchingNumbers) {
        this.amountMatchingNumbers = amountMatchingNumbers;
    }

    public static List<Card> createCards(List<String> data) {

        List<Card> cards = new ArrayList<>();
        for (String string : data) {
            string = string.split(":")[1];
            String[] splitted = string.split("\\|");
            Card card = new Card();
            card.setWinNumbers(DataHandling.findIntegers(splitted[0]));
            card.setCardNumbers(DataHandling.findIntegers(splitted[1]));
            calculateWinNumbers(card);
            cards.add(card);
        }
        return cards;
    }

    private static void calculateWinNumbers(Card card) {
        int multiplier = 2;
        int total = 0;
        for (String winNumber : card.getWinNumbers()) {

            for (String cardNumber : card.getCardNumbers()) {
                if (cardNumber.equals(winNumber)) {
                    card.setAmountMatchingNumbers(card.getAmountMatchingNumbers() + 1);
                    if (total == 0) {
                        total = 1;
                    } else {
                        total = total * multiplier;
                    }
                }
            }
        }
        card.setSumOfWinnumbers(total);
    }

    public static int calculateAmountOfCards(List<Card> cards) {
        // every Card
        for (int i = 0; i < cards.size(); i++) {
            // every Instance of the Card
            for (int j = 0; j < cards.get(i).getInstances(); j++) {
                int nextCard = i + 1;
                for (int k = 0; k < cards.get(i).getAmountMatchingNumbers(); k++) {
                    cards.get(nextCard + k).setInstances(cards.get(nextCard + k).getInstances() + 1);
                }
            }
        }
        int totalInstances = 0;
        for (Card card : cards) {
            totalInstances += card.getInstances();
        }
        return totalInstances;
    }

    @Override
    public String toString() {
        return "Card [" + "sumOfWinnumbers= " + sumOfWinnumbers + "amountOfMatchingNumbers= " + amountMatchingNumbers
                + "instances= " + instances + "]";
    }

}
