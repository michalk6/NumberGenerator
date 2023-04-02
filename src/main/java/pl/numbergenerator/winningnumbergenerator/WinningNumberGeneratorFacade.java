package pl.numbergenerator.winningnumbergenerator;

import org.springframework.stereotype.Component;
import pl.numbergenerator.winningnumbergenerator.dto.WinningNumbersDto;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public class WinningNumberGeneratorFacade {
    private final WinningNumberGenerator winningNumberGenerator;
    private final WinningNumbersRepository repository;

    public WinningNumberGeneratorFacade(WinningNumberGenerator winningNumberGenerator, WinningNumbersRepository repository) {
        this.winningNumberGenerator = winningNumberGenerator;
        this.repository = repository;
    }

    public WinningNumbersDto drawUniqueNumbers(int numberOfNumbers, int maxNumber, LocalDateTime drawDate) {
        Set<Integer> winningNumbers = winningNumberGenerator.drawUniqueNumbers(numberOfNumbers, maxNumber);
        WinningNumbers saved = repository.save(WinningNumbers.builder()
                .numbers(winningNumbers)
                .drawDate(drawDate)
                .build());
        return WinningNumbersMapper.mapToDto(saved);
    }

    public WinningNumbersDto retrieveNumbersByDrawDate(LocalDateTime drawDate) {
        WinningNumbers winningNumbers = repository
                .findWinningNumbersByDrawDate(drawDate)
                .orElseThrow(() -> new NoSuchDrawException("Cannot find draw data by given draw date"));
        return WinningNumbersMapper.mapToDto(winningNumbers);
    }

    public boolean numbersAreAlreadyGeneratedForGivenDrawDate(LocalDateTime drawDate) {
        return repository.existsByDrawDate(drawDate);
    }
}
