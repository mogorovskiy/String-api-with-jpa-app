package com.mogorovskiy.Stringjpaapp.service.impl;

import com.mogorovskiy.Stringjpaapp.dto.LampRequestDto;
import com.mogorovskiy.Stringjpaapp.exception.*;
import com.mogorovskiy.Stringjpaapp.mapper.LampMapper;
import com.mogorovskiy.Stringjpaapp.model.Lamp;
import com.mogorovskiy.Stringjpaapp.repository.LampRepository;
import com.mogorovskiy.Stringjpaapp.service.LampService;
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
