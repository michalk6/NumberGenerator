package pl.numbergenerator.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.numbergenerator.winningnumbergenerator.WinningNumberGeneratorFacade;
import pl.numbergenerator.winningnumbergenerator.dto.WinningNumbersDto;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@Log4j2
public class NumberGeneratorController {
    private final WinningNumberGeneratorFacade winningNumberGeneratorFacade;

    @GetMapping("/generateNumbers")
    public ResponseEntity<WinningNumbersDto> drawWinningNumbers(
            @RequestParam("amount") int numberOfNumbers,
            @RequestParam("max") int maxNumber,
            @RequestBody(required = false) LocalDateTime drawDate
    ) {
        log.info("logger started");
        WinningNumbersDto winningNumbersDto = winningNumberGeneratorFacade.drawUniqueNumbers(numberOfNumbers, maxNumber, drawDate);
        log.info("logger finished, numbers: " + winningNumbersDto);
        return ResponseEntity.ok(winningNumbersDto);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testRest() {
        log.info("logger test microservice");
        return ResponseEntity.ok("Returned from microservice");
    }
}
