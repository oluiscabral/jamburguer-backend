package com.finch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finch.api.domain.FoodFactory;
import com.finch.api.model.FoodOption;
import com.finch.api.service.FoodOptionService;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {

	private final FoodOptionService foodOptionService;
	private final FoodFactory foodFactory;

	@Autowired
	public FoodController(FoodOptionService foodOptionService) throws Exception {
		this.foodOptionService = foodOptionService;
		this.foodFactory = new FoodFactory();
	}

	@GetMapping(value = "/options/")
	public ResponseEntity<List<FoodOption>> getAllFoodOptions() {
		List<FoodOption> foodOptions = foodOptionService.getAllFoodOptions();
		return new ResponseEntity<List<FoodOption>>(foodOptions, HttpStatus.OK);
	}
}
