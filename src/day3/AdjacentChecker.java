package day3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AdjacentChecker {

    public int startCheck(List<String> data, List<String> dataTwo) {
        List<EnginePart> engineParts = EnginePart.processEngineParts(data);
        List<EngineSymbol> engineSymbols = EngineSymbol.processEngineSymbols(data);

        List<EnginePart> enginePartsTwo = EnginePart.processEngineParts(dataTwo);
        List<EngineSymbol> engineSymbolsTwo = EngineSymbol.processEngineSymbols(dataTwo);

        checkIsPartNumber(engineParts, engineSymbols);

        checkIsPartNumberTwo(enginePartsTwo, engineSymbolsTwo);

        return 0;
    }

    private void checkIsPartNumber(List<EnginePart> engineParts, List<EngineSymbol> engineSymbols) {
        int sum = 0;
        for (EnginePart enginePart : engineParts) {
            List<EngineSymbol> filteredSymbols = engineSymbols.stream()
                    .filter(e -> e.getRowIndex() == (enginePart.getRowIndex() - 1)
                            || e.getRowIndex() == enginePart.getRowIndex()
                            || e.getRowIndex() == (enginePart.getRowIndex() + 1))
                    .toList();
            int start = enginePart.getStartIndex() - 1;
            int end = enginePart.getEndIndex() + 1;
            for (EngineSymbol filteredSymbol : filteredSymbols) {
                if ((filteredSymbol.getStartIndex()) >= start && (filteredSymbol.getStartIndex()) <= end) {
                    sum += Integer.parseInt(enginePart.getValue());
                    enginePart.setPartNumber(true);
                    break;
                }
            }
        }
        System.out.println("Sum = " + sum);

    }

    private void checkIsPartNumberTwo(List<EnginePart> engineParts, List<EngineSymbol> engineSymbols) {
        List<EngineSymbol> filteredSymbolList = engineSymbols.stream().filter(e -> e.getValue().equals("*")).toList();
        int sum = 1;
        BigInteger bigInteger = new BigInteger("0");
        for (EngineSymbol engineSymbol : filteredSymbolList) {
            List<EnginePart> filteredEngineParts = engineParts.stream()
                    .filter(e -> e.getRowIndex() == (engineSymbol.getRowIndex() - 1)
                            || e.getRowIndex() == engineSymbol.getRowIndex()
                            || e.getRowIndex() == (engineSymbol.getRowIndex() + 1))
                    .toList();


            int start = engineSymbol.getStartIndex() - 1;
            int end = engineSymbol.getStartIndex() + 1;
            List<EnginePart> adjacentParts = new ArrayList<>();

            for (EnginePart filteredEnginePart : filteredEngineParts) {
                if ((filteredEnginePart.getStartIndex()) >= start && (filteredEnginePart.getStartIndex()) <= end) {
                    adjacentParts.add(filteredEnginePart);
                } else if (filteredEnginePart.getEndIndex() >= start && (filteredEnginePart.getEndIndex()) <= end) {
                    adjacentParts.add(filteredEnginePart);
                }
            }
            sum = 1;
            if (adjacentParts.size() == 2) {
                for (int i = 0; i < adjacentParts.size(); i++) {
                    sum *= Integer.parseInt(adjacentParts.get(i).getValue());
                }
                bigInteger = bigInteger.add(BigInteger.valueOf(sum));
            }
        }
        System.out.println("Sum2 = " + bigInteger.intValue());
    }
}
