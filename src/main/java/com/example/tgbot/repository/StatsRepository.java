package com.example.tgbot.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
public class StatsRepository {

    private final JdbcTemplate jdbcTemplate;

    public int getCountOfIncomesThatGreaterThan(BigDecimal amount){
        return  jdbcTemplate.queryForObject("SELECT count(*) FROM incomes WHERE income > ? ", Integer.class, amount );
    }
}
