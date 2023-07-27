package com.intraway.challenge.fizzbuzz.controller;

import com.intraway.challenge.fizzbuzz.dto.FizzBuzzDTO;
import com.intraway.challenge.fizzbuzz.service.FizzBuzzService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    @CrossOrigin //Only for the purpose of this challenge
    @GetMapping("/intraway/api/fizzbuzz/{min}/{max}")
    public ResponseEntity<FizzBuzzDTO> fizzbuzz(@PathVariable int min, @PathVariable int max){
        log.info("New fizzbuzz request, min:{} - max:{}", min, max);
        FizzBuzzDTO fizzBuzzResult = fizzBuzzService.getFizzBuzzResult(min, max);

        return ResponseEntity.ok(fizzBuzzResult);
    }
}
