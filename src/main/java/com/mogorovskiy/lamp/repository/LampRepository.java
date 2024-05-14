package com.mogorovskiy.lamp.repository;

import com.mogorovskiy.lamp.model.Lamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LampRepository extends JpaRepository<Lamp, Long> {

    List<Lamp> findByManufacturer(String manufacturer);

    List<Lamp> findByPower(Long power);

    void deleteById(Long id);
}
