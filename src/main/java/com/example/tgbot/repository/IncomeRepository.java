package com.example.tgbot.repository;

import com.example.tgbot.Entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}