package pl.numbergenerator.winningnumbergenerator;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberGeneratorFacadeTest {
    WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
    WinningNumbersRepositoryInMemory repository = new WinningNumbersRepositoryInMemory();
    @Test
    public void drawUniqueNumbers_shouldReturnCollectionOfSixUniqueNumbers() {
        // given
        WinningNumberGeneratorFacade winningNumberGeneratorFacade = new WinningNumberGeneratorFacade(winningNumberGenerator, repository);
        // when
        Random random = new Random();
        int bound = 1000000;
        int maxNumber = random.nextInt(bound);
        System.out.println(maxNumber);
        int numberOfNumbers = random.nextInt(maxNumber);
        Set<Integer> numbersDrawn = winningNumberGeneratorFacade.drawUniqueNumbers(numberOfNumbers, maxNumber, null).numbers();
        // then
        assertThat(numbersDrawn.size()).isEqualTo(numberOfNumbers);
    }

    @Test
    public void drawUniqueNumbers_shouldReturnDtoWithGivenDrawDate() {
        //given
        WinningNumberGeneratorFacade winningNumberGeneratorFacade = new WinningNumberGeneratorFacade(winningNumberGenerator, repository);
        //when
        LocalDateTime drawDate = LocalDateTime.now();
        winningNumberGeneratorFacade.drawUniqueNumbers(10, 100, drawDate);
        //then
        assertThat(repository.existsByDrawDate(drawDate)).isTrue();
    }

}