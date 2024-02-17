package com.interview.task.deals.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.task.deals.constants.DealConstants;
import com.interview.task.deals.dto.DealDetailsDto;
import com.interview.task.deals.dto.ResponseDto;
import com.interview.task.deals.service.IDealService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;

/**
 * DealsController
 */

@RestController
@AllArgsConstructor
@Validated
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DealsController {

    private IDealService dealService;

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody DealDetailsDto dealDetailsDto) {
        dealService.createDeal(dealDetailsDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.value(), DealConstants.DEAL_CREATED));
    }

}