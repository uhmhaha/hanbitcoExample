package com.hanbitco.example.common;

public enum ResponseCode {

	SUCCESS(1000, "success"),
	FAIL(-1000, "fail");
	
	private int responseCode;
	private String description;
	
	private ResponseCode(int responseCode, String description){
		
		this.responseCode = responseCode;
		this.description = description;
	}
	
	public int getResponseCode(){
		return responseCode;
	}
	
	public String getResponseMessage(){
		return description;
	}
}
