package day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Hand {
    private List<Integer> cards = new ArrayList<>();
    private long bid;
    private long total;
    private int rank;
    private HandType type;

    public Hand(List<Integer> cards, long bid) {
        this.cards = cards;
        this.bid = bid;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void setCards(List<Integer> cards) {
        this.cards = cards;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int strength) {
        this.rank = strength;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public HandType getType() {
        return type;
    }

    public void setType(HandType type) {
        this.type = type;
    }

    public static Hand createHand(String string) {
        String cardsSplit = string.split(" ")[0];
        long bid = Long.parseLong(string.split(" ")[1]);
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < cardsSplit.length(); i++) {
            if (Character.isAlphabetic(cardsSplit.charAt(i))) {
                cards.add(parseToInt(cardsSplit.charAt(i)));
            } else {
                cards.add(Integer.parseInt("" + cardsSplit.charAt(i)));
            }
        }
        return new Hand(cards, bid);
    }

    public void defineType() {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer integer : cards) {
            if (map.containsKey(integer)) {
                for (Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getKey().equals(integer)) {
                        entry.setValue(entry.getValue() + 1);
                    }
                }
            } else {
                map.put(integer, 1);
            }
        }
        map = checkForJoker(map);
        if (checkForTwoPairs(map)) {
            this.type = HandType.TWOPAIR;
        } else if (map.containsValue(4) || map.containsValue(5)) {
            setHandType(map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue());
        } else if ((map.containsValue(3) && map.containsValue(2)) || map.containsValue(6)) {
            this.type = HandType.FULLHOUSE;
        } else if (map.containsValue(3)) {
            this.type = HandType.THREEOFAKIND;
        } else if (map.containsValue(2)) {
            this.type = HandType.ONEPAIR;
        } else {
            this.type = HandType.HIGHCARD;
        }

    }

    private void setHandType(int amount) {
        if (amount == 5) {
            this.type = HandType.FIVEOFAKIND;
        } else {
            this.type = HandType.FOUROFAKIND;
        }
    }

    private Map<Integer, Integer> checkForJoker(Map<Integer, Integer> cardMap) {

        int amountJoker = 0;
        if (cardMap.get(1) != null) {
            amountJoker = cardMap.get(1);
        }

        boolean containsTwoPair = checkForTwoPairs(cardMap);
        boolean setPair = true;

        if (amountJoker > 0 && amountJoker != 5) {
            if (amountJoker == 4) {
                cardMap.put(1, 5);
            } else if (amountJoker == 3 && cardMap.containsValue(2)) {
                setInMap(cardMap, 2, 5);
            } else if (amountJoker == 3) {
                cardMap.put(1, 4);
            } else if (amountJoker == 2 && cardMap.containsValue(3)) {
                setInMap(cardMap, 3, 5);
            } else if (amountJoker == 2) {
                cardMap.put(1, 1);
                if (cardMap.containsValue(2)) {
                    setInMap(cardMap, 2, 4);
                } else {
                    setInMap(cardMap, 2, 3);
                }
                cardMap.put(1, 3);
            } else if (amountJoker == 1 && cardMap.containsValue(4)) {
                cardMap.put(1, 5);
            } else if (amountJoker == 1 && cardMap.containsValue(3)) {
                cardMap.put(1, 4);
            } else if (amountJoker == 1 && containsTwoPair) {
                setInMap(cardMap, 2, 3);
            } else if (amountJoker == 1 && cardMap.containsValue(2)) {
                setInMap(cardMap, 2, 3);
            } else if (amountJoker == 1) {
                cardMap.put(1, 2);
            }
        }
        return cardMap;

    }

    private boolean checkForTwoPairs(Map<Integer, Integer> map) {
        int counter = 0;

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(2)) {
                counter++;
            }
        }
        return (counter == 2);
    }

    private static int parseToInt(char c) {
        int r = 0;
        if (c == 'A') {
            r = 14;
        } else if (c == 'K') {
            r = 13;
        } else if (c == 'Q') {
            r = 12;
        } else if (c == 'J') {
            r = 1;
        } else if (c == 'T') {
            r = 10;
        }
        return r;
    }

    private Map<Integer, Integer> setInMap(Map<Integer, Integer> map, int searchValue, int newValue) {
        for (Entry entry : map.entrySet()) {
            if (entry.getValue().equals(searchValue)) {
                entry.setValue(newValue);
                break;
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return "[ cards= " + cards + ", bid= " + bid + ", rank= " + rank + ", type= " + type + "total= "
                + total
                + "]";
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

}
