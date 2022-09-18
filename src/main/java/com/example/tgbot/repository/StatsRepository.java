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


    //способ реализации того же самого только через именнованые темплейты
    /*private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int getCountOfIncomesThatGreaterThan(BigDecimal amount){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("amount", amount);
        return  namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM incomes WHERE income > :amount ", parameters, new StatsRowMapper());

    }

    private static final class StatsRowMapper implements RowMapper<Integer> {
        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("COUNT");
        }
    }
    */
}
