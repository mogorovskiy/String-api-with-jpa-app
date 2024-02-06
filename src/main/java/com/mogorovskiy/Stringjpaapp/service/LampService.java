package com.mogorovskiy.Stringjpaapp.service;

import com.mogorovskiy.Stringjpaapp.dto.*;
import com.mogorovskiy.Stringjpaapp.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

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
