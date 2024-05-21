package com.rafaelgonzalez.application.service;

import com.rafaelgonzalez.application.model.Statistical;

import java.util.List;
import java.util.Optional;

public interface StatisticalService {
    Statistical addStatistical(Statistical statistical);

    List<Statistical> getAllStatisticals();

    Optional<Statistical> getStatisticalById(Long id);

    Statistical updateStatistical(Long id, String descriptionsJson);

    void deleteStatisticalById(Long id);
}
