package com.example.tgbot;

import com.example.tgbot.Entity.Income;
import com.example.tgbot.repository.IncomeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// ���������, ������������� ���� �� �������� JPA
@DataJpaTest
class IncomeRepositoryTest {

    // ������ �������� ������������ �����������
    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    public void testRepo() {
        // ��������� ������� ���������� �������, ����� �������, ��� �� �����
        //noinspection StatementWithEmptyBody
        for (int i = 0; i < 10; i++, incomeRepository.save(new Income()));
        // ������ �� ���� ��� ������
        final List<Income> found = incomeRepository.findAll();
        // ���������, ��� ������� ������� ��, ������� ��������
        assertEquals(10, found.size());
    }
}