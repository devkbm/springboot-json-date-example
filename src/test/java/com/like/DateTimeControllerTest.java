package com.like;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(DateTimeController.class)
class DateTimeControllerTest {
	
	@Autowired
    private MockMvc mockMvc;	
	
	@DisplayName("GET 요청시 json -> LocalDateTime 변환 테스트(ModelAttribute)")
	@Test
	void GET_LocalDateTime_변환_테스트() throws Exception {
		//given
		String url = "/get-localdate?name=test&date=2022-12-09T04:22:08.370";
		
		//when
		ResultActions resultActions = this.mockMvc.perform(get(url));
		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("get 성공")));		
	}
	
	@DisplayName("GET 요청시 json -> LocalDateTime 변환 테스트(RequestParam)")
	@Test
	void GET_LocalDateTime_변환2_테스트() throws Exception {
		//given
		String url = "/get-localdate2?date=2022-12-09T04:22:08.370";
		
		//when
		ResultActions resultActions = this.mockMvc.perform(get(url));
		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("get 성공")));		
	}
	
	@DisplayName("GET 응답시 json -> LocalDateTime 변환 테스트(RequestParam)")
	@Test
	void GET_LocalDateTime_변환3_테스트() throws Exception {
		//given
		String url = "/get-localdate3";
		
		//when
		ResultActions resultActions = this.mockMvc.perform(get(url));
		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(content().json("{\"name\":\"test\", \"date\":\"2022-12-09T10:00:00\"}"));		
	}
	
	@DisplayName("POST 요청시 json -> LocalDateTime 변환 테스트(RequestBody)")
	@Test
	void POST_LocalDateTime_변환_테스트() throws Exception {
		//given
		String url = "/post-localdate";
		
		//when
		ResultActions resultActions = this.mockMvc.perform(
				post(url).contentType(MediaType.APPLICATION_JSON)
						 .content("{\"name\":\"test\", \"date\":\"2022-12-09T04:22:08.370\"}"));
		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("post 성공")));		
	}
	
	
	
	@DisplayName("GET 요청시 json -> OffsetDateTime 변환 테스트(ModelAttribute)")
	@Test
	void OffsetDateTime_변환_테스트() throws Exception {
		//given
		String url = "/get-offsetdate?name=test&date=2022-12-09T04:22:08.370Z";	
		
		//when
		ResultActions resultActions = this.mockMvc.perform(get(url));
		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("get 성공")));		
	}

	@DisplayName("GET 요청시 json -> OffsetDateTime 변환 테스트(RequestParam)")
	@Test
	void OffsetDateTime_변환2_테스트() throws Exception {
		//given
		String url = "/get-offsetdate2?date=2022-12-09T04:22:08.370Z";	
		
		//when
		ResultActions resultActions = this.mockMvc.perform(get(url));
		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("get 성공")));		
	}
}
