package com.mogorovskiy.lamp.service;

import com.mogorovskiy.lamp.dto.*;
import com.mogorovskiy.lamp.model.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface LampService {

    Lamp save(LampRequestDto lampRequestDto);

    List<Lamp> findAll();

    List<Lamp> findByManufacturer(LampRequestDto lampRequestDto);

    List<Lamp> findByPower(LampRequestDto lampRequestDto);

    Lamp updateLamp(Long id, LampRequestDto lampRequestDto);

    void deleteLamp(Long id);

    Optional<Lamp> findById(Long id);
}
