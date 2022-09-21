package com.example.tgbot;

import com.example.tgbot.Entity.Income;
import com.example.tgbot.repository.IncomeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// аннотация, настраивающая тест на проверку JPA
@DataJpaTest
class IncomeRepositoryTest {

    // делаем заглушку проверяемого репозитория
    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    public void testRepo() {
        // наполняем таблицу некоторыми данными, можно пустыми, это не важно
        //noinspection StatementWithEmptyBody
        for (int i = 0; i < 10; i++, incomeRepository.save(new Income()));
        // достаём из базы все записи
        final List<Income> found = incomeRepository.findAll();
        // проверяем, что достали столько же, сколько положили
        assertEquals(10, found.size());
    }
}