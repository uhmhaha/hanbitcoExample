package com.hanbitco.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hanbitco.example.common.ResponseCode;
import com.hanbitco.example.service.CurrencyService;

@RestController
@RequestMapping(value = "/api/v1/data")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;
	private Map<String, Object> body;

	@RequestMapping(value = "/currency/{currency}", method = RequestMethod.GET)
	public ResponseEntity<Map<?, ?>> getACurrency(@PathVariable String currency) {
		
		body = new HashMap<String, Object>();
		
		try {
			body.put("status", ResponseCode.SUCCESS);
			body.put("data", currencyService.getACurrencyFromFile(currency));

			return ResponseEntity.status(HttpStatus.OK).body(body);

		} catch (Exception e) {
			body.put("status", ResponseCode.FAIL);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		}

	}

	@RequestMapping(value = "/currency", method = RequestMethod.GET)
	public ResponseEntity<Map<?, ?>> getAllCurrency() {

		body = new HashMap<String, Object>();

		try {

			body.put("status", ResponseCode.SUCCESS);
			body.put("data", currencyService.getAllCurrencyFromFile());

			return ResponseEntity.status(HttpStatus.OK).body(body);

		} catch (Exception e) {
			body.put("status", ResponseCode.FAIL);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		}

	}
	
}
