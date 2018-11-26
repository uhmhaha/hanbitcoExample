package com.hanbitco.example.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hanbitco.example.common.DecimalJsonSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class CoinVO {
	
	private String originPair;
	
	@JsonSerialize(using=DecimalJsonSerializer.class)
	private float last;
	
	public String getOriginPair() {
		return originPair;
	}
	public void setOriginPair(String originPair) {
		this.originPair = originPair;
	}
	public float getLast() {
		return last;
	}
	public void setLast(float last) {
		this.last = last;
	}
}
