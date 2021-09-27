package com.finch.api.serializer;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.finch.api.model.FoodOption;
import com.finch.api.model.Ingredient;

public class FoodOptionSerializer extends StdSerializer<FoodOption> {

	private static final long serialVersionUID = 4647923688335211623L;

	public FoodOptionSerializer() {
		this(null);
	}

	public FoodOptionSerializer(Class<FoodOption> t) {
		super(t);
	}

	@Override
	public void serialize(FoodOption foodOption, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("id", foodOption.getId());
		jsonGenerator.writeStringField("name", foodOption.getName());
		writeIngredients(jsonGenerator, foodOption.getIngredients());
		jsonGenerator.writeEndObject();
	}

	private static void writeIngredients(JsonGenerator jsonGenerator, Map<Ingredient, Integer> ingredients)
			throws IOException {
		jsonGenerator.writeArrayFieldStart("ingredients");
		for (Entry<Ingredient, Integer> ingredient : ingredients.entrySet()) {
			jsonGenerator.writeStartObject();
			jsonGenerator.writeNumberField("amount", ingredient.getValue());
			jsonGenerator.writeObject(ingredient.getKey());
			jsonGenerator.writeEndObject();
		}
		jsonGenerator.writeEndArray();
	}

}
