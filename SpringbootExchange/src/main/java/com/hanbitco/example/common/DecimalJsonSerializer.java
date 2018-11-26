package com.hanbitco.example.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * @author skyang
 *
 */
public class DecimalJsonSerializer extends JsonSerializer<Float>{

	@Override
	public void serialize(Float value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		gen.writeNumber(String.format("%.1f", value));
	}
	
}
