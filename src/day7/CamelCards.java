package day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import utils.ReadData;
import utils.interfaces.Day;

public class CamelCards implements Day {

    private static final String PATH_ONE = "adventOfCode2023\\src\\day7\\data\\data.csv";
    List<String> fileOne;
    List<String> fileTwo;

    public CamelCards() {
        init();
    }

    @Override
    public void init() {
        fileOne = ReadData.readFromCsv(PATH_ONE);
    }

    @Override
    public void execute() {
        List<Hand> hands = new ArrayList<>();
        for (String string : fileOne) {
            Hand hand = Hand.createHand(string);
            hand.defineType();
            hands.add(hand);
        }
        setRank(hands);
    }

    private void setRank(List<Hand> hands) {
        List<List<Hand>> listOfHands = new ArrayList<>();

        for (HandType type : HandType.values()) {
            List<Hand> filteredList = hands.stream()
                    .filter(e -> e.getType().equals(type)).collect(Collectors.toList());
            filteredList.sort(getComparator());
            listOfHands.add(filteredList);
        }
        int counter = 1;
        for (int i = 0; i < listOfHands.size(); i++) {
            List<Hand> handlist = listOfHands.get(i);
            for (int j = 0; j < handlist.size(); j++) {
                handlist.get(j).setRank(counter);
                counter++;
                handlist.get(j).setTotal(handlist.get(j).getBid() * handlist.get(j).getRank());
            }
        }
        long result = 0;
        for (List<Hand> list : listOfHands) {
            for (Hand list2 : list) {
                result += list2.getTotal();
            }
        }
        System.out.println("result= " + result);
    }

    private Comparator<Hand> getComparator() {
        return (obj1, obj2) -> {
            List<Integer> list1 = obj1.getCards();
            List<Integer> list2 = obj2.getCards();

            int minLength = Math.min(list1.size(), list2.size());

            for (int i = 0; i < minLength; i++) {
                int cmp = Integer.compare(list1.get(i), list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(list1.size(), list2.size());
        };
    }

    public static void main(String... args) {
        CamelCards camelCards = new CamelCards();

        camelCards.execute();
    }

}
