package com.example.tgbot.repository;


import com.example.tgbot.Entity.Spend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpendRepository extends JpaRepository<Spend, Long> {
}