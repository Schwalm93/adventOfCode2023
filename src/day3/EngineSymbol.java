package day3;

import java.util.ArrayList;
import java.util.List;

import utils.DataHandling;

public class EngineSymbol extends EnginePart {

    public EngineSymbol(String value, int rowIndex, String row) {
        super(value, rowIndex, row);

    }

    public static List<EngineSymbol> processEngineSymbols(List<String> data) {
        List<EngineSymbol> engineSymbols = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            String currentRow = data.get(rowIndex);
            List<String> numbersInRow = DataHandling.findSpecialChars(currentRow);
            for (String string : numbersInRow) {
                EngineSymbol engineSymbol = new EngineSymbol(string, rowIndex, currentRow);
                engineSymbols.add(engineSymbol);
                if (string.contains("*") || string.contains("+") || string.contains("$")) {
                    string = "\\" + string;
                }
                currentRow = currentRow.replaceFirst(string, ".");
            }
        }
        return engineSymbols;
    }

    @Override
    public String toString() {
        return "Symbol [startIndex=" + getStartIndex() + ", rowIndex=" + getRowIndex() + ", value="
                + getValue() + "]";
    }

}
