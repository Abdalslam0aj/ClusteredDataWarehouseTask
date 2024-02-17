package com.interview.task.deals.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.task.deals.entity.DealDetails;

public interface DealRepository extends JpaRepository<DealDetails, String> {
    
}
