package com.rafaelgonzalez.application.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafaelgonzalez.application.model.Statistical;
import com.rafaelgonzalez.application.service.StatisticalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statisticals")
@RequiredArgsConstructor
public class StatisticalResource {
    private final StatisticalService statisticalService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Statistical> addStatistical(@RequestBody String descriptionsJson) throws JsonProcessingException {
        Statistical statistical = new Statistical();
        statistical.setDescriptions(descriptionsJson);
        Statistical createdStatistical = statisticalService.addStatistical(statistical);
        return ResponseEntity.ok(createdStatistical);
    }

    @GetMapping
    public ResponseEntity<List<Statistical>> getAllStatisticals() {
        List<Statistical> statisticals = statisticalService.getAllStatisticals();
        return ResponseEntity.ok(statisticals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statistical> getStatisticalById(@PathVariable Long id) {
        return statisticalService.getStatisticalById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistical> updateStatistical(@PathVariable Long id, @RequestBody String descriptionsJson) throws JsonProcessingException {
        Statistical updatedStatistical = statisticalService.updateStatistical(id, descriptionsJson);
        return ResponseEntity.ok(updatedStatistical);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistical(@PathVariable Long id) {
        statisticalService.deleteStatisticalById(id);
        return ResponseEntity.noContent().build();
    }
}