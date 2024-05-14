package com.mogorovskiy.lamp.controller;

import com.mogorovskiy.lamp.dto.LampRequestDto;
import com.mogorovskiy.lamp.model.Lamp;
import com.mogorovskiy.lamp.service.LampService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/lamp")
public class LampController {

    private final LampService lampService;

    @GetMapping("/findAll")
    public List<Lamp> findAll() {
        log.info("Find all!");
        return lampService.findAll();
    }

    @PostMapping("/save")
    public Lamp save(@RequestBody LampRequestDto lampRequestDto) {
        log.info("Save: {}", lampRequestDto);
        return lampService.save(lampRequestDto);
    }

    @PostMapping("/findByManufacturer")
    public List<Lamp> findByManufacturer(@RequestBody LampRequestDto lampRequestDto) {
        log.info("FindByManufacturer: {}", lampRequestDto);
        return lampService.findByManufacturer(lampRequestDto);
    }

    @PostMapping("/findByPower")
    public List<Lamp> findByPower(@RequestBody LampRequestDto lampRequestDto) {
        log.info("FindByPower: {}", lampRequestDto);
        return lampService.findByPower(lampRequestDto);
    }

    @PostMapping("/updateLamp/{id}")
    public Lamp updateLamp(@PathVariable Long id, @RequestBody LampRequestDto lampRequestDto) {
        log.info("Update lamp: {}", lampRequestDto);
        return lampService.updateLamp(id, lampRequestDto);
    }

    @DeleteMapping("/deleteLamp/{id}")
    public void deleteLamp(@PathVariable Long id) {
        log.info("Delete lamp: {}", id);
        lampService.deleteLamp(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<Lamp> getLampById(@PathVariable Long id) {
        log.info("Get lamp by id: {}", id);
        return lampService.findById(id);
    }
}
