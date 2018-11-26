package com.hanbitco.example.common;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DecimalJsonSerializer extends JsonSerializer<Float>{

	@Override
	public void serialize(Float value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		
		gen.writeNumber(String.format("%.1f", value));
		//DecimalFormat df = new DecimalFormat("###,##0.00").format(value)
		//gen.writeNumber();
	}
	
}
