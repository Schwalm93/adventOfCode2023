package utils;

import java.util.List;

public class LCMCalculator {
    
    // Methode zur Berechnung des LCM
    public static Long findLCM(List<Long> numbers) {
        Long result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            result = lcm(result, numbers.get(i));
        }
        return result;
    }

    // Hilfsmethode zur Berechnung des LCM von zwei Zahlen
    private static Long lcm(Long a, Long b) {
        return a * (b / gcd(a, b));
    }

    // Methode zur Berechnung des GCD (größten gemeinsamen Teilers)
    private static Long gcd(Long a, Long b) {
        while (b != 0) {
            Long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}

