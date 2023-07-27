package com.intraway.challenge.fizzbuzz.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FizzBuzzDTO {

    private Long timestamp;

    private String code;

    private String description;

    private String list;
}
