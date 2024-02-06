package com.mogorovskiy.Stringjpaapp.repository;

import com.mogorovskiy.Stringjpaapp.model.Lamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface LampRepository extends JpaRepository<Lamp, Long> {
    List<Lamp> findByManufacturer(String manufacturer);
    List<Lamp> findByPower(Long power);

    void deleteById(Long id);
}
