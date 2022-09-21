package com.example.tgbot;

import com.example.tgbot.Entity.Spend;
import com.example.tgbot.config.MyJpaConfig;
import com.example.tgbot.repository.SpendRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { MyJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository;

    @Test
    public void testRepo() {
        //noinspection StatementWithEmptyBody
        for (int i = 0; i < 10; i++, spendRepository.save(new Spend()));
        final List<Spend> found = spendRepository.findAll();
        assertEquals(10, found.size());
    }
}