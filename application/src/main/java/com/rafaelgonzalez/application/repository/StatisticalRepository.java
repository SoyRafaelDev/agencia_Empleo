package com.rafaelgonzalez.application.repository;

import com.rafaelgonzalez.application.model.Statistical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticalRepository extends JpaRepository<Statistical, Long> {
}