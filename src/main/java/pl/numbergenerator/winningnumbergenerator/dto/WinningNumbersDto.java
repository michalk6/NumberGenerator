package pl.numbergenerator.winningnumbergenerator.dto;

import java.time.LocalDateTime;
import java.util.Set;

public record WinningNumbersDto(Set<Integer> numbers, LocalDateTime drawDate) {
}
