package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.Krs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KrsRepository extends JpaRepository<Krs, Long> {
}
