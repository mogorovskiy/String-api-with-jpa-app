package com.mogorovskiy.lamp.service.impl;

import com.mogorovskiy.lamp.dto.LampRequestDto;
import com.mogorovskiy.lamp.exception.ResourceNotFoundException;
import com.mogorovskiy.lamp.mapper.LampMapper;
import com.mogorovskiy.lamp.model.Lamp;
import com.mogorovskiy.lamp.repository.LampRepository;
import com.mogorovskiy.lamp.service.LampService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LampServiceImpl implements LampService {

    private final LampRepository lampRepository;
    private final LampMapper lampMapper;

    @Override
    public Lamp save(LampRequestDto lampRequestDto) {
        Lamp lamp = lampMapper.toModel(lampRequestDto);
        return lampRepository.save(lamp);
    }

    @Override
    public List<Lamp> findAll() {
        return lampRepository.findAll();
    }

    @Override
    public List<Lamp> findByManufacturer(LampRequestDto lampRequestDto) {
        String manufacturer = lampRequestDto.getManufacturer();
        return lampRepository.findByManufacturer(manufacturer);
    }

    @Override
    public List<Lamp> findByPower(LampRequestDto lampRequestDto) {
        Long power = lampRequestDto.getPower();
        return lampRepository.findByPower(power);
    }

    @Override
    public Lamp updateLamp(Long id, LampRequestDto lampRequestDto) {
        Lamp existingLamp = lampRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lamp not found with id: " + id));

        existingLamp.setManufacturer(lampRequestDto.getManufacturer());
        existingLamp.setPower(lampRequestDto.getPower());

        return lampRepository.save(existingLamp);
    }

    @Override
    public void deleteLamp(Long id) {
        lampRepository.deleteById(id);
    }

    @Override
    public Optional<Lamp> findById(Long id) {
        return lampRepository.findById(id);
    }
}
