package com.finch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finch.api.model.FoodOption;

@Repository
public interface FoodOptionRepository extends JpaRepository<FoodOption, Long> {
}
