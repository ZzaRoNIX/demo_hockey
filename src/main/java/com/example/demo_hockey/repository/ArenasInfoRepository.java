package com.example.demo_hockey.repository;

import com.example.demo_hockey.entity.Arena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArenasInfoRepository extends JpaRepository<Arena, Integer> {
    Arena findByName(String name);
}
