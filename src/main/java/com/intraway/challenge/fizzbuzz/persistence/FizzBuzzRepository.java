package com.intraway.challenge.fizzbuzz.persistence;

import com.intraway.challenge.fizzbuzz.model.FizzBuzz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FizzBuzzRepository extends CrudRepository<FizzBuzz, Long> {
}
