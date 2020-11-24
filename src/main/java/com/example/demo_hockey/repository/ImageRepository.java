package com.example.demo_hockey.repository;

import com.example.demo_hockey.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
