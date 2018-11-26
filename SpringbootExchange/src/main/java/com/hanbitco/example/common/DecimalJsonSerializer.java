package com.hanbitco.example.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * ObjectMapper에서 last필드의 소수점을 소수점 이하 1자리로 정리하기 위한 serializer 
 * @author skyang
 *
 */
public class DecimalJsonSerializer extends JsonSerializer<Float>{

	@Override
	public void serialize(Float value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		gen.writeNumber(String.format("%.1f", value));
	}
	
}
