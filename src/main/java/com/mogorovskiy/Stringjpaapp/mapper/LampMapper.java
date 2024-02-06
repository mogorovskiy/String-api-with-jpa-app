package com.mogorovskiy.Stringjpaapp.mapper;

import com.mogorovskiy.Stringjpaapp.dto.*;
import com.mogorovskiy.Stringjpaapp.model.*;
import org.springframework.stereotype.*;

@Service
public class LampMapper {
    public Lamp toModel(LampRequestDto lampRequestDto) {
        Lamp lamp = new Lamp();
        lamp.setPower(lampRequestDto.getPower());
        lamp.setManufacturer(lampRequestDto.getManufacturer());
        return lamp;
    }
}
