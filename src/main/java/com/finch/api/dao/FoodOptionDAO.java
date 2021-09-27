package com.finch.api.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finch.api.model.FoodOption;

@Repository
public class FoodOptionDAO implements IFoodOptionDAO {

	private EntityManager entityManager;

	@Autowired
	public FoodOptionDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<FoodOption> getAllFoodOptions() {
		return null;
	}

}