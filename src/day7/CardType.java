package day7;

public enum CardType {
    A("1"), K("K"), Q("Q"), J("J"), T("T"),
    NINE("9"), EIGHT("8"), SEVEN("7"), SIX("6"),
    FIVE("5"), FOUR("4"), THREE("3"), TWO("2");

    private final String value;

    CardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CardType stringToCardType(String string) {
        for (CardType cardType : CardType.values()) {
            if (cardType.value.equals(string)) {
                return cardType;
            }
        }
        throw new IllegalArgumentException("Invalid CardType: " + string);
    }
}

