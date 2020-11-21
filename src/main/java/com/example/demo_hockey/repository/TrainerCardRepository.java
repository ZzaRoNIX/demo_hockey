package com.example.demo_hockey.repository;

import com.example.demo_hockey.entity.AllTrainerInfo;
import lombok.val;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// репозиторий
public interface TrainerCardRepository extends JpaRepository<AllTrainerInfo, Integer> {
    // метод
    AllTrainerInfo findByFullName(String fullName);
    
}

