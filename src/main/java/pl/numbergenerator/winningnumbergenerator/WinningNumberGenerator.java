package pl.numbergenerator.winningnumbergenerator;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
class WinningNumberGenerator {
    private final Random random = new Random();

    public WinningNumberGenerator() {
    }

    Set<Integer> drawUniqueNumbers(int numberOfNumbers, int maxNumber) {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < numberOfNumbers) {
            generatedNumbers.add(drawNumber(maxNumber));
        }
        return generatedNumbers;
    }

    private int drawNumber(int maxNumber) {
        return random.nextInt(maxNumber) + 1;
    }
}
