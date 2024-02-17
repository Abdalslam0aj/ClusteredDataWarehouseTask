package com.interview.task.deals.dto;

import java.time.LocalDateTime;
import com.interview.task.deals.constants.ValidationMessages;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DealDetailsDto {

    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    private String id;

    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    //@Currency(message = "", value = {}. DealConstants.CURRENCY)
    @Pattern(regexp = "(^$|[A-Z]{3})", message = ValidationMessages.INVALID_CURRENCY_CODE)
    private String orderingCurrencyISOCode;

    @NotNull(message = ValidationMessages.NOT_EMPTY)
    private Double orderingAmount;

    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    @Pattern(regexp = "(^$|[A-Z]{3})", message = ValidationMessages.INVALID_CURRENCY_CODE)
    private String toCurrencyISOCode;

    @NotNull(message = ValidationMessages.NOT_EMPTY)
    private LocalDateTime timestamp;
    
}
