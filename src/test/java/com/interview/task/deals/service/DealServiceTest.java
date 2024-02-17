package com.interview.task.deals.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.interview.task.deals.dto.DealDetailsDto;
import com.interview.task.deals.exceptions.DealAlreadyExistsException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


@SpringBootTest
public class DealServiceTest {

    @Autowired
    IDealService dealService;

    private Validator validator;

    @BeforeEach()
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void validationHappyScenario() {
        var dealDetailsDto = new DealDetailsDto();
        dealDetailsDto.setId(UUID.randomUUID().toString());
        dealDetailsDto.setOrderingCurrencyISOCode("USD");
        dealDetailsDto.setOrderingAmount(23.4);
        dealDetailsDto.setToCurrencyISOCode("JOD");
        dealDetailsDto.setTimestamp(LocalDateTime.now());
        Set<ConstraintViolation<DealDetailsDto>> violations = validator.validate(dealDetailsDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void validationWorstCaseScenario() {
        var dealDetailsDto = new DealDetailsDto();
        dealDetailsDto.setId("");
        dealDetailsDto.setOrderingCurrencyISOCode("$");
        dealDetailsDto.setOrderingAmount(null);
        dealDetailsDto.setToCurrencyISOCode("JD");
        dealDetailsDto.setTimestamp(null);
        Set<ConstraintViolation<DealDetailsDto>> violations = validator.validate(dealDetailsDto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void dealCreation() {
        var dealDetailsDto = new DealDetailsDto();
        dealDetailsDto.setId(UUID.randomUUID().toString());
        dealDetailsDto.setOrderingCurrencyISOCode("USD");
        dealDetailsDto.setOrderingAmount(23.4);
        dealDetailsDto.setToCurrencyISOCode("JOD");
        dealDetailsDto.setTimestamp(LocalDateTime.now());
        dealService.createDeal(dealDetailsDto);
    }


    @Test
    void dealDuplication() {
        var duplicateId = UUID.randomUUID().toString();
        var dealDetailsDto = new DealDetailsDto();
        dealDetailsDto.setId(duplicateId);
        dealDetailsDto.setOrderingCurrencyISOCode("USD");
        dealDetailsDto.setOrderingAmount(23.4);
        dealDetailsDto.setToCurrencyISOCode("JOD");
        dealDetailsDto.setTimestamp(LocalDateTime.now());

        var dealDetailsDtoDuplicate = new DealDetailsDto();
        dealDetailsDtoDuplicate.setId(duplicateId);
        dealDetailsDtoDuplicate.setOrderingCurrencyISOCode("USD");
        dealDetailsDtoDuplicate.setOrderingAmount(23.4);
        dealDetailsDtoDuplicate.setToCurrencyISOCode("JOD");
        dealDetailsDtoDuplicate.setTimestamp(LocalDateTime.now());

        dealService.createDeal(dealDetailsDto);
        assertThrows(DealAlreadyExistsException.class, () -> {
            dealService.createDeal(dealDetailsDtoDuplicate);
        });
    }

}
