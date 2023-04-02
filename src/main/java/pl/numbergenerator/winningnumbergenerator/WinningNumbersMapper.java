package pl.numbergenerator.winningnumbergenerator;


import pl.numbergenerator.winningnumbergenerator.dto.WinningNumbersDto;

class WinningNumbersMapper {

    public static WinningNumbersDto mapToDto(WinningNumbers winningNumbers) {
        return new WinningNumbersDto(winningNumbers.numbers(), winningNumbers.drawDate());
    }
}
