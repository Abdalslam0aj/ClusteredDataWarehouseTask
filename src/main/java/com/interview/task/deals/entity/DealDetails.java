package com.interview.task.deals.entity;

import java.security.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
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

    @Column(nullable = false)
    private String orderingCurrencyISOCode;

    @Column(nullable = false)
    private Double orderingAmount;

    @Column(nullable = false)
    private String toCurrencyISOCode;

    @Column(nullable = false)
    private LocalDateTime timestamp;
    
}
