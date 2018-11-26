package com.hanbitco.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanbitco.example.vo.CoinVO;

/**
 * Currency Service
 * @author skyang
 *
 */
@Service
public class CurrencyService {

	@Value("${my-url.datafile}")
	private String datafile;
	
	@Value("${my.value.exchange}")
	private List<String> exchange;
	
	@Autowired
	private ResourceLoader resourceLoader;
	private Map<String, Map<String, CoinVO>> finalJson;
	
	/**
	 * Fuction init() make the coin exchage market's infomation read from file named price.json
	 * the infomation inclues coin exchage market name, originPair name and last price.
	 * if the coin exchange market name do not exist in the json.data,
	 * it will generate in finalJson with null value
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PostConstruct
	private void init() throws JsonParseException, JsonMappingException, IOException {

		InputStream input = null;
		Resource resource = resourceLoader.getResource(datafile);
		input = resource.getInputStream();
		
		Map<String, Map<String, CoinVO>> readJson = new ObjectMapper().readValue(input, new TypeReference<Map<String, Map<String, CoinVO>>>() {});
		Map<String, CoinVO> middleJson = new HashMap<String, CoinVO>();
		
		finalJson = new HashMap<String, Map<String, CoinVO>>();	
		
		readJson.forEach( (k,v) ->
				{
					if(v.keySet().size() < exchange.size() ){
						for(String ex : exchange){
							if(!v.keySet().contains(ex)){
								middleJson.put(ex, null);
							}else{
								middleJson.put(ex, v.get(ex));
							}
						}
						finalJson.put(k, middleJson);
					}
				});
		
	}

	public Map<String, Map<String, CoinVO>> getAllCurrencyFromFile() throws Exception {
		
		return finalJson;

	}

	public Map<String, Map<String, CoinVO>> getACurrencyFromFile(String currency) throws Exception {

		return finalJson.entrySet().stream()
						.filter(map -> map.getKey().equals(currency))
						.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

	}

}
