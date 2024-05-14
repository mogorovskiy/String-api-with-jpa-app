package com.mogorovskiy.lamp.mapper;

import com.mogorovskiy.lamp.dto.LampRequestDto;
import com.mogorovskiy.lamp.model.Lamp;
import org.springframework.stereotype.Service;

@Service
public class LampMapper {

    public Lamp toModel(LampRequestDto lampRequestDto) {
        Lamp lamp = new Lamp();
        lamp.setPower(lampRequestDto.getPower());
        lamp.setManufacturer(lampRequestDto.getManufacturer());

        return lamp;
    }
}
