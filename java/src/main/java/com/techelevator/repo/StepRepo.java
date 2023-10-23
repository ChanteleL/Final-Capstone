package com.techelevator.repo;

import com.techelevator.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepo extends JpaRepository<Step, Long> {
}
