package com.finch.api.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.finch.api.serializer.FoodOptionSerializer;

@Entity(name = "food_option")
@Table(name = "food_option")
@EntityListeners(AuditingEntityListener.class)
@JsonSerialize(using = FoodOptionSerializer.class)
public class FoodOption {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "ingredients", nullable = false)
	private Map<Ingredient, Integer> ingredients;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<Ingredient, Integer> getIngredients() {
		return ingredients;
	}

}