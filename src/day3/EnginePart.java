package day3;

import java.util.ArrayList;
import java.util.List;

import utils.DataHandling;

public class EnginePart {
    private int startIndex;
    private int endIndex;
    private int rowIndex;
    private String value;
    private boolean isPartNumber;

    public EnginePart(String value, int rowIndex, String row) {
        this.value = value;
        this.rowIndex = rowIndex;
        startIndex = row.indexOf(value);
        endIndex = (row.indexOf(value) + value.length() - 1);
    }

    public static List<EnginePart> processEngineParts(List<String> data) {
        List<EnginePart> engineParts = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            String currentRow = data.get(rowIndex);
            List<String> numbersInRow = DataHandling.findIntegers(currentRow);
            for (String string : numbersInRow) {
                EnginePart enginePart = new EnginePart(string, rowIndex, currentRow);
                engineParts.add(enginePart);
                currentRow = currentRow.replaceFirst(string, DataHandling.fillUpWithChar(string.length(), '.'));
            }
        }
        return engineParts;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int row) {
        this.rowIndex = row;
    }

    public void setPartNumber(boolean isPartNumber) {
        this.isPartNumber = isPartNumber;
    }

    public boolean isPartNumber() {
        return isPartNumber;
    }

    @Override
    public String toString() {
        return "EnginePart [startIndex=" + startIndex + ", endIndex=" + endIndex + ", rowIndex=" + rowIndex + ", value="
                + value + "]";
    }

}
