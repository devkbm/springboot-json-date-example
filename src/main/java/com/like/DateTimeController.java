package com.like;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring Boot 3.0 테스트시 @DateTimeFormat 사용만으로 변환 가능함
 */
@Slf4j
@RestController
public class DateTimeController {

	@GetMapping("/get-localdate")
	public String getLocalDate(LocalDateModel data) {		
		log.info(data.getName());
		log.info(data.getDate().toString());
		
		return "get 성공";	
	}
	
	@GetMapping("/get-localdate2")
	public String getLocalDate(@RequestParam LocalDateTime date) {	
		log.info(date.toString());
		
		return "get 성공";	
	}	
	
	@GetMapping("/get-localdate3")
	public LocalDateModel getLocalDateResponse() {
		return new LocalDateModel("test", LocalDateTime.of(2022,12,9,10,0,0,0));
	}
	
	@PostMapping("/post-localdate")
	public String postLocalDate(@RequestBody LocalDateModel data) {
		log.info(data.getName());
		log.info(data.getDate().toString());
		
		return "post 성공";
	}
	
	
	
	
	@GetMapping("/get-offsetdate")
	public String getOffsetDate(OffSetDateTimeModel data) {		
		log.info(data.getName());
		log.info(data.getDate().toString());
		
		return "get 성공";	
	}
	
	@GetMapping("/get-offsetdate2")
	public String getOffsetDate2(OffSetDateTimeModel date) {				
		log.info(date.toString());
		
		return "get 성공";	
	}
}
