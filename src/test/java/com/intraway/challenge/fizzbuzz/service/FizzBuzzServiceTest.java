package com.intraway.challenge.fizzbuzz.service;

import com.intraway.challenge.fizzbuzz.dto.FizzBuzzDTO;
import com.intraway.challenge.fizzbuzz.model.FizzBuzz;
import com.intraway.challenge.fizzbuzz.persistence.FizzBuzzRepository;
import com.intraway.challenge.fizzbuzz.util.TimeUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FizzBuzzServiceTest {

    @InjectMocks
    private FizzBuzzService fizzBuzzService;

    @Mock
    private FizzBuzzRepository fizzBuzzRepository;

    @Test
    void fizzBuzzMof3And5_success(){
        int min = 1;
        int max = 5;
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setMax(min);
        fizzBuzz.setMin(max);
        fizzBuzz.setId(1L);
        LocalDateTime now = LocalDateTime.now();
        fizzBuzz.setCreatedAt(now);
        when(fizzBuzzRepository.save(any(FizzBuzz.class))).thenReturn(fizzBuzz);
        FizzBuzzDTO fizzBuzzResult = fizzBuzzService.getFizzBuzzResult(min, max);

        assertEquals(String.valueOf(fizzBuzz.getId()), fizzBuzzResult.getCode());
        assertEquals("Se encontraron múltiplos de 3 y 5", fizzBuzzResult.getDescription());
        assertEquals(String.join(",", List.of("1","2","Fizz","4","Buzz")), fizzBuzzResult.getList());
        assertEquals(TimeUtil.localDateTimeToMillis(now), fizzBuzzResult.getTimestamp());

        ArgumentCaptor<FizzBuzz> fizzBuzzArgumentCaptor = ArgumentCaptor.forClass(FizzBuzz.class);
        verify(fizzBuzzRepository).save(fizzBuzzArgumentCaptor.capture());
        FizzBuzz savedFizzBuzz = fizzBuzzArgumentCaptor.getValue();

        assertEquals(min, savedFizzBuzz.getMin());
        assertEquals(max, savedFizzBuzz.getMax());
    }

    @Test
    void fizzBuzzMof3_success(){
        int min = 6;
        int max = 9;
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setMax(min);
        fizzBuzz.setMin(max);
        fizzBuzz.setId(1L);
        LocalDateTime now = LocalDateTime.now();
        fizzBuzz.setCreatedAt(now);
        when(fizzBuzzRepository.save(any(FizzBuzz.class))).thenReturn(fizzBuzz);
        FizzBuzzDTO fizzBuzzResult = fizzBuzzService.getFizzBuzzResult(min, max);

        assertEquals(String.valueOf(fizzBuzz.getId()), fizzBuzzResult.getCode());
        assertEquals("Se encontraron múltiplos de 3", fizzBuzzResult.getDescription());
        assertEquals(String.join(",", List.of("Fizz","7","8","Fizz")), fizzBuzzResult.getList());
        assertEquals(TimeUtil.localDateTimeToMillis(now), fizzBuzzResult.getTimestamp());

        ArgumentCaptor<FizzBuzz> fizzBuzzArgumentCaptor = ArgumentCaptor.forClass(FizzBuzz.class);
        verify(fizzBuzzRepository).save(fizzBuzzArgumentCaptor.capture());
        FizzBuzz savedFizzBuzz = fizzBuzzArgumentCaptor.getValue();

        assertEquals(min, savedFizzBuzz.getMin());
        assertEquals(max, savedFizzBuzz.getMax());
    }

    @Test
    void fizzBuzzMof5_success(){
        int min = 10;
        int max = 11;
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setMax(min);
        fizzBuzz.setMin(max);
        fizzBuzz.setId(1L);
        LocalDateTime now = LocalDateTime.now();
        fizzBuzz.setCreatedAt(now);
        when(fizzBuzzRepository.save(any(FizzBuzz.class))).thenReturn(fizzBuzz);
        FizzBuzzDTO fizzBuzzResult = fizzBuzzService.getFizzBuzzResult(min, max);

        assertEquals(String.valueOf(fizzBuzz.getId()), fizzBuzzResult.getCode());
        assertEquals("Se encontraron múltiplos de 5", fizzBuzzResult.getDescription());
        assertEquals(String.join(",", List.of("Buzz","11")), fizzBuzzResult.getList());
        assertEquals(TimeUtil.localDateTimeToMillis(now), fizzBuzzResult.getTimestamp());

        ArgumentCaptor<FizzBuzz> fizzBuzzArgumentCaptor = ArgumentCaptor.forClass(FizzBuzz.class);
        verify(fizzBuzzRepository).save(fizzBuzzArgumentCaptor.capture());
        FizzBuzz savedFizzBuzz = fizzBuzzArgumentCaptor.getValue();

        assertEquals(min, savedFizzBuzz.getMin());
        assertEquals(max, savedFizzBuzz.getMax());
    }

    @Test
    void fizzBuzzOnlyZero_success(){
        int min = 0;
        int max = 0;
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setMax(min);
        fizzBuzz.setMin(max);
        fizzBuzz.setId(1L);
        LocalDateTime now = LocalDateTime.now();
        fizzBuzz.setCreatedAt(now);
        when(fizzBuzzRepository.save(any(FizzBuzz.class))).thenReturn(fizzBuzz);
        FizzBuzzDTO fizzBuzzResult = fizzBuzzService.getFizzBuzzResult(min, max);

        assertEquals(String.valueOf(fizzBuzz.getId()), fizzBuzzResult.getCode());
        assertEquals("Se encontraron múltiplos de 3 y 5", fizzBuzzResult.getDescription());
        assertEquals(String.join(",", List.of("FizzBuzz")), fizzBuzzResult.getList());
        assertEquals(TimeUtil.localDateTimeToMillis(now), fizzBuzzResult.getTimestamp());

        ArgumentCaptor<FizzBuzz> fizzBuzzArgumentCaptor = ArgumentCaptor.forClass(FizzBuzz.class);
        verify(fizzBuzzRepository).save(fizzBuzzArgumentCaptor.capture());
        FizzBuzz savedFizzBuzz = fizzBuzzArgumentCaptor.getValue();

        assertEquals(min, savedFizzBuzz.getMin());
        assertEquals(max, savedFizzBuzz.getMax());
    }

    @Test
    void fizzBuzzWithNegatives_success(){
        int min = -5;
        int max = 10;
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setMax(min);
        fizzBuzz.setMin(max);
        fizzBuzz.setId(1L);
        LocalDateTime now = LocalDateTime.now();
        fizzBuzz.setCreatedAt(now);
        when(fizzBuzzRepository.save(any(FizzBuzz.class))).thenReturn(fizzBuzz);
        FizzBuzzDTO fizzBuzzResult = fizzBuzzService.getFizzBuzzResult(min, max);

        assertEquals(String.valueOf(fizzBuzz.getId()), fizzBuzzResult.getCode());
        assertEquals("Se encontraron múltiplos de 3 y 5", fizzBuzzResult.getDescription());
        assertEquals(String.join(",", List.of("Buzz,-4,Fizz,-2,-1,FizzBuzz,1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz")), fizzBuzzResult.getList());
        assertEquals(TimeUtil.localDateTimeToMillis(now), fizzBuzzResult.getTimestamp());

        ArgumentCaptor<FizzBuzz> fizzBuzzArgumentCaptor = ArgumentCaptor.forClass(FizzBuzz.class);
        verify(fizzBuzzRepository).save(fizzBuzzArgumentCaptor.capture());
        FizzBuzz savedFizzBuzz = fizzBuzzArgumentCaptor.getValue();

        assertEquals(min, savedFizzBuzz.getMin());
        assertEquals(max, savedFizzBuzz.getMax());
    }

    @Test
    void minGreaterThanMax_error(){
        Throwable throwable = catchThrowable(() -> fizzBuzzService.getFizzBuzzResult(7, -1));
        assertEquals(throwable.getClass(), IllegalArgumentException.class);
        assertEquals("min: 7 must be lower or equal than max: -1", throwable.getMessage());
    }

}
