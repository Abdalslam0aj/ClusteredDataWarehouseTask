package com.interview.task.deals.service.impl;

import org.springframework.stereotype.Service;

import com.interview.task.deals.dto.DealDetailsDto;
import com.interview.task.deals.entity.DealDetails;
import com.interview.task.deals.exceptions.DealAlreadyExistsException;
import com.interview.task.deals.mapper.DealMapper;
import com.interview.task.deals.repository.DealRepository;
import com.interview.task.deals.service.IDealService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DealServiceImpl implements IDealService {

    private DealRepository dealRepository;
    protected static final Logger logger = LogManager.getLogger();

    @Override
    public void createDeal(DealDetailsDto dealDetailsDto) {
        var deal = dealRepository.findById(dealDetailsDto.getId());
        if (!deal.isPresent()) {
            DealDetails dealDetails = new DealDetails();
            dealDetails = DealMapper.toDealDetails(dealDetailsDto, dealDetails);
            dealRepository.save(dealDetails);
            logger.info("Deal created with id = " + dealDetails);
        } else {
            throw new DealAlreadyExistsException("Deal already exist id = " + dealDetailsDto.getId());
        }
    }

}
