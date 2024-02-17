package com.interview.task.deals.mapper;

import com.interview.task.deals.dto.DealDetailsDto;
import com.interview.task.deals.entity.DealDetails;

public class DealMapper {

    public static DealDetailsDto toDealDetailsDto(DealDetails dealDetails, DealDetailsDto dealDetailsDto) {
        dealDetailsDto.setId(dealDetails.getId());
        dealDetailsDto.setOrderingAmount(dealDetails.getOrderingAmount());
        dealDetailsDto.setOrderingCurrencyISOCode(dealDetails.getOrderingCurrencyISOCode());
        dealDetailsDto.setToCurrencyISOCode(dealDetails.getToCurrencyISOCode());
        return dealDetailsDto;
    }

    public static DealDetails toDealDetails(DealDetailsDto dealDetailsDto, DealDetails dealDetails) {
        dealDetails.setId(dealDetailsDto.getId());
        dealDetails.setOrderingAmount(dealDetailsDto.getOrderingAmount());
        dealDetails.setOrderingCurrencyISOCode(dealDetailsDto.getOrderingCurrencyISOCode());
        dealDetails.setToCurrencyISOCode(dealDetailsDto.getToCurrencyISOCode());
        return dealDetails;
    }
    
}
