package com.example.demo_hockey.repository;

import com.example.demo_hockey.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий
public interface TrainerCardRepository extends JpaRepository<Trainer, Integer> {
    // метод
    Trainer findByFullName(String fullName);
    
}

