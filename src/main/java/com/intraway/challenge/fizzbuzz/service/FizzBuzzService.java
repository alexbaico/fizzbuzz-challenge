package com.intraway.challenge.fizzbuzz.service;

import com.intraway.challenge.fizzbuzz.dto.FizzBuzzDTO;
import com.intraway.challenge.fizzbuzz.model.FizzBuzz;
import com.intraway.challenge.fizzbuzz.persistence.FizzBuzzRepository;
import com.intraway.challenge.fizzbuzz.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class FizzBuzzService {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String MULTIPLES_OF_THREE_AND_FIVE_MESSAGE = "Se encontraron múltiplos de 3 y 5";
    private static final String MULTIPLES_OF_THREE_MESSAGE = "Se encontraron múltiplos de 3";
    private static final String MULTIPLES_OF_FIVE_MESSAGE = "Se encontraron múltiplos de 5";
    private static final String NONE_FOUND = "No se encontraron ni múltiplos de 3 ni de 5";
    private static final String MIN_GREATER_THAN_MAX = "min: %s must be lower or equal than max: %s";

    private final FizzBuzzRepository fizzBuzzRepository;

    public FizzBuzzDTO getFizzBuzzResult(int min, int max){
        log.info("Calculating FizzBuzz for min:{} - max:{}", min, max);
        if (min > max) {
            throw new IllegalArgumentException(String.format(MIN_GREATER_THAN_MAX, min, max));
        }

        List<String> fizzBuzzResult = calculateFizzBuzzStringResult(min, max);

        FizzBuzz fizzBuzz = generateAndSaveFizzBuzzEntity(min, max, fizzBuzzResult);

        return FizzBuzzDTO.builder()
                .code(String.valueOf(fizzBuzz.getId()))
                .timestamp(TimeUtil.localDateTimeToMillis(fizzBuzz.getCreatedAt()))
                .description(getDescriptionForFizzBuzz(fizzBuzzResult))
                .list(String.join(",", fizzBuzzResult))
                .build();
    }

    private FizzBuzz generateAndSaveFizzBuzzEntity(int min, int max, List<String> fizzBuzzResult) {
        FizzBuzz fizzBuzz = FizzBuzz.builder()
                .min(min)
                .max(max)
                .build();

        return fizzBuzzRepository.save(fizzBuzz);
    }

    private List<String> calculateFizzBuzzStringResult(int min, int max) {
        IntStream intStream = IntStream.rangeClosed(min, max);
        return intStream.mapToObj(value -> {
            StringBuilder stringBuilder = new StringBuilder();
            if(value % 3 == 0){
                stringBuilder.append(FIZZ);
            }
            if(value % 5 == 0){
                stringBuilder.append(BUZZ);
            }
            String stringResult = stringBuilder.toString();
            return stringResult.isEmpty() ? String.valueOf(value) : stringResult;
        }).collect(Collectors.toList());
    }

    private String getDescriptionForFizzBuzz(List<String> fizzBuzzResult) {
        if(fizzBuzzResult.contains(FIZZ.concat(BUZZ)) ||
            (fizzBuzzResult.contains(FIZZ) && fizzBuzzResult.contains(BUZZ))){
            return MULTIPLES_OF_THREE_AND_FIVE_MESSAGE;
        } else if(fizzBuzzResult.contains(FIZZ)){
            return MULTIPLES_OF_THREE_MESSAGE;
        } else if(fizzBuzzResult.contains(BUZZ)){
            return MULTIPLES_OF_FIVE_MESSAGE;
        } else {
            return NONE_FOUND;
        }
    }

}
