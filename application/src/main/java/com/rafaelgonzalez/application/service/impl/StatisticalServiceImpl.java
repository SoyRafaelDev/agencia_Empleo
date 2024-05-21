package com.rafaelgonzalez.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafaelgonzalez.application.model.Statistical;
import com.rafaelgonzalez.application.repository.StatisticalRepository;
import com.rafaelgonzalez.application.service.StatisticalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatisticalServiceImpl implements StatisticalService {

    private final StatisticalRepository statisticalRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Statistical addStatistical(Statistical statistical) {
        return statisticalRepository.save(statistical);
    }

    @Override
    public List<Statistical> getAllStatisticals() {
        return statisticalRepository.findAll();
    }

    @Override
    public Optional<Statistical> getStatisticalById(Long id) {
        return statisticalRepository.findById(id);
    }

    @Override
    public Statistical updateStatistical(Long id, String descriptionsJson) {
        return statisticalRepository.findById(id)
                .map(statistical -> {
                    statistical.setDescriptions(descriptionsJson);
                    return statisticalRepository.save(statistical);
                })
                .orElseThrow(() -> new RuntimeException("Statistical not found"));
    }

    @Override
    public void deleteStatisticalById(Long id) {
        statisticalRepository.deleteById(id);
    }
}