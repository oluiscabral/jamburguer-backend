package com.finch.api.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.finch.api.model.Ingredient;

public class IngredientSerializer extends StdSerializer<Ingredient> {

	private static final long serialVersionUID = 723379001442804482L;

	public IngredientSerializer() {
		this(null);
	}

	public IngredientSerializer(Class<Ingredient> t) {
		super(t);
	}

	@Override
	public void serialize(Ingredient ingredient, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("id", ingredient.getId());
		jsonGenerator.writeStringField("name", ingredient.getName());
		jsonGenerator.writeNumberField("unit_price", ingredient.getPrice());
		jsonGenerator.writeEndObject();
	}
}
