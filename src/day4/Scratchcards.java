package day4;

import java.math.BigInteger;
import java.util.List;

import utils.ReadData;
import utils.interfaces.Day;

public class Scratchcards implements Day {

    private static final String PATH_ONE = "adventOfCode2023\\src\\day4\\data\\data.csv";
    //private static final String PATH_TWO = "src/day4/data/data2.csv";
    List<String> fileOne;
    List<String> fileTwo;

    @Override
    public void init() {
        fileOne = ReadData.readFromCsv(PATH_ONE);
        //fileTwo = ReadData.readFromCsv(PATH_TWO);
    }

    public static void main(String... args) {
        Scratchcards scratchcards = new Scratchcards();
        scratchcards.init();
        scratchcards.execute();
    }

    @Override
    public void execute() {
        List<Card> cards = Card.createCards(fileOne);
        int totalFromCard = 0;
        for (Card card : cards) {
            totalFromCard += card.getSumOfWinnumbers();
        }
        int totalInstances = Card.calculateAmountOfCards(cards);
        System.out.println("total = " + totalFromCard);
        System.out.println("total instances = " + totalInstances);
    }
}
