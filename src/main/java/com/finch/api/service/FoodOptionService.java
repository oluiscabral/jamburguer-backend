package com.finch.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finch.api.dao.FoodOptionDAO;
import com.finch.api.model.FoodOption;

@Service
public class FoodOptionService implements IFoodOptionService {

	private FoodOptionDAO foodOptionDAO;

	@Autowired
	public FoodOptionService(@Qualifier("foodOptionDAO") FoodOptionDAO foodOptionDAO) {
		this.foodOptionDAO = foodOptionDAO;
	}

	@Override
	@Transactional
	public List<FoodOption> getAllFoodOptions() {
		return foodOptionDAO.getAllFoodOptions();
	}

}
