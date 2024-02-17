package com.interview.task.deals.entity;

import java.security.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DealDetails {

    @Id
    private String id;

    private String orderingCurrencyISOCode;

    private Double orderingAmount;

    private String toCurrencyISOCode;

    private LocalDateTime timestamp;
    
}
