package com.hanbitco.example.common;

public class ResponseMessage {
	
	private ResponseCode respCode;
	private String respDesc;
	
	public ResponseMessage(ResponseCode respCode){
		this.respCode = respCode;
		respDesc = respCode.getResponseMessage();
	}

	public ResponseCode getRespCode() {
		return respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

}
